
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">

  <style>
    form{
      position: absolute;
      left: 5vw;
      top: 8vh;
      margin: auto;
      height: 90vh;
      display: flex;
      padding: 20px;
      background-color: #ace2fb;
      border-radius: 5%;
      width: 45vw;
      border: double white;
    }
    img{
      position: absolute;
      height: 70vh;
      top: 15vh;
      left: 60vw;
    }
    h2{
      color: #00735B;
    }
    body{
      background-color: #00735B;
    }
  </style>
</head>
<body>
<form class="row g-3 needs-validation" action="signin" method="post" novalidate>
  <h2>SIGN IN</h2>

  <div class="col-md-4 position-relative">
    <input type="text" class="form-control" id="validationTooltip01" name="firstName" placeholder="First Name" required>
    <div class="valid-tooltip">OK!</div>
  </div>

  <div class="col-md-4 position-relative">
    <input type="text" class="form-control" id="validationTooltip02" name="lastName" placeholder="Last Name"required>
    <div class="valid-tooltip">OK!</div>
  </div>

  <div class="col-md-6 position-relative">
    <input type="text" class="form-control" id="validationTooltip03" name="address" placeholder="Address"required>
  </div>

  <hr>
  <div class="col-md-4 position-relative">
    <input type="text" class="form-control" id="username" name="username" placeholder="Username"required>
    <div class="valid-tooltip">OK!</div>
  </div>
  <div class="col-md-4 position-relative">
    <input type="password" class="form-control" id="password" name="password" placeholder="Password"required>
    <div class="valid-tooltip">OK!</div>
  </div>
<hr>
  <div class="col-md-3 position-relative">
    <select class="form-select" id="validationTooltip04" name="role" required>
      <option selected disabled value="">Role</option>
      <option value="admin">Admin</option>
      <option value="employee">Employee</option>
    </select>
  </div>

  <div class="col-12">
    <button class="btn btn-primary" type="submit">Sign In</button>
  </div>
  <a href="logIn.jsp">  <p>Already have an Account?</p></a>
</form>

<img src="img/login.png" alt="Login Image">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js" integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous"></script>
</body>
</html>