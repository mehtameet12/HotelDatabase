package com.Hotels;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HotelchainService {
    public List<Hotelchain> getHotelchain() throws Exception{
        // sql query
        String sql = "SELECT * FROM HotelChain.hotelchain";
        // connection object
        ConnectionDB db = new ConnectionDB();

        // data structure to keep all hotelchains retrieved from database
        List<Hotelchain> hotelchains = new ArrayList<Hotelchain>();

        try (Connection con = db.getConnection()) {
            // prepare statement
            PreparedStatement stmt = con.prepareStatement(sql);

            // get the results from executing the query
            ResultSet rs = stmt.executeQuery();

            // iterate through the result set
            while (rs.next()) {
                // create new student object
                Hotelchain hotelchain = new Hotelchain(
                        rs.getString("name"),
                        rs.getInt("totalhotels"),
                        rs.getString("address"),
                        rs.getString("email"),
                        rs.getString("phoneno")
                );

                // append student in students list
                hotelchains.add(hotelchain);
            }

                // close result set
                rs.close();
                // close statement
                stmt.close();
                con.close();
                db.close();

                // return result
                return hotelchains;
        }catch (Exception e) {
                throw new Exception(e.getMessage());
        }
    }

    public String createHotelchain(Hotelchain hotelchain) throws Exception {
        String message = "";
        Connection con = null;

        // connection object
        ConnectionDB db = new ConnectionDB();

        // sql query
        String insertStudentQuery = "INSERT INTO hotelchain (name, totalhotels, address, email, phoneno) VALUES (?, ?, ?, ?, ?);";

        // try to connect to database, catch any exceptions
        try {
            con = db.getConnection(); //get Connection

            // prepare the statement
            PreparedStatement stmt = con.prepareStatement(insertStudentQuery);

            // set every ? of statement
            stmt.setString(1, hotelchain.getName());
            stmt.setInt(2, hotelchain.getTotalHotels());
            stmt.setString(3, hotelchain.getAddress());
            stmt.setString(4, hotelchain.getEmail());
            stmt.setString(5, hotelchain.getPhoneno());

            // execute the query
            stmt.executeUpdate();

            // close the statement
            stmt.close();
            // close the connection
            db.close();
        } catch (Exception e) {
            message = "Error while inserting Hotel Chain: " + e.getMessage();
        }finally {
            if (con != null) // if connection is still open, then close.
                con.close();
            if (message.equals("")) message = "Hotel Chain successfully inserted!";
        }
        // return respective message
        return message;
    }

    public String updateHotelchains(Hotelchain hotelchain) throws Exception {
        Connection con = null;
        String message = "";
        // sql query
        String sql = "UPDATE hotelchain SET totalhotels=?, address=?, email=?, phoneno=? WHERE name=?;";

        // connection object
        ConnectionDB db = new ConnectionDB();

        // try connect to database, catch any exceptions
        try {
            // get connection
            con = db.getConnection();

            // prepare the statement
            PreparedStatement stmt = con.prepareStatement(sql);

            // set every ? of statement
            stmt.setInt(1, hotelchain.getTotalHotels());
            stmt.setString(2, hotelchain.getAddress());
            stmt.setString(3, hotelchain.getEmail());
            stmt.setString(4, hotelchain.getPhoneno());
            stmt.setString(5, hotelchain.getName());

            // execute the query
            stmt.executeUpdate();

            // close the statement
            stmt.close();

        } catch (Exception e) {
            message = "Error while updating Hotel Chain: " + e.getMessage();

        } finally {
            if (con != null) con.close();
            if (message.equals("")) message = "Hotel Chain successfully updated!";
        }

        // return respective message
        return message;
    }

}
