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


@WebServlet("/updateCustomer")
public class UpdateCustomerServlet extends HttpServlet {

    public void init(ServletConfig config) {
        System.out.println("Servlet is being initialized");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String custId = request.getParameter("custid");
        String customerName = request.getParameter("name");
        String customerAddress = request.getParameter("address");
        Date entryDate = Date.valueOf(LocalDate.now());
        ConnectionDB con = new ConnectionDB();
        try {
            con.getConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            con.updateCustomer(Integer.valueOf(custId), customerName, customerAddress, entryDate );
            System.out.println("Successfull");
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



