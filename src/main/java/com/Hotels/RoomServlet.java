package com.Hotels;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.Writer;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("/roomSearch")
public class RoomServlet extends HttpServlet {
    List<Room> rooms = null;
    RoomService roomService = new RoomService();
    String hotelChainName;
    String hotelAddress;
    public void init(ServletConfig config) {
        System.out.println("Servlet is being initialized");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        hotelChainName = request.getParameter("hotelchainname");
        hotelAddress = request.getParameter("address");
//        String startDate = request.getParameter("fromdate");
//        Date fromDate = Date.valueOf(startDate);
//        String endDate = request.getParameter("todate");
//        Date toDate = Date.valueOf(endDate);
//        Integer category = Integer.valueOf(request.getParameter("category"));
//        String price = request.getParameter("price");
//        String roomView = request.getParameter("roomview");
//        Integer capacity = Integer.valueOf(request.getParameter("capacity"));


        System.out.println(hotelChainName);
        System.out.println(hotelAddress);
//        System.out.println(fromDate);
//        System.out.println(toDate);
//        System.out.println(category);
//        System.out.println(price);
//        System.out.println(roomView);
//        System.out.println(capacity);
        ConnectionDB con = new ConnectionDB();
        try {
            con.getConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }



//        try {
//            response.sendRedirect("room.jsp");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        // set the attributes in the request object
        request.setAttribute("hotelChainName", hotelChainName);
        request.setAttribute("hotelAddress", hotelAddress);

        // forward the request to the room.jsp file
        RequestDispatcher dispatcher = request.getRequestDispatcher("room.jsp");
        dispatcher.forward(request, response);

    }

    public String getHotelChainName(){
        return hotelChainName;
    }
    public String getHotelAddress(){
        return hotelAddress;
    }


}
