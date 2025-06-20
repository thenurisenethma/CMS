<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Complaint</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">

    <style>
    .bkcolor {
    background-color: lavender;
    }
    #navbarNavDropdown{
        padding-left: 50vw;
    }
    #complainForm {
        width: 75%;
        margin: 5vh auto;
        background-color: #f0f0f0;
        padding: 4vh;
        border-radius: 10px;
    }
    #txtArea {
        border-color: #B419FC;
        width: 100%;
        border-radius: 10px;
    }
    #btn {
        background-color: #ace2fb;
        width: 8vw;
    }
    h3{
        color: #B419FC;
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
                <li class="nav-item"><a class="nav-link" href="index.jsp">SignUp</a></li>
                </li>
            </ul>
        </div>
    </div>
</nav>

<form action="update" method="post" id="complainForm">
    <input type="hidden" name="id" value="<%= request.getParameter("id") %>">
    <label for="txtArea" class="form-label">Edit complaint:</label>

    <textarea name="complain" id="txtArea" rows="5" cols="40"><%= request.getParameter("complain") %></textarea>
    <br><br>
    <button type="submit" id="btn" class="btn btn-light btn-sm save">Update</button>

</form>
</body>
</html>
