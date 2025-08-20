package dao;

import model.User;
import util.DBConnection;
import java.sql.*;

public class UserDAO {
    public User validateUser(String username, String password) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM users WHERE username=? AND password=?"
            );
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                return u;
            }
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }
}
