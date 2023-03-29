package com.Hotels;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.Writer;
import java.sql.*;
@WebServlet("/room")
public class RoomServlet extends HttpServlet {
    String hotelChainName;
    String hotelAddress;
    public void init(ServletConfig config) {
        System.out.println("Servlet is being initialized");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        hotelChainName = request.getParameter("hotelchainname");
        hotelAddress = request.getParameter("address");
        System.out.println("Hotel Chain Name: " + hotelChainName);
        System.out.println("Hotel Address: " + hotelAddress);
        ConnectionDB con = new ConnectionDB();
        try {
            con.getConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public String getHotelChainName(){
        return hotelChainName;
    }
    public String getHotelAddress(){
        return hotelAddress;
    }

}
