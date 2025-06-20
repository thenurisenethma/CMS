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

@WebServlet("/create")
public class CreateComplainServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String complain = req.getParameter("complain");
        BasicDataSource ds = (BasicDataSource) req.getServletContext().getAttribute("dataSource");

        try {
            boolean isSave = ComplainModel.saveComplain(new ComplainDTO(complain), ds);
            if (isSave) {
                System.out.println("Complaint created successfully.");
                resp.sendRedirect("employee");
            } else {
                System.out.println("Failed to save complaint.");
                resp.sendRedirect("createComplain.jsp");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
