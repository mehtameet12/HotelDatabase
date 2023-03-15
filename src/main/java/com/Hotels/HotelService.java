package com.Hotels;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HotelService {

    public List<Hotel> getHotel() throws Exception{
        // sql query
        String sql = "SELECT * FROM hotelchainschema.hotels";
        // connection object
        ConnectionDB db = new ConnectionDB();

        // data structure to keep all hotelchains retrieved from database
        List<Hotel> hotels = new ArrayList<Hotel>();

        try (Connection con = db.getConnection()) {
            // prepare statement
            PreparedStatement stmt = con.prepareStatement(sql);

            // get the results from executing the query
            ResultSet rs = stmt.executeQuery();

            // iterate through the result set
            while (rs.next()) {
                //create new hotel object
                Hotel hotel = new Hotel(
                        rs.getInt("hotelid"),
                        rs.getInt("category"),
                        rs.getString("address"),
                        rs.getInt("totalrooms"),
                        rs.getString("name")
                );

                //append hotels in hotels list
                hotels.add(hotel);
            }

            // close result set
            rs.close();
            // close statement
            stmt.close();
            con.close();
            db.close();

            // return result
            return hotels;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public String createHotel(Hotel hotel) throws Exception {
        String message = "";
        Connection con = null;

        // connection object
        ConnectionDB db = new ConnectionDB();

        // sql query
        String insertStudentQuery = "INSERT INTO hotels (hotelid, category, address, totalrooms, name) VALUES (?, ?, ?, ?, ?);";

        // try to connect to database, catch any exceptions
        try {
            con = db.getConnection(); //get Connection

            // prepare the statement
            PreparedStatement stmt = con.prepareStatement(insertStudentQuery);

            // set every ? of statement
            stmt.setInt(1, hotel.getHotelid());
            stmt.setInt(2, hotel.getCategory());
            stmt.setString(3, hotel.getAddress());
            stmt.setInt(4, hotel.getTotalrooms());
            stmt.setString(5, hotel.getName());

            // execute the query
            stmt.executeUpdate();

            // close the statement
            stmt.close();
            // close the connection
            db.close();
        } catch (Exception e) {
            message = "Error while inserting Hotel: " + e.getMessage();
        }finally {
            if (con != null) // if connection is still open, then close.
                con.close();
            if (message.equals("")) message = "Hotel successfully inserted!";
        }
        // return respective message
        return message;
    }

    public String updateHotel(Hotel hotel) throws Exception {
        Connection con = null;
        String message = "";
        // sql query
        String sql = "UPDATE hotels SET category=?, address=?, totalrooms=?, name=? WHERE hotelid=?;";

        // connection object
        ConnectionDB db = new ConnectionDB();

        // try connect to database, catch any exceptions
        try {
            // get connection
            con = db.getConnection();

            // prepare the statement
            PreparedStatement stmt = con.prepareStatement(sql);

            // set every ? of statement

            stmt.setInt(1, hotel.getCategory());
            stmt.setString(2, hotel.getAddress());
            stmt.setInt(3, hotel.getTotalrooms());
            stmt.setString(4, hotel.getName());
            stmt.setInt(5, hotel.getHotelid());

            // execute the query
            stmt.executeUpdate();

            // close the statement
            stmt.close();

        } catch (Exception e) {
            message = "Error while updating Hotel: " + e.getMessage();

        } finally {
            if (con != null) con.close();
            if (message.equals("")) message = "Hotel successfully updated!";
        }

        // return respective message
        return message;
    }
}
