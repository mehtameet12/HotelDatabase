<%--
  Created by IntelliJ IDEA.
  User: Anisaftab
  Date: 2023-03-27
  Time: 3:25 p.m.
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
                <li class="nav-item"><a class="nav-link active" href="index.jsp">Booking</a></li>
                <li class="nav-item"><a class="nav-link" href="checkin.jsp">Check-in</a></li>
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
        <div class="container" style="margin-bottom: 5px;">
            <div class="heading"></div>
            <form style="margin-top: 10px;" action="/HotelDatabase/addEmployee" method="post">
                <h2>EMPLOYEE INFO</h2>
                <div class="mb-3"><label class="form-label" >Employee Name</label><input class="form-control item" type="text" name="name" required></div>
                <div class="mb-3"><label class="form-label" >Hotel-ID</label><input class="form-control" type="number" name="hotelid" required></div>
                <div class="mb-3"><label class="form-label" >SIN No.</label><input class="form-control item" type="number" name="sin" required></div>
                <div class="mb-3"><label class="form-label" >Address</label><input class="form-control item" type="text" name="address" required></div>
                <div class="mb-3"><label class="form-label" >Role</label><select class="form-select" name="role">
                    <optgroup label="Select Roles">
                        <option value="Housekeeping" >Housekeeping</option>
                        <option value="Maintenance">Maintenance</option>
                        <option value="Front Desk">Front Desk</option>
                    </optgroup>
                </select></div>
                <div class="mb-3"><button class="btn btn-primary btn-lg d-block w-100" type="submit">Add Employee</button></div>
            </form>
            <form style="margin-top: 10px;" action="/HotelDatabase/addRoom" method="post">
                <h2>ADD ROOM</h2>
                <div class="mb-3"><label class="form-label" >Hotel-ID</label><input class="form-control" type="number" name="hotelid" required></div>
                <div class="mb-3"><label class="form-label" >Room No.</label><input class="form-control item" type="number"  name="roomid" required></div>
                <div class="mb-3"><label class="form-label" >Capacity</label><select class="form-select" name="capacity" required>
                    <optgroup label="Input Capacity">
                        <option value="2" selected="">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                    </optgroup>
                </select></div>
                <div class="mb-3"></div>
                <div class="mb-3"><label class="form-label" >View</label><select class="form-select" id="subject-6" name="roomview">
                    <optgroup label="View">
                        <option value="Mountain view" selected="">Mountain view</option>
                        <option value="Sea view">Sea view</option>
                        <option value="City view">City view</option>
                        <option value="Garden view">Garden view</option>
                    </optgroup>
                </select></div>
                <div class="mb-3"><label class="form-label" >Price</label><input class="form-control item" type="number" name="price" required></div>
                <div class="mb-3"><label class="form-label" >Amenities</label><input class="form-control item" type="text"  name="amenities"></div>
                <div class="mb-3"><label class="form-label" >Extension</label><select class="form-select"name="extension" >
                    <optgroup label="Extension Possible">
                        <option value="true" selected="">Yes</option>
                        <option value="false">No</option>
                    </optgroup>
                </select></div>
                <div class="mb-3"><label class="form-label" >Problems/Damages</label><input class="form-control item" type="text" name="damages" id="subject-13" style="height: 75px;"></div>
                <button class="btn btn-primary btn-lg d-block w-100" type="submit">Add Room</button>
            </form>
            <form style="margin-top: 10px;" action="/HotelDatabase/addHotel" method="post">
                <h2>ADD HOTEL</h2>

                <div class="mb-3"><label class="form-label">Select Hotel Chain</label><select class="form-select" id="subject-7" name ="name">
                    <optgroup label="Hotel Chains">
                        <option value="Marriott" selected="">Marriott</option>
                        <option value="Hayat">Hayat</option>
                        <option value="Hilton">Hilton</option>
                        <option value="ResidenceInn">Residence Inn</option>
                        <option value="4Seasons">4 Seasons</option>
                    </optgroup>
                </select></div>
                <div class="mb-3"><label class="form-label" >Location</label><input class="form-control item" type="text" id="subject-3" min="8" name="address" required></div>
                <div class="mb-3"><label class="form-label" >Hotel Category</label><select class="form-select" id="subject-12" name="category">
                    <optgroup label="Star Hotels">
                        <option value="1" selected="">1 Star</option>
                        <option value="2">2 Star</option>
                        <option value="3">3 Star</option>
                        <option value="4">4 Star</option>
                        <option value="5">5 Star</option>
                    </optgroup>
                </select></div>
                <div class="mb-3"><label class="form-label" >Total No. of Rooms</label><input class="form-control item" type="number"  min="8" name="totalrooms" required></div>
                <div class="mb-3"></div><button class="btn btn-primary btn-lg d-block w-100" type="submit">Add Hotel</button>
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
