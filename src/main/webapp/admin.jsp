<%@ page import="org.example.cms.dto.ComplainDTO" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Thenuri
  Date: 6/16/2025
  Time: 11:56 AM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
  <title>Admin Dashboard</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
  <style>
    h3 {
      color: #B419FC;
    }
    .bkcolor {
      background-color: lavender;
    }
    #navbarNavDropdown {
      padding-left: 50vw;
    }
  </style>
</head>
<body>

<nav class="navbar navbar-expand-lg bkcolor" id="nav">
  <div class="container-fluid">
    <h3>Admin Dashboard</h3>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
            aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
      <ul class="navbar-nav">
        <li class="nav-item"><a class="nav-link active" href="admin">Home</a></li>
        <li class="nav-item"><a class="nav-link" href="logIn.jsp">LogIn</a></li>
        <li class="nav-item"><a class="nav-link" href="index.jsp">SignUp</a></li>
      </ul>
    </div>
  </div>
</nav>

<div class="container mt-4">
  <table class="table table-bordered">
    <thead>
    <tr>
      <th>Complain Code</th>
      <th>Complain</th>
      <th>Status</th>
    </tr>
    </thead>
    <tbody>
    <%
      List<ComplainDTO> complaints = (List<ComplainDTO>) request.getAttribute("complaints");
      if (complaints != null && !complaints.isEmpty()) {
        for (ComplainDTO c : complaints) {
    %>
    <tr>
      <td><%= c.getId() %></td>
      <td><%= c.getComplain() %></td>
      <td>
        <div><%= c.getStatus() != null ? c.getStatus() : "" %></div>

        <form action="updateStatus" method="post" style="display:inline;">
          <input type="hidden" name="id" value="<%= c.getId() %>">
          <input type="text" name="status" value="<%= c.getStatus() != null ? c.getStatus() : "" %>" placeholder="Status" required>
          <button type="submit" class="btn btn-sm btn-primary">Update</button>
        </form>

        <form action="admin/delete" method="post" style="display:inline;">
          <input type="hidden" name="id" value="<%= c.getId() %>">
          <button type="submit" class="btn btn-danger btn-sm">Delete</button>
        </form>
      </td>
    </tr>
    <%
      }
    } else {
    %>
    <tr><td colspan="3" class="text-center">No complaints found.</td></tr>
    <%
      }
    %>

    </tbody>
  </table>
</div>

</body>
</html>
