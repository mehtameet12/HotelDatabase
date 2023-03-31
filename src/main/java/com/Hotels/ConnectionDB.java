package com.Hotels;

import java.sql.*;

public class ConnectionDB {

    /* Database connection settings, change dbName, dbusername, dbpassword */
    private final String ipAddress = "127.0.0.1";
    private final String dbServerPort = "5432";
    private final String dbName = "DataBF";
    //dbName = "Hotel" for anis
    private final String dbusername = "postgres";
    private final String dbpassword = "anis0710";


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

    public void insertEmployee(Integer empid, String name, String address, String emprole, Integer hotelId) throws SQLException {
        String sql = "INSERT INTO hotelchainschema.employee (empid, name, address, emprole,hotelid) VALUES (?, ?, ?, ?,?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, empid);
        pstmt.setString(2, name);
        pstmt.setString(3, address);
        pstmt.setString(4, emprole);
        pstmt.setInt(5, hotelId);
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

    public void checkInCustomer(Integer custid, String name, String address, Date regdate, Integer roomId, String fromDate, String toDate) throws SQLException {
        String sql = "INSERT INTO hotelchainschema.customer (custid, name, address, regdate, roomId) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, custid);
        pstmt.setString(2, name);
        pstmt.setString(3, address);
        pstmt.setDate(4, regdate);
        pstmt.setInt(5, roomId);
        pstmt.executeUpdate();

        String roomUpdateQuery = "UPDATE hotelchainschema.rooms SET status='Rented', date_from=?, date_to=? WHERE roomid=?";
        PreparedStatement pstmt2 = con.prepareStatement(roomUpdateQuery);
        pstmt2.setDate(1,java.sql.Date.valueOf(fromDate));
        pstmt2.setDate(2,java.sql.Date.valueOf(toDate));
        pstmt2.setInt(3,roomId);
        pstmt2.executeUpdate();
    }

    public void inPersonCheckIn(Integer customerID, Integer roomID) throws SQLException {
        String roomUpdateQuery = "UPDATE hotelchainschema.rooms SET status=? WHERE roomid=?";
        PreparedStatement pstmt = con.prepareStatement(roomUpdateQuery);
        String rent = "Rented";
        pstmt.setString(1,rent);
        pstmt.setInt(2,roomID);
        pstmt.executeUpdate();

        String sql = "UPDATE hotelchainschema.customer SET roomid=? WHERE custid=? ";
        PreparedStatement pstmt2 = con.prepareStatement(sql);
        pstmt2.setInt(1, roomID);
        pstmt2.setInt(2, customerID);
        pstmt2.executeUpdate();


    }


    public void insertRoom(Integer roomid, Integer capacity, String status, Integer price, String roomview, Boolean extension, String damages, String[] amenitiesArr, Integer hotelid) throws SQLException {
        Array amenities = con.createArrayOf("VARCHAR", amenitiesArr);

        String sql = "INSERT INTO hotelchainschema.rooms (roomid, capacity, status, price, roomview, extension, damages, amenities , hotelid) VALUES (?, ?, ?, ?,?, ?, ?, ?,? )";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, roomid);
        pstmt.setInt(2, capacity);
        pstmt.setString(3, status);
        pstmt.setInt(4, price);
        pstmt.setString(5, roomview);
        pstmt.setBoolean(6, extension);
        pstmt.setString(7, damages);
        pstmt.setArray(8, amenities);
        pstmt.setInt(9, hotelid);
        pstmt.executeUpdate();
    }

    public void insertHotel(Integer category, String address, Integer totalrooms, String name) throws SQLException {
        String sql = "INSERT INTO hotelchainschema.hotels (category,address,totalrooms,name) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, category);
        pstmt.setString(2, address);
        pstmt.setInt(3, totalrooms);
        pstmt.setString(4, name);
        pstmt.executeUpdate();

        String getSQL = "UPDATE hotelchainschema.hotelchain SET totalhotels = totalhotels + 1 where name=?";
        PreparedStatement st = con.prepareStatement(getSQL);
        st.setString(1, name);
        st.executeUpdate();
    }

    public void updateCustomer(int custId, String name, String address, Date entryDate) throws SQLException {
        if (name == "" && address != ""){
            String sql = "UPDATE hotelchainschema.customer SET address=? WHERE custid=?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, address);
            pstmt.setInt(2, custId);
            pstmt.executeUpdate();
        } else if (address == "" && name != "") {
            String sql = "UPDATE hotelchainschema.customer SET name=? WHERE custid=?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setInt(2, custId);
            pstmt.executeUpdate();

        } else if(name =="" && address == ""){
            return;
        }
        else {
            String sql = "UPDATE hotelchainschema.customer SET name=?, address=? WHERE custid=?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, address);
            pstmt.setInt(3, custId);
            pstmt.executeUpdate();
        }
    }

    public void updateEmployee(Integer empId, String employeeName, String employeeAddress, String employeeRole, Integer hotelId) throws SQLException {

        String getSQL = "SELECT * FROM hotelchainschema.employee WHERE empid=?";
        PreparedStatement st = con.prepareStatement(getSQL);
        st.setInt(1, empId);
        ResultSet rs =  st.executeQuery();
        String newName = "", newAddress = "", newRole = "";
        Integer newHotel = 0;
        while (rs.next()){
            newName = rs.getString(2);
            newAddress = rs.getString(3);
            newRole = rs.getString(4);
            newHotel = rs.getInt(5);

        }
        if (employeeName == ""){
            employeeName = newName;
        }
        if (employeeAddress == ""){
            employeeAddress = newAddress;
        }
        if( employeeRole == ""){
            employeeRole = newRole;
        }
        if (hotelId == null){
            hotelId = newHotel;
        }

            String sql = "UPDATE hotelchainschema.employee SET name=?, address=?, emprole=?, hotelid=? WHERE empid=?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, employeeName);
            pstmt.setString(2, employeeAddress);
            pstmt.setString(3, employeeRole);
            pstmt.setInt(4, hotelId);
            pstmt.setInt(5, empId);
            pstmt.executeUpdate();




    }

    public void updateRoom(Integer roomid, Integer capacity, String status, String price, String roomview, Boolean extension, String damages, String[] amenitiesArr, Integer hotelid) throws SQLException {
        Array amenities = con.createArrayOf("VARCHAR", amenitiesArr);
        String getSQL = "SELECT * FROM hotelchainschema.rooms WHERE roomid=?";
        PreparedStatement st = con.prepareStatement(getSQL);
        st.setInt(1, roomid);
        ResultSet rs =  st.executeQuery();
        String  newDamages = "";
        Integer  oldPrice = 0;
        Array oldAmenities = null;

        while (rs.next()){

            oldPrice = rs.getInt(4);
            newDamages = rs.getString(7);
            oldAmenities = rs.getArray(8);


        }

        Integer newPrice = 0;

        if(price == ""){ newPrice = oldPrice;} else {newPrice = Integer.valueOf(price);}
        if(damages == ""){damages = newDamages;}
        if(amenitiesArr.length == 0 ){amenities = oldAmenities;}




        String sql = "UPDATE hotelchainschema.rooms SET capacity=?, status=?, price=?, roomview=?, extension=?, damages=? , amenities=? WHERE roomid=? AND hotelid=? ";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, capacity);
        pstmt.setString(2, status);
        pstmt.setInt(3, newPrice);
        pstmt.setString(4, roomview);
        pstmt.setBoolean(5, extension);
        pstmt.setString(6, damages);
        pstmt.setArray(7, amenities);
        pstmt.setInt(8, roomid);
        pstmt.setInt(9, hotelid);
        pstmt.executeUpdate();
    }

    public void updateHotel(Integer hotelCategory, String hotelAddress, String totalRooms,  Integer hotelID) throws SQLException {
        String getSQL = "SELECT * FROM hotelchainschema.hotels WHERE hotelid=?";
        PreparedStatement st = con.prepareStatement(getSQL);
        st.setInt(1, hotelID);
        ResultSet rs =  st.executeQuery();
        String oldAddress = "";
        Integer   oldRooms = 0;
        Integer newRooms = 0;
        while (rs.next()){
            oldAddress = rs.getString(3);
            oldRooms = rs.getInt(4);


        }

        if(hotelAddress == ""){hotelAddress = oldAddress;}
        if(totalRooms == ""){newRooms = oldRooms;} else { newRooms = Integer.valueOf(totalRooms);}




        String sql = "UPDATE hotelchainschema.hotels SET  category=?, address=?, totalrooms=? WHERE hotelid=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, hotelCategory);
        pstmt.setString(2, hotelAddress);
        pstmt.setInt(3, newRooms);
        pstmt.setInt(4, hotelID);
        pstmt.executeUpdate();
    }

    public void removeEmployee(Integer empId) throws SQLException {
        String sql = "DELETE FROM hotelchainschema.employee WHERE empid=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1,empId);
        pstmt.executeUpdate();
    }

    public void removeRoom(Integer hotelID, Integer roomID) throws SQLException {
        String sql = "DELETE FROM hotelchainschema.rooms WHERE hotelid=? AND  roomId=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1,hotelID);
        pstmt.setInt(2,roomID);
        pstmt.executeUpdate();
    }
    public void removeHotel(Integer hotelID) throws SQLException {
        try{
            String sql2 = "DELETE FROM hotelchainschema.rooms WHERE hotelid=?";
            String sql3 = "DELETE FROM hotelchainschema.employee WHERE hotelid=?";
            String sql4 = "DELETE FROM hotelchainschema.manager WHERE hotelid=?";

            PreparedStatement pstmt2 = con.prepareStatement(sql2);
            PreparedStatement pstmt3 = con.prepareStatement(sql3);
            PreparedStatement pstmt4 = con.prepareStatement(sql4);
            pstmt2.setInt(1,hotelID);
            pstmt3.setInt(1,hotelID);
            pstmt4.setInt(1,hotelID);
            pstmt2.executeUpdate();
            pstmt3.executeUpdate();
            pstmt4.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            String getSQL = "SELECT * FROM hotelchainschema.hotels WHERE hotelid=?";
            PreparedStatement st = con.prepareStatement(getSQL);
            st.setInt(1, hotelID);
            ResultSet rs =  st.executeQuery();
            String name ="";
            while (rs.next()){
                name = rs.getString(5);

            }
            String sql = "DELETE FROM hotelchainschema.hotels WHERE hotelid=? ";

            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setInt(1,hotelID);

            pstmt.executeUpdate();




            String updateSQL = "UPDATE hotelchainschema.hotelchain SET totalhotels = totalhotels - 1 where name=?";
            PreparedStatement st2 = con.prepareStatement(updateSQL);
            st2.setString(1, name);
            st2.executeUpdate();
        }



    }

    public void removeCustomer(Integer custID) throws SQLException {
        String sql = "DELETE FROM hotelchainschema.customer WHERE custid=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1,custID);
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


