package com.Hotels;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


@WebServlet("/updateCustomer")
public class CustomerServlet extends HttpServlet {

    public void init(ServletConfig config) {
        System.out.println("Servlet is being initialized");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerName = request.getParameter("name");
        String customerAddress = request.getParameter("address");

        ConnectionDB con = new ConnectionDB();

        try {
            con.getConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            con.updateCustomer(customerName, customerAddress);
            System.out.println("Successfull");
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
        System.out.println("Servlet is being destroyed");
    }
}



