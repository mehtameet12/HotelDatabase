package com.Hotels;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.Writer;
import java.sql.*;
import java.util.List;

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

        ConnectionDB con = new ConnectionDB();
        try {
            con.getConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        RoomService roomService = new RoomService();
        List<Room> rooms = null;
        try {
            rooms = roomService.availableRooms(hotelChainName, hotelAddress);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public String getHotelChainName(){
        return hotelChainName;
    }
    public String getHotelAddress(){
        return hotelAddress;
    }

}
