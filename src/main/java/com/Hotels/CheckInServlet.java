package com.Hotels;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/checkIn")
public class CheckInServlet extends HttpServlet {

    public void init(ServletConfig config) {
        System.out.println("Servlet is being initialized");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer customerID = Integer.valueOf(request.getParameter("custid"));
        Integer roomID = Integer.valueOf(request.getParameter("roomid"));



        ConnectionDB con = new ConnectionDB();

        try {
            con.getConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            con.inPersonCheckIn(customerID,roomID);
            con.close();
            response.sendRedirect("checkinsuccess.jsp");
        } catch (SQLException e) {
            response.sendRedirect("fail.jsp");
        } catch (Exception f){
            response.sendRedirect("fail.jsp");
        }

    }


}
