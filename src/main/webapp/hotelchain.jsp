<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.util.List" %>
<%@ page import="com.Hotels.HotelchainService" %>
<%@ page import="com.Hotels.Hotelchain" %>
<%@ page import="com.Hotels.Message" %>
<%@ page import="java.util.ArrayList" %>


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

    // get all hotelchains from database
    HotelchainService hotelchainService = new HotelchainService();
    List<Hotelchain> hotelchains = null;
    try {
        hotelchains = hotelchainService.getHotelchain();
    } catch (Exception e) {
        e.printStackTrace();
    }
%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title> Hotel Chain List </title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <link rel="stylesheet" href="assets/css/styles.css">
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css">
</head>

<body>
    <jsp:include page="navbar.jsp"/>

    <input type="hidden" name="message" id="message" value='<%=msgField%>' >
    <div class="container">
        <div class="row" id="row">
            <div class="col-md-12">
                <div class="card" id="card-container">
                    <div class="card-body" id="card">
                        <% if (hotelchains.size() == 0) { %>
                        <h1 style="margin-top: 5rem;">No hotelchains found!</h1>
                        <% } else { %>
                        <div class="table-responsive">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th>Name</th>
                                    <th>TotalHotels</th>
                                    <th>Address</th>
                                    <th>Email</th>
                                    <th>Phoneno</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <%
                                for (Hotelchain hotelchain : hotelchains) { %>
                                <tr>
                                    <td><%= hotelchain.getName() %></td>
                                    <td><%= hotelchain.getTotalHotels() %></td>
                                    <td><%= hotelchain.getAddress() %></td>
                                    <td><%= hotelchain.getEmail() %></td>
                                    <td><%= hotelchain.getPhoneno() %></td>
                                    <td>
                                        <!--
                                        <a type="button" onclick="setModalFields(this)"
                                           data-toggle="modal" data-name="<%= hotelchain.getName() %>"
                                           data-totalhotels="<%= hotelchain.getTotalHotels() %>" data-address="<%= hotelchain.getAddress() %>"
                                           data-email="<%= hotelchain.getEmail() %>" data-phoneno="<%= hotelchain.getPhoneno() %>"
                                           data-target="#editModal">
                                            <i class="fa fa-edit"></i>
                                        </a>
                                        -->
                                    </td>
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

    <script>
        function setModalFields(row) {
            document.getElementById("name").value = row.dataset.name;
            document.getElementById("totalhotels").value = row.dataset.totalhotels;
            document.getElementById("address").value = row.dataset.address;
            document.getElementById("email").value = row.dataset.email;
            document.getElementById("phoneno").value = row.dataset.phoneno;

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