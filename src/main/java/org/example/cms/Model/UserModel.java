package org.example.cms.Model;

import org.apache.commons.dbcp2.BasicDataSource;
import org.example.cms.dto.UserDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModel {
    public static boolean findUser(UserDTO userDTO, BasicDataSource ds) throws SQLException {
        Connection connection = ds.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from users where username=? and password=?");
        preparedStatement.setString(1, userDTO.getUsername());
        preparedStatement.setString(2, userDTO.getPassword());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean saveUser(UserDTO userDTO, BasicDataSource ds) throws SQLException {
        Connection connection = ds.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into users(firstName,lastname,address,username, password,role) values(?,?,?,?,?,?)");
        preparedStatement.setString(1, userDTO.getFirstName());
        preparedStatement.setString(2, userDTO.getLastName());
        preparedStatement.setString(3, userDTO.getAddress());
        preparedStatement.setString(4, userDTO.getUsername());
        preparedStatement.setString(5, userDTO.getPassword());
        preparedStatement.setString(6, userDTO.getRole());
        int i = preparedStatement.executeUpdate();
        if (i > 0) {
            return true;
        }
        return false;

    }

    public static UserDTO findUserByUsernameAndPassword(String username, String password, BasicDataSource ds) throws SQLException {
        String sql = "SELECT username, password, role FROM users WHERE username = ? AND password = ?";
        try (Connection conn = ds.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    UserDTO user = new UserDTO();
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setRole(rs.getString("role"));
                    return user;
                }
            }
        }
        return null;
    }

}