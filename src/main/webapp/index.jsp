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
    <link rel="stylesheet" href="assets/css/pikaday.min.css">
</head>

<body>
<nav class="navbar navbar-dark navbar-expand-lg fixed-top bg-white portfolio-navbar gradient">
    <div class="container"><a class="navbar-brand logo" href="#">Pentago</a><button data-bs-toggle="collapse" class="navbar-toggler" data-bs-target="#navbarNav"><span class="visually-hidden">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item"><a class="nav-link" href="#">Home</a></li>
                <li class="nav-item"><a class="nav-link active" href="#">Booking/Check-in</a></li>
                <li class="nav-item"><a class="nav-link" href="addcustomer.jsp">Add Customer</a></li>
                <li class="nav-item"><a class="nav-link" href="manage.jsp">Manage Hotel</a></li>
            </ul>
        </div>
    </div>
</nav>
<main class="page hire-me-page">
    <section class="portfolio-block hire-me">
        <div class="container">
            <div class="heading">
                <h2>SEARCH FOR HOTELS</h2>
            </div>
            <form>
                <div class="mb-3">

                    <form  action="/HotelDatabase/room" method="post">
                        <div class="mb-3"><label class="form-label" for="hotelchainname">Select Hotel Chain</label><select class="form-select" id="hotelchainname" name="hotelchainname">
                            <optgroup label="Hotel Chains">
                                <option value="Marriott" selected="">Marriott</option>
                                <option value="Hayat">Hayat</option>
                                <option value="Hilton">Hilton</option>
                                <option value="ResidenceInn">Residence Inn</option>
                                <option value="4Seasons">4 Seasons</option>
                            </optgroup>
                        </select></div>
                        <div class="mb-3"><label class="form-label" for="address">Location</label><select class="form-select" id="address" name="address">
                            <optgroup label="Cities">
                                <option value="Ottawa" selected="">Ottawa</option>
                                <option value="Toronto">Toronto</option>
                                <option value="Halifax">Halifax</option>
                                <option value="Calgary">Calgary</option>
                                <option value="Moncton">Moncton</option>
                                <option value="Windsor">Windsor</option>
                                <option value="Vancouver">Vancouver</option>
                                <option value="Winnipeg">Winnipeg</option>
                                <option value="Montreal">Montreal</option>
                                <option value="Regina">Regina</option>
                                <option value="Hamilton">Hamilton</option>
                                <option value="Surrey">Surrey</option>
                                <option value="London">London</option>
                                <option value="Banff">Banff</option>
                                <option value="Kanata">Kanata</option>
                                <option value="Milton">Milton</option>
                                <option value="Oshawa">Oshawa</option>
                                <option value="Edmonton">Edmonton</option>
                                <option value="Sudbury">Sudbury</option>
                                <option value="Barrie">Barrie</option>
                                <option value="Kingston">Kingston</option>
                                <option value="Thunderbay">Thunderbay</option>
                                <option value="Victoria">Victoria</option>
                                <option value="Niagara">Niagara</option>
                                <option value="Guelph">Guelph</option>
                                <option value="Quebec">Quebec</option>
                            </optgroup>
                        </select></div>
                        <div class="mb-3">
                            <div class="row">
                                <div class="col-md-6"><label class="form-label" for="hire-date">From</label><input class="form-control" id="hire-date" type="date"></div>
                                <div class="col-md-6 button"><label class="form-label" for="hire-date">To</label><input class="form-control" id="hire-date-1" type="date"></div>
                            </div>
                        </div>
                        <div class="mb-3"><label class="form-label" for="stars">Hotel Category</label><select class="form-select" id="stars">
                            <optgroup label="Star Hotels">
                                <option value="1" selected="">1 Star</option>
                                <option value="2">2 Star</option>
                                <option value="3">3 Star</option>
                                <option value="4">4 Star</option>
                                <option value="5">5 Star</option>
                            </optgroup>
                        </select></div>
                        <div class="mb-3"><label class="form-label" for="price">Price</label><select class="form-select" id="price">
                            <optgroup label="$CAD">
                                <option value="12" selected="">Less than 30</option>
                                <option value="13">30 to 60</option>
                                <option value="14">More than 60</option>
                            </optgroup>
                        </select></div>
                        <div class="mb-3"><label class="form-label" for="view">Room View</label><select class="form-select" id="view">
                            <optgroup label="View">
                                <option value="Mountain view" selected="">Mountain view</option>
                                <option value="Sea view">Sea view</option>
                                <option value="City view">City view</option>
                                <option value="Garden view">Garden view</option>
                            </optgroup>
                        </select></div>
                        <div class="mb-3"><label class="form-label" for="capacity">Capacity</label><select class="form-select" id="capacity">
                            <optgroup label="Room Capacity">
                                <option value="2" selected="">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                            </optgroup>
                        </select></div>
                        <a class="btn btn-primary btn-lg d-block w-100" id="show-btn"  type="submit" href="room.jsp">Search Rooms</a>
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