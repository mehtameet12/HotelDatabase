package com.Hotels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

    public void updateCustomer(String name, String address)throws SQLException{
        String sql = "INSERT INTO hotelchainschema.customer (name, address) VALUES (?, ?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.setString(2, address);
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