package com.Hotels;


import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.Writer;
import java.sql.*;

@WebServlet("/addEmployee")
public class EmployeeServlet extends HttpServlet {

        public void init(ServletConfig config) {
        System.out.println("Servlet is being initialized");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String employeeName = request.getParameter("name");
        String employeeSIN = request.getParameter("sin");
        String employeeAddress = request.getParameter("address");
        String employeeRole = request.getParameter("role");


        ConnectionDB con = new ConnectionDB();

        try {
            con.getConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {

            con.insertEmployee(Integer.valueOf(employeeSIN), employeeName, employeeAddress, employeeRole);
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
