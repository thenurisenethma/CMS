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

@WebServlet("/signin")
public class SignInServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String address = req.getParameter("address");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        System.out.println(firstName + " " + lastName + " " + address + " " + username + " " + password + " " + role);

        BasicDataSource ds = (BasicDataSource) req.getServletContext().getAttribute("dataSource");

        try {
            boolean isSave = UserModel.saveUser(new UserDTO(firstName, lastName, address, username, password, role), ds);

            if (isSave) {
                System.out.println("User Saved");
                if ("admin".equalsIgnoreCase(role)) {
                    req.getRequestDispatcher("admin.jsp").forward(req, resp);
                } else if ("employee".equalsIgnoreCase(role)) {
                    req.getRequestDispatcher("employee.jsp").forward(req, resp);
                } else {
                    resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                }
            } else {
                resp.sendRedirect(req.getContextPath() + "/index.jsp?error=save_failed");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

