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
    String hotelChainName;
    String hotelAddress;
    String category;
    String endDate;
    String startDate;
    String price;
    String roomView;
    String capacity;

    public void init(ServletConfig config) {
        System.out.println("Servlet is being initialized");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        hotelChainName = request.getParameter("hotelchainname");
        hotelAddress = request.getParameter("address");
        startDate = request.getParameter("fromdate");
        //Date fromDate = Date.valueOf(startDate);
        endDate = request.getParameter("todate");
        //Date toDate = Date.valueOf(endDate);
        category = request.getParameter("category");
        price = request.getParameter("price");
        roomView = request.getParameter("roomview");
        capacity = request.getParameter("capacity");


        System.out.println(hotelChainName);
        System.out.println(hotelAddress);
        System.out.println(startDate);
        System.out.println(endDate);
        System.out.println(category);
        System.out.println(price);
        System.out.println(roomView);
        System.out.println(capacity);
        ConnectionDB con = new ConnectionDB();
        try {
            con.getConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // set the attributes in the request object
        request.setAttribute("hotelChainName", hotelChainName);
        request.setAttribute("hotelAddress", hotelAddress);
        request.setAttribute("category", category);
        request.setAttribute("roomView", roomView);
        request.setAttribute("price", price);
        request.setAttribute("capacity", capacity);


        // forward the request to the room.jsp file
        RequestDispatcher dispatcher = request.getRequestDispatcher("room.jsp");
        dispatcher.forward(request, response);

    }


}
