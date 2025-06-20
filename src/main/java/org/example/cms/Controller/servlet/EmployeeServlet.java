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
import java.util.List;

@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BasicDataSource ds = (BasicDataSource) req.getServletContext().getAttribute("ds");

        List<ComplainDTO> complaints = null;
        try {
            complaints = ComplainModel.getAllComplaints(ds);
            req.setAttribute("complaints", complaints);
            req.getRequestDispatcher("employee.jsp").forward(req, resp);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
