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
<jsp:include page="navbar.jsp"></jsp:include>

<main class="page contact-page">


    <section class="portfolio-block contact">
        <div class="container">
            <div class="heading">
                <h2>Update Employee</h2>
            </div>
            <form action="/HotelDatabase/updateEmployee" method="post">
                <div class="mb-3"><label class="form-label" >Employee SIN</label><input class="form-control item" type="number" name="empid" required></div>
                <div class="mb-3"><label class="form-label" >Employee Name</label><input class="form-control item" type="text" name="name"></div>
                <div class="mb-3"><label class="form-label" >Address</label><input class="form-control item" type="text" name="address"></div>
                <div class="mb-3"><label class="form-label" >Role</label><select class="form-select" name="emprole">
                    <optgroup label="Select Roles">
                        <option value="Housekeeping" >Housekeeping</option>
                        <option value="Maintenance">Maintenance</option>
                        <option value="Front Desk">Front Desk</option>
                    </optgroup>
                </select></div>
                <div class="mb-3"><label class="form-label" >Hotel</label><input class="form-control item" type="number" name="hotelid"></div>
                <div class="mb-3"><button class="btn btn-primary btn-lg d-block w-100" type="submit">Update Employee</button></div>
            </form>
        </div>
    </section>
    <section class="portfolio-block contact">
        <div class="container">
            <div class="heading">
                <h2>Update Room</h2>
            </div>
            <form action="/HotelDatabase/updateRoom" method="post">
                <div class="mb-3"><label class="form-label" >Hotel-ID</label><input class="form-control" type="number" name="hotelid" required></div>
                <div class="mb-3"><label class="form-label" >Room No.</label><input class="form-control item" type="number"  name="roomid" required></div>
                <div class="mb-3"><label class="form-label" >Capacity</label><select class="form-select" name="capacity">
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
                <div class="mb-3"><label class="form-label" >Price</label><input class="form-control item" type="number" name="price"></div>
                <div class="mb-3"><label class="form-label" >Amenities</label><input class="form-control item" type="text"  name="amenities"></div>
                <div class="mb-3"><label class="form-label" >Extension</label><select class="form-select"name="extension" >
                    <optgroup label="Extension Possible">
                        <option value="true" selected="">Yes</option>
                        <option value="false">No</option>
                    </optgroup>
                </select></div>
                <div class="mb-3"><label class="form-label" >Room Availability</label><select class="form-select"name="status" >
                    <optgroup label="Room available">
                        <option value="true" selected="">Yes</option>
                        <option value="false">No</option>
                    </optgroup>
                </select></div>
                <div class="mb-3"><label class="form-label" >Problems/Damages</label><input class="form-control item" type="text" name="damages" id="subject-13" style="height: 75px;"></div>
                <div class="mb-3"><button class="btn btn-primary btn-lg d-block w-100" type="submit">Update Room</button></div>
            </form>
        </div>
    </section>
    <section class="portfolio-block contact">
        <div class="container">
            <div class="heading">
                <h2>Update Hotel</h2>
            </div>
            <form style="margin-top: 10px;" action="/HotelDatabase/updateHotel" method="post">
                <div class="mb-3"><label class="form-label" >Hotel-ID</label><input class="form-control" type="number" name="hotelid" required></div>
                <div class="mb-3"><label class="form-label">Select Hotel Chain</label><select class="form-select" id="subject-7" name ="name">
                    <optgroup label="Hotel Chains">
                        <option value="Mariott" selected="">Mariott</option>
                        <option value="Hayat">Hayat</option>
                        <option value="Hilton">Hilton</option>
                        <option value="ResidenceInn">Residence Inn</option>
                        <option value="4Seasons">4 Seasons</option>
                    </optgroup>
                </select></div>
                <div class="mb-3"><label class="form-label" >Location</label><input class="form-control item" type="text" id="subject-3" min="8" name="address"></div>
                <div class="mb-3"><label class="form-label" >Hotel Category</label><select class="form-select" id="subject-12" name="category">
                    <optgroup label="Star Hotels">
                        <option value="1" selected="">1 Star</option>
                        <option value="2">2 Star</option>
                        <option value="3">3 Star</option>
                        <option value="4">4 Star</option>
                        <option value="5">5 Star</option>
                    </optgroup>
                </select></div>
                <div class="mb-3"><label class="form-label" >Total No. of Rooms</label><input class="form-control item" type="number"  min="8" name="totalrooms"></div>
                <div class="mb-3"></div><button class="btn btn-primary btn-lg d-block w-100" type="submit">Update Hotel</button>
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