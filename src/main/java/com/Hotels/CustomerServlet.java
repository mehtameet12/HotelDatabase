package com.Hotels;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;


@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {

    public void init(ServletConfig config) {
        System.out.println("Servlet is being initialized");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerName = request.getParameter("name");
        String customerAddress = request.getParameter("address");
        String customerSIN = request.getParameter("sin");
        Date entryDate = Date.valueOf(LocalDate.now());
        ConnectionDB con = new ConnectionDB();

        try {
            con.getConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            con.insertCustomer(Integer.valueOf(customerSIN), customerName, customerAddress, entryDate );
            con.close();
            response.sendRedirect("success.jsp");
        } catch (Exception e) {
            response.sendRedirect("fail.jsp");
        }
    }

    public void destroy() {
        System.out.println("Servlet is being destroyed");
    }
}



