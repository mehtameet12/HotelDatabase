<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.Hotels.*" %>
<%@ page import="com.Hotels.RoomService" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.Connection" %>



<%
    ArrayList<Message> messages;

    // get any incoming messages from session attribute named messages
    // if nothing exists then messages is an empty arraylist
    if ((ArrayList<Message>) session.getAttribute("messages") == null) messages = new ArrayList<>();
        // else get that value
    else messages = (ArrayList<Message>) session.getAttribute("messages");

    String msgField = "";

    // create the object in the form of a stringified json
    for (Message m : messages) {
        msgField += "{\"type\":\"" + m.type + "\",\"value\":\"" + m.value.replaceAll("['\"]+", "") + "\"},";
    }

    // empty session messages
    session.setAttribute("messages", new ArrayList<Message>());


    //---------------------------------------

    RoomService roomService = new RoomService();
    RoomServlet roomServlet = new RoomServlet();
    List<Room> rooms = null;
    try {
        String hotelAddress = (String) request.getAttribute("hotelAddress");
        String hotelChainName = (String) request.getAttribute("hotelChainName");
        String startDate = (String) request.getAttribute("fromdate");
        String endDate = (String) request.getAttribute("todate");
        String category = (String) request.getAttribute("category");
        String price = (String) request.getAttribute("price");
        //Integer category = Integer.valueOf(request.getParameter("category"));
        //Integer price = Integer.valueOf(request.getParameter("price"));
        String roomView = (String) request.getAttribute("roomview");
        String capacity = (String) request.getAttribute("capacity");
        //Integer capacity = Integer.valueOf(request.getParameter("capacity"));

        rooms = roomService.availableRooms(request, hotelAddress, hotelChainName, category, capacity, roomView, price);
    } catch (Exception e) {
        e.printStackTrace();
    }

    //-----------------------------------


%>

<!DOCTYPE html>
<html lang="en">

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
    <div class="container"><a class="navbar-brand logo" href="index.jsp">Pentago</a><button data-bs-toggle="collapse" class="navbar-toggler" data-bs-target="#navbarNav"><span class="visually-hidden">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item"><a class="nav-link" href="index.jsp">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="index.jsp">Booking/Check-in</a></li>
                <li class="nav-item"><a class="nav-link active" href="addcustomer.jsp">Add Customer</a></li>
                <li class="nav-item"><a class="nav-link" href="manage.jsp">Manage Hotel</a></li>
            </ul>
        </div>
    </div>
</nav>
<section class="portfolio-block contact">
    <input type="hidden" name="message" id="message" value='<%=msgField%>' >
    <div class="container">
        <div class="row" id="row">
            <div class="col-md-12">
                <div class="card" id="card-container">
                    <div class="card-body" id="card">
                        <% if (rooms.size() == 0) { %>
                        <h2 style="margin-top: 5rem;">No such rooms found, please change your search criteria!</h2>
                        <% } else { %>
                        <div class="table-responsive">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th>Room ID</th>
                                    <th>Capacity</th>
                                    <th>Status</th>
                                    <th>Price</th>
                                    <th>Room View</th>
                                    <th>Extension</th>
                                    <th>Damages</th>
                                    <th>Amenities</th>
                                    <th>Hotel ID</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <%
                                for (Room room : rooms) { %>
                                <tr>
                                    <td><%= room.getRoomid() %></td>
                                    <td><%= room.getCapacity() %></td>
                                    <td><%= room.getStatus() %></td>
                                    <td><%= room.getPrice() %></td>
                                    <td><%= room.getRoomview() %></td>
                                    <td><%= room.getExtension() %></td>
                                    <td><%= room.getDamages() %></td>
                                    <td><%= room.getAmenities() %></td>
                                    <td><%= room.getHotelid() %></td>
                                </tr>
                                <% } %>
                                </tbody>
                            </table>
                        </div>
                        <% } %>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

    <script>
        function setModalFields(row) {
            document.getElementById("hotelid").value = row.dataset.hotelid;
            document.getElementById("category").value = row.dataset.category;
            document.getElementById("address").value = row.dataset.address;
            document.getElementById("totalrooms").value = row.dataset.totalrooms;
            document.getElementById("name").value = row.dataset.name;

            document.getElementById("modal-form").action = "/update-student-controller.jsp";
            document.getElementById("modal-form").method = "POST";
        }
    </script>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    <script src="/assets/js/jquery.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>

    <script>
        $(document).ready(function() {
            toastr.options = {
                "closeButton": true,
                "positionClass": "toast-bottom-right",
                "preventDuplicates": false
            };
            /* In order to access variables sent to ejs file to script you must Parse them to string */
            /* then to parse them back to JSON */
            let messages = document.getElementById("message").value;
            if (messages !== "") messages = JSON.parse("[" + messages.slice(0, -1) + "]");
            else messages = [];

            messages
            .forEach(({
                type,
                value
            }) => {
            switch (type) {
                case "error":
                    toastr.error(value)
                    break;
                case "success":
                    toastr.success(value)
                    break;
                case "warning":
                    toastr.warning(value)
                    break;
                default:
                    toastr.info(value)
                        break;
                }
            });
        })
    </script>

</body>

</html>