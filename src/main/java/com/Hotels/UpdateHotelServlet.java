package com.Hotels;


import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/updateHotel")
public class UpdateHotelServlet extends HttpServlet {

    public void init(ServletConfig config) {
        System.out.println("Servlet is being initialized");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer hotelID = Integer.valueOf(request.getParameter("hotelid"));
        Integer hotelCategory = Integer.valueOf(request.getParameter("category"));
        String hotelAddress = request.getParameter("address");
        String totalRooms = (request.getParameter("totalrooms"));


        ConnectionDB con = new ConnectionDB();

        try {
            con.getConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            con.updateHotel(hotelCategory,hotelAddress, totalRooms, hotelID);
            con.close();
            response.sendRedirect("success.jsp");
        } catch (SQLException e) {
            response.sendRedirect("fail.jsp");

        } catch (Exception f){
            response.sendRedirect("fail.jsp");
        }


    }



    public void destroy() {
        System.out.println("Servlet is being destroyed");
    }

    
}
