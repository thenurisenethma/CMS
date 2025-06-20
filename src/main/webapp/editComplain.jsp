<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Complaint</title>
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
        <h3>Edit Complain</h3>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
                aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav">
                <li class="nav-item"><a class="nav-link active" aria-current="page" href="employee">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="createComplain.jsp">Add Complain</a></li>
                <li class="nav-item"><a class="nav-link" href="logIn.jsp">LogIn</a></li>
                <li class="nav-item"><a class="nav-link" href="signin">SignIn</a></li>
                </li>
            </ul>
        </div>
    </div>
</nav>
<form action="update" method="post">
    <input type="hidden" name="id" value="<%= request.getParameter("id") %>">
    <textarea name="complain" rows="5" cols="40"><%= request.getParameter("complain") %></textarea>
    <br>
    <button type="submit">Update</button>
</form>
</body>
</html>
