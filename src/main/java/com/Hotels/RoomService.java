package com.Hotels;

import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoomService {
    String hotelChainName;
    String hotelAddress;
    int rowCount;
    int totalCap;
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
                        rs.getString("status"),
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

    public List<Room> availableRooms (HttpServletRequest request, String hotelAddress, String hotelChainName, String hotelCategory, String roomCapacity, String roomView, String roomPrice) throws Exception
    {

        String query = "SELECT r.roomid, r.capacity, r.status, r.price, r.roomview, r.extension, r.damages, r.amenities, r.hotelid " +
                "FROM hotelchainschema.rooms r " +
                "INNER JOIN hotelchainschema.hotels h ON r.hotelid = h.hotelid " +
                "INNER JOIN hotelchainschema.hotelchain hc ON h.name = hc.name " +
                "WHERE r.status = 'Available' ";

        if (hotelChainName != null && !hotelChainName.isEmpty()) {
            query += "AND hc.name = '" + hotelChainName + "' ";
        }
        if (hotelAddress != null && !hotelAddress.isEmpty()) {
            query += "AND h.address = '" + hotelAddress + "' ";
        }
        if (roomView != null && !roomView.isEmpty()) {
            query += "AND r.roomview = '" + roomView + "' ";
        }
        if (hotelCategory != null && !hotelCategory.isEmpty()) {
            query += "AND h.category >= " + Integer.parseInt(hotelCategory) + " ";
        }
        if (roomCapacity != null && !roomCapacity.isEmpty()) {
            query += "AND r.capacity >= " + Integer.parseInt(roomCapacity) + " ";
        }
        if (roomPrice != null && !roomPrice.isEmpty()) {
            query += "AND r.price <= " + Integer.parseInt(roomPrice) + " ";
        }

        // connection object
        ConnectionDB db = new ConnectionDB();


        // data structure to keep all hotelchains retrieved from database
        List<Room> rooms = new ArrayList<Room>();

        try (Connection con = db.getConnection()) {

            // prepare statement
            PreparedStatement stmt = con.prepareStatement(query);

            // get the results from executing the query
            ResultSet rs = stmt.executeQuery();

            //

            // iterate through the result set
            while (rs.next()) {
                // create new hotelchain object
                Room room = new Room(
                        rs.getInt("roomid"),
                        rs.getInt("capacity"),
                        rs.getString("status"),
                        rs.getInt("price"),
                        rs.getString("roomview"),
                        rs.getBoolean("extension"),
                        rs.getString("damages"),
                        rs.getString("amenities"),
                        rs.getInt("hotelid")
                );
                // append hotelchain in hotelchain list
                rooms.add(room);
                rowCount++;
                totalCap = totalCap+ rs.getInt("capacity");
            }
            System.out.println("The row is "+rowCount);
            System.out.println("The total Cap is "+totalCap);
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

    public int getRowCount() {
        return rowCount;
    }

    public int getTotalCap() {
        return totalCap;
    }

}
