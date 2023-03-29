package com.Hotels;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoomService {
    String hotelChainName;
    String hotelAddress;
    public List<Room> getRoomService(String r) throws Exception{
        // sql query
        String sql = "SELECT * FROM hotelchainschema.rooms";
        String request = r;
        // connection object
        ConnectionDB db = new ConnectionDB();

//        RoomServlet roomservlet = new RoomServlet();
//        String hotelChainName= roomservlet.getHotelChainName();
//        String hotelAddress = roomservlet.getHotelAddress();

        // data structure to keep all hotelchains retrieved from database
        List<Room> rooms = new ArrayList<Room>();

        try (Connection con = db.getConnection()) {
            // prepare statement
            PreparedStatement stmt = con.prepareStatement(request);
//            stmt.setString(1,hotelAddress);
//            stmt.setString(2,hotelChainName);
            // get the results from executing the query
            ResultSet rs = stmt.executeQuery();

            // iterate through the result set
            while (rs.next()) {
                // create new hoelchain object
                Room room = new Room(
                        rs.getInt("roomid"),
                        rs.getInt("capacity"),
                        rs.getBoolean("status"),
                        rs.getInt("price"),
                        rs.getString("roomview"),
                        rs.getBoolean("extension"),
                        rs.getString("damages"),
                        rs.getString("amenities"),
                        rs.getInt("hotelid")
                );
                // append hotelchain in hotelchain list
                rooms.add(room);
            }
            // close result set
            rs.close();
            // close statement
            stmt.close();
            con.close();
            db.close();
            // return result
            return rooms;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Room> availableRooms () throws Exception
    {
        // sql query
        String request = "SELECT r.roomid, r.capacity, r.status, r.price, r.roomview, r.extension, r.damages, r.amenities, r.hotelid " +
                "FROM hotelchainschema.rooms r " +
                "INNER JOIN hotelchainschema.hotels h ON r.hotelid = h.hotelid " +
                "INNER JOIN hotelchainschema.hotelchain hc ON h.name = hc.name " +
                "WHERE r.status = true AND h.address = ? AND hc.name = ?";

        // connection object
        ConnectionDB db = new ConnectionDB();

        // data structure to keep all hotelchains retrieved from database
        List<Room> rooms = new ArrayList<Room>();

        try (Connection con = db.getConnection()) {
            // prepare statement
            PreparedStatement stmt = con.prepareStatement(request);
            RoomServlet roomservlet = new RoomServlet();
            hotelChainName =  roomservlet.getHotelChainName();
            hotelAddress = roomservlet.getHotelAddress();
            stmt.setString(1,hotelAddress);
            stmt.setString(2,hotelChainName);
            // get the results from executing the query
            ResultSet rs = stmt.executeQuery();

            // iterate through the result set
            while (rs.next()) {
                // create new hoelchain object
                Room room = new Room(
                        rs.getInt("roomid"),
                        rs.getInt("capacity"),
                        rs.getBoolean("status"),
                        rs.getInt("price"),
                        rs.getString("roomview"),
                        rs.getBoolean("extension"),
                        rs.getString("damages"),
                        rs.getString("amenities"),
                        rs.getInt("hotelid")
                );
                // append hotelchain in hotelchain list
                rooms.add(room);
            }
            // close result set
            rs.close();
            // close statement
            stmt.close();
            con.close();
            db.close();
            // return result
            return rooms;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    public void setHotelChainName (String hotelChainName){
        this.hotelChainName = hotelChainName;
    }
    public void setHotelAddress(String hotelAddress){
        this.hotelAddress = hotelAddress;
    }


}
