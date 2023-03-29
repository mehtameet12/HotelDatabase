<%--
  Created by IntelliJ IDEA.
  User: Anisaftab
  Date: 2023-03-27
  Time: 3:24 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Contact - Brand</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato:300,400,700&amp;display=swap">
    <link rel="stylesheet" href="assets/css/pikaday.min.css">
</head>

<body>
<nav class="navbar navbar-dark navbar-expand-lg fixed-top bg-white portfolio-navbar gradient">
    <div class="container"><a class="navbar-brand logo" href="#">Pentago</a><button data-bs-toggle="collapse" class="navbar-toggler" data-bs-target="#navbarNav"><span class="visually-hidden">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item"><a class="nav-link" href="index.jsp">Home</a></li>
                <li class="nav-item"><a class="nav-link active" href="index.jsp">Booking/Check-in</a></li>
                <li class="nav-item"><a class="nav-link" href="addcustomer.jsp">Manage Customers</a></li>
                <li class="nav-item"><a class="nav-link" href="manage.jsp">Add Services</a></li>
                <li class="nav-item"><a class="nav-link" href="updateservices.jsp">Update Services</a></li>
                <li class="nav-item"><a class="nav-link" href="removeservices.jsp">Remove Services</a></li>

            </ul>
        </div>
    </div>
</nav>
<main class="page contact-page">
    <section class="portfolio-block contact">
        <div class="container">
            <div class="heading">
                <h2>Add Customer</h2>
            </div>
            <form action="/HotelDatabase/customer" method="post">
                <div class="mb-3"><label class="form-label" >Customer Name</label><input class="form-control item" type="text" name="name"></div>
                <div class="mb-3"><label class="form-label" >Address</label><input class="form-control item" type="text" name="address"></div>
                <div class="mb-3"><label class="form-label" >SIN</label><input class="form-control item" type="tel" name="sin"></div>

                <div class="mb-3"><button class="btn btn-primary btn-lg d-block w-100" type="submit">Add Customer</button></div>
            </form>
        </div>
    </section>

    <section class="portfolio-block contact">
        <div class="container">
            <div class="heading">
                <h2>Update Customer</h2>
            </div>
            <form action="/HotelDatabase/updateCustomer" method="post">
                <div class="mb-3"><label class="form-label" >CustID</label><input class="form-control item" type="tel" name="custid"></div>
                <div class="mb-3"><label class="form-label" >Customer Name</label><input class="form-control item" type="text" name="name"></div>
                <div class="mb-3"><label class="form-label" >Address</label><input class="form-control item" type="text" name="address"></div>
                <div class="mb-3"><button class="btn btn-primary btn-lg d-block w-100" type="submit">Update Customer</button></div>
            </form>
        </div>
    </section>

</main>
<footer class="page-footer" style="height: 100px;">
    <div class="container">
        <div class="links"><a href="#">About us</a><a href="#">Contact Us</a><a href="#">Terms &amp; Conditions</a></div>
        <div class="social-icons"></div>
    </div>
</footer>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/js/pikaday.min.js"></script>
<script src="assets/js/theme.js"></script>

</body>

</html>