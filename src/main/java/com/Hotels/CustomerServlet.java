package com.Hotels;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {

    public void init(ServletConfig config) {
        System.out.println("Servlet is being initialized");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerName = request.getParameter("name");
        String customerAddress = request.getParameter("address");
        String customerPhone = request.getParameter("phone");
        String customerSIN = request.getParameter("sin");



    }

    public void destroy() {
        System.out.println("Servlet is being destroyed");
    }
}



