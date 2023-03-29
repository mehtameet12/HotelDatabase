package com.Hotels;


import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/addRoom")
public class NewRoomServlet extends HttpServlet {

    public void init(ServletConfig config) {
        System.out.println("Servlet is being initialized");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer hotelID = Integer.valueOf(request.getParameter("hotelid"));
        Integer roomID = Integer.valueOf(request.getParameter("roomid"));
        Integer capacity = Integer.valueOf(request.getParameter("capacity"));
        String roomView = request.getParameter("roomview");
        Integer price = Integer.valueOf(request.getParameter("price"));
        String[] amenities = (request.getParameter("amenities")).split(",");
        Boolean extension = Boolean.getBoolean(request.getParameter("extension"));
        String damages = request.getParameter("damages");
        Boolean status = false;



        ConnectionDB con = new ConnectionDB();

        try {
            con.getConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            con.insertRoom(roomID, capacity, status, price, roomView, extension, damages,amenities, hotelID);
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }



    public void destroy() {
        System.out.println("Servlet is being destroyed");
    }

    
}
