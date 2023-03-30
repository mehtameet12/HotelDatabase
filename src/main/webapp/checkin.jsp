<%--
  Created by IntelliJ IDEA.
  User: Anisaftab
  Date: 2023-03-27
  Time: 2:57 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Book Your Dream Vacation</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato:300,400,700&amp;display=swap">
    <link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="assets/css/pikaday.min.css">
</head>

<body>
<jsp:include page="navbar.jsp"></jsp:include>

<main class="page hire-me-page">
    <section class="portfolio-block hire-me">
        <div class="container">
            <div class="heading">
                <h2>CHECK-IN PORTAL</h2>
            </div>
            <form action="/HotelDatabase/checkIn" method="post">
                <div class="mb-3">

                    <form  >
                        <div class="mb-3"><label class="form-label" >Customer SIN</label><input class="form-control item" type="number" name="custid" required></div>
                        <div class="mb-3"><label class="form-label" >Room No.</label><input class="form-control item" type="number"  name="roomid" required></div>
                        <h3>PAYMENT INFO</h3>
                        <div class="mb-3"><label class="form-label" >Full Name(on the card)</label><input class="form-control item" placeholder="Jeff Doe" type="text"  name="roomid" required></div>

                        <div class="form-group">
                            <label >Card number</label>
                            <div class="input-group">
                                <input type="text" name="cardNumber" placeholder="Your card number" class="form-control" name="cardno" required>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-8">
                                <div class="form-group">
                                    <label><span class="hidden-xs">Expiration</span></label>
                                    <div class="input-group">
                                        <input type="number" placeholder="MM" name="" class="form-control" required>
                                        <input type="number" placeholder="YY" name="" class="form-control" required>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-4">
                                <div class="form-group mb-4">
                                    <label data-toggle="tooltip" title="Three-digits code on the back of your card">CVV
                                    </label>
                                    <input type="number" required class="form-control">
                                </div>
                            </div>
                        </div>
                        <button class="btn btn-primary btn-lg d-block w-100" id="show-btn"  type="submit" >Check-in</button>
                    </form>
                </div>
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