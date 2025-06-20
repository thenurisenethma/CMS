package org.example.cms.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.apache.commons.dbcp2.BasicDataSource;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;
import java.util.UUID;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Map<String, String> user = mapper.readValue(req.getInputStream(), Map.class);

            ServletContext sc = req.getServletContext();
            BasicDataSource dataSource = (BasicDataSource) sc.getAttribute("ds");
            Connection connection = dataSource.getConnection();
            PreparedStatement stm = connection.prepareStatement("INSERT INTO users" + "(uid,uFName,uLName,upassword,uAddress,uRole) Values (?,?,?,?,?,?)");
            stm.setString(1, UUID.randomUUID().toString());
            stm.setString(2, user.get("uFName"));
            stm.setString(3, user.get("uLName"));
            stm.setString(4, user.get("uPassword"));
            stm.setString(5, user.get("uAddress"));
            stm.setString(6, user.get("uRole"));

            int executed = stm.executeUpdate();
            PrintWriter out = resp.getWriter();
            resp.setContentType("application/json");
            if (executed > 0) {
                resp.setStatus(HttpServletResponse.SC_ACCEPTED);
                mapper.writeValue(out, Map.of(
                        "code", "201",
                        "status", "success",
                        "message", "Signed up successfully!"
                ));
            } else {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                mapper.writeValue(out, Map.of(
                        "code", "400",
                        "status", "error",
                        "message", "Bad Request"
                ));
            }
            connection.close();
        } catch (Exception e) {
            ObjectMapper mapper = new ObjectMapper();
            PrintWriter out = resp.getWriter();
            resp.setContentType("application/json");
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            mapper.writeValue(out, Map.of(
                    "code", "500",
                    "status", "error",
                    "message", "Internal Server Error"
            ));
            throw new RuntimeException(e);
        }
    }
}

