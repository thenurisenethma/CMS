package org.example.cms.Controller.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.dbcp2.BasicDataSource;
import org.example.cms.Model.ComplainModel;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/admin/delete")
public class AdminDeleteComplainServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        BasicDataSource ds = (BasicDataSource) req.getServletContext().getAttribute("dataSource");

        try {
            boolean deleted = ComplainModel.deleteComplaint(id, ds);
            if (deleted) {
                resp.sendRedirect(req.getContextPath() + "/admin");
            } else {
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Delete failed.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
