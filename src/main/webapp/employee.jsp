
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.cms.dto.ComplainDTO" %>

<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <title>Employee Dashboard</title>
<style>
    .bkcolor {
        background-color: #00735B;
    }
    #navbarNavDropdown{
        padding-left: 50vw;
    }
</style>
</head>
<body>
<nav class="navbar navbar-expand-lg bkcolor" id="nav">
    <div class="container-fluid">
        <h3>Employee Dashboard</h3>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
                aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav">
                <li class="nav-item"><a class="nav-link active" aria-current="page" href="employee">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="createComplain.jsp">Add Complain</a></li>
                <li class="nav-item"><a class="nav-link" href="logIn.jsp">LogIn</a></li>
                <li class="nav-item"><a class="nav-link" href="index.jsp">SignIn</a></li>
                </li>
            </ul>
        </div>
    </div>
</nav>

<table id="complainTable" class="table">
        <thead>
        <tr>

            <th scope="col">Complain Code</th>
            <th scope="col">Complain</th>
        </tr>
        </thead>
        <tbody id="item-tbody">
        <%
            List<ComplainDTO> complaints = (List<ComplainDTO>) request.getAttribute("complaints");
            if (complaints != null) {
                for (ComplainDTO c : complaints) {
        %>
        <tr>
            <td><%= c.getId() %></td>
            <td><%= c.getComplain() %></td>
            <td>
                <form action="editComplain.jsp" method="get" style="display:inline;">
                    <input type="hidden" name="id" value="<%= c.getId() %>">
                    <input type="hidden" name="complain" value="<%= c.getComplain() %>">
                    <button type="submit" class="btn btn-warning btn-sm">Edit</button>
                </form>

                <form action="delete" method="post" style="display:inline;">
                    <input type="hidden" name="id" value="<%= c.getId() %>">
                    <button type="submit" class="btn btn-danger btn-sm">Delete</button>
                </form>
            </td>
        </tr>

        <%
            }
        } else {
        %>
        <tr><td>No complaints found.</td></tr>
        <%
            }
        %>

        </tbody>
    </table>
</body>
</html>
