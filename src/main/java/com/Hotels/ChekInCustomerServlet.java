package com.Hotels;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;


@WebServlet("/checkInCustomer")
public class ChekInCustomerServlet extends HttpServlet {

    public void init(ServletConfig config) {
        System.out.println("Servlet is being initialized");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerName = request.getParameter("customerName");
        String customerAddress = request.getParameter("customerAddress");
        String customerSIN = request.getParameter("customerSIN");

        String roomId = request.getParameter("selectedRoomId");
        ConnectionDB con = new ConnectionDB();

        try {
            con.getConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            con.checkInCustomer(Integer.valueOf(customerSIN), customerName, customerAddress, entryDate, Integer.valueOf(roomId) );
            con.close();
            response.sendRedirect("index.jsp");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
        System.out.println("Servlet is being destroyed");
    }
}



