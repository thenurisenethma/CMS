package org.example.cms.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.dbcp2.BasicDataSource;
import org.example.cms.Model.ComplainModel;
import org.example.cms.dto.ComplainDTO;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/update")
public class UpdateComplainServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String complain = req.getParameter("complain");
        BasicDataSource ds = (BasicDataSource) req.getServletContext().getAttribute("ds");

        try {
            boolean updated = ComplainModel.updateComplaint(new ComplainDTO(id, complain), ds);
            resp.sendRedirect("employee");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

