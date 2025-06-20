package org.example.cms.Controller.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.dbcp2.BasicDataSource;
import org.example.cms.Model.UserModel;
import org.example.cms.dto.UserDTO;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        BasicDataSource ds = (BasicDataSource) req.getServletContext().getAttribute("dataSource");

        UserDTO user = null;
        try {
            user = UserModel.findUserByUsernameAndPassword(username, password, ds);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (user == null) {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid username or password");
            return;
        }

        String role = user.getRole();

        if ("admin".equalsIgnoreCase(role)) {
            resp.sendRedirect(req.getContextPath() + "/admin");
        } else if ("employee".equalsIgnoreCase(role)) {
            resp.sendRedirect(req.getContextPath() + "/employee");
        } else {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unknown role");
        }
    }

}
