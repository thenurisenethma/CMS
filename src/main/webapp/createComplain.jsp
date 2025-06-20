<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Complain</title>
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
        #complain {
            border-color:#B419FC;
        }
        .save {
            background-color: #ace2fb;
            width: 8vw;
        }
        h3{color: #B419FC}

    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg bkcolor" id="nav">
    <div class="container-fluid">
        <h3>Add Complaint</h3>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item"><a class="nav-link active" href="employee">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="createComplain.jsp">Add Complaint</a></li>
                <li class="nav-item"><a class="nav-link" href="logIn.jsp">LogIn</a></li>
                <li class="nav-item"><a class="nav-link" href="index.jsp">SignUp</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container" id="complainForm">
    <form action="create" method="post">
        <div class="mb-3">
            <label for="complain" class="form-label">Write your complaint:</label>
            <textarea class="form-control" id="complain" name="complain" rows="5" required></textarea>
        </div>
        <button type="submit" class="btn btn-light btn-sm save">Save</button>
    </form>

</div>

</body>
</html>
