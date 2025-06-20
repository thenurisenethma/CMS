package org.example.cms.Controller.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.dbcp2.BasicDataSource;
import org.example.cms.Model.ComplainModel;
import org.example.cms.dto.ComplainDTO;

import java.io.IOException;
import java.sql.SQLException;
@WebServlet("/updateStatus")
public class UpdateStatusServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String status = req.getParameter("status");
        String remarks = req.getParameter("remarks");

        BasicDataSource ds = (BasicDataSource) req.getServletContext().getAttribute("ds");

        try {
            boolean updated = ComplainModel.updateComplaintStatus(id, status, ds);
            if (updated) {
                resp.sendRedirect("admin?success=updated");
            } else {
                resp.sendRedirect("admin?error=updatefailed");
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
