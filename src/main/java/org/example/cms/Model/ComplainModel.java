package org.example.cms.Model;

import org.apache.commons.dbcp2.BasicDataSource;
import org.example.cms.dto.ComplainDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComplainModel {
    public static boolean saveComplain(ComplainDTO complainDTO, BasicDataSource ds) throws SQLException {
        Connection connection = ds.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into complains(complain) values(?)");
        preparedStatement.setString(1, complainDTO.getComplain());
        int i = preparedStatement.executeUpdate();
        if (i > 0){
            return true;
        }
        return false;

    }

    public static List<ComplainDTO> getAllComplaints(BasicDataSource ds) throws SQLException {
        List<ComplainDTO> list = new ArrayList<>();

        try (Connection conn = ds.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT id, complain FROM complains");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                ComplainDTO dto = new ComplainDTO(
                        rs.getInt("id"),
                        rs.getString("complain")
                );
                list.add(dto);
            }
        }

        return list;
    }
    public static boolean updateComplaint(ComplainDTO dto, BasicDataSource ds) throws SQLException {
        String sql = "UPDATE complains SET complain = ? WHERE id = ?";
        try (Connection conn = ds.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, dto.getComplain());
            stmt.setInt(2, dto.getId());

            return stmt.executeUpdate() > 0;
        }
    }
    public static boolean deleteComplaint(int id, BasicDataSource ds) throws SQLException {
        String sql = "DELETE FROM complains WHERE id = ?";
        try (Connection conn = ds.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }
    }
    public static boolean updateComplaintStatus(int id, String status, BasicDataSource ds) throws SQLException {
        try (Connection conn = ds.getConnection();
             PreparedStatement stmt = conn.prepareStatement("UPDATE complains SET status=? WHERE id=?")) {
            stmt.setString(1, status);
            stmt.setInt(2, id);
            return stmt.executeUpdate() > 0;
        }
    }

}
