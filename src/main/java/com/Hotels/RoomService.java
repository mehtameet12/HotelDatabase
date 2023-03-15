package com.Hotels;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoomService {
    public List<Room> getRoomService() throws Exception{
        // sql query
        String sql = "SELECT * FROM hotelchainschema.rooms";
        // connection object
        ConnectionDB db = new ConnectionDB();

        // data structure to keep all hotelchains retrieved from database
        List<Room> rooms = new ArrayList<Room>();

        try (Connection con = db.getConnection()) {
            // prepare statement
            PreparedStatement stmt = con.prepareStatement(sql);

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


}
