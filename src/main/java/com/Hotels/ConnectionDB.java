package com.Hotels;

import java.sql.*;

public class ConnectionDB {

    /* Database connection settings, change dbName, dbusername, dbpassword */
    private final String ipAddress = "127.0.0.1";
    private final String dbServerPort = "5432";
    private final String dbName = "DataBF";
    //dbName = "Hotel" for anis
    private final String dbusername = "postgres";
    private final String dbpassword = "Summer8393";


    private Connection con = null;

    /**
     * Establishes a connection with the database, initializes and returns
     * the Connection object.
     *
     * @return Connection, the Connection object
     * @throws Exception
     */
    public Connection getConnection() throws Exception {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://"
                    + ipAddress + ":" + dbServerPort + "/" + dbName, dbusername, dbpassword);
            return con;
        } catch (Exception e) {

            throw new Exception("Could not establish connection with the Database Server: "
                    + e.getMessage());
        }

    }

    public void insertEmployee(Integer empid, String name, String address, String emprole) throws SQLException {
        String sql = "INSERT INTO hotelchainschema.employee (empid, name, address, emprole) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, empid);
        pstmt.setString(2, name);
        pstmt.setString(3, address);
        pstmt.setString(4, emprole);
        pstmt.executeUpdate();
    }

    public void insertCustomer(Integer custid, String name, String address, Date regdate) throws SQLException {
        String sql = "INSERT INTO hotelchainschema.customer (custid, name, address, regdate) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, custid);
        pstmt.setString(2, name);
        pstmt.setString(3, address);
        pstmt.setDate(4, regdate);
        pstmt.executeUpdate();
    }

    public void checkInCustomer(Integer custid, String name, String address, Date regdate, Integer roomId) throws SQLException {
        String sql = "INSERT INTO hotelchainschema.customer (custid, name, address, regdate, roomId) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, custid);
        pstmt.setString(2, name);
        pstmt.setString(3, address);
        pstmt.setDate(4, regdate);
        pstmt.setInt(5, roomId);
        pstmt.executeUpdate();

        String roomUpdateQuery = "UPDATE hotelchainschema.rooms SET status=false WHERE roomid=?";
        PreparedStatement pstmt2 = con.prepareStatement(roomUpdateQuery);
        pstmt2.setInt(1,roomId);
        pstmt2.executeUpdate();
    }

    public void insertRoom(Integer roomid, Integer capacity, Boolean status, Integer price, String roomview, Boolean extension, String damages,String[] amenitiesArr, Integer hotelid) throws SQLException{
        Array amenities = con.createArrayOf("VARCHAR",amenitiesArr);
        String sql = "INSERT INTO hotelchainschema.rooms (roomid, capacity, status, price, roomview, extension, damages, amenities , hotelid) VALUES (?, ?, ?, ?,?, ?, ?, ?,? )";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1,roomid);
        pstmt.setInt(2,capacity);
        pstmt.setBoolean(3,status);
        pstmt.setInt(4, price);
        pstmt.setString(5, roomview);
        pstmt.setBoolean(6,extension);
        pstmt.setString(7,damages);
        pstmt.setArray(8, amenities);
        pstmt.setInt(9,hotelid);
        pstmt.executeUpdate();
    }

    public void insertHotel(Integer category, String address, Integer totalrooms, String name) throws SQLException{
        String sql = "INSERT INTO hotelchainschema.hotels (category,address,totalrooms,name) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, category);
        pstmt.setString(2, address);
        pstmt.setInt(3, totalrooms);
        pstmt.setString(4, name);
        pstmt.executeUpdate();
    }

    public void updateCustomer(int custId, String name, String address, Date entryDate) throws SQLException {
        String sql = "UPDATE hotelchainschema.customer SET name=?, address=?, regdate=? WHERE custid=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.setString(2, address);
        pstmt.setDate(3, entryDate);
        pstmt.setInt(4, custId);
        pstmt.executeUpdate();
    }






    /**
     * Close database connection. It is very important to close the database connection
     * after it is used.
     *
     * @throws SQLException
     */
    public void close() throws SQLException {
        try {
            if (con != null)
                con.close();
        } catch (SQLException e) {
            throw new SQLException("Could not close connection with the Database Server: "
                    + e.getMessage());
        }

    }
}