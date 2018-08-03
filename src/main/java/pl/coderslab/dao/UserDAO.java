package pl.coderslab.dao;

import pl.coderslab.model.User;
import pl.coderslab.utils.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public static List<User> loadAll() throws Exception {
        String query = "SELECT id, username, email, password FROM users";

        try (Connection conn = DbUtil.getConn()) {
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            return getUsersFromResultSet(rs);
        }
    }

    public static User loadById(int userId) throws SQLException {
        String sql = "SELECT id, username, email, password FROM users WHERE id = ?";
        try (Connection conn = DbUtil.getConn()) {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, userId);
            ResultSet rs = st.executeQuery();
            List<User> result = getUsersFromResultSet(rs);
            if (!result.isEmpty()) {
                return result.get(0);
            }
        }
        return null;
    }

    public static int save(User user) throws SQLException {
        if (user != null) {
            if (user.getId() == 0) {
                return insert(user);
            } else {
                return update(user);
            }
        }
        return 0;
    }

    private static int insert(User user) throws SQLException {
        String sql = "INSERT INTO `users`(`username`, `email`, `password`) VALUES(?, ?, ? )";
        try (Connection conn = DbUtil.getConn()) {
            String[] generatedColumns = {"id"};
            PreparedStatement st = conn.prepareStatement(sql, generatedColumns);
            st.setString(1, user.getUsername());
            st.setString(2, user.getEmail());
            st.setString(3, user.getPassword());
            st.executeUpdate();
            ResultSet res = st.getGeneratedKeys();
            if (res.next()) {
                return res.getInt(1);
            }
        }
        return 0;
    }

    private static int update(User user) throws SQLException {
        String sql = "UPDATE `users` SET `username`=?, `email`=?, `password`=? WHERE `id`=?";
        try (Connection conn = DbUtil.getConn()) {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, user.getUsername());
            st.setString(2, user.getEmail());
            st.setString(3, user.getPassword());
            st.setInt(4, user.getId());
            if (st.executeUpdate() > 0) {
                return user.getId();
            }
        }
        return 0;
    }

    public static int delete(User user) throws SQLException {
        if (user.getId() != 0) {
            String query = "DELETE FROM users WHERE id = ?";
            try (Connection conn = DbUtil.getConn()) {
                PreparedStatement st = conn.prepareStatement(query);
                st.setInt(1, user.getId());
                int result = st.executeUpdate();
                user.setId(0);
                return result;
            }
        }
        return 0;
    }


    public static boolean checkPassword(User user, String password) {
        if (BCrypt.checkpw(password, user.getPassword())) {
            return true;
        }
        return false;

    }

    private static List<User> getUsersFromResultSet(ResultSet rs) throws SQLException {
        List<User> result = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt(1);
            String username = rs.getString(2);
            String email = rs.getString(3);
            String password = rs.getString(4);
            result.add(new User(id, username, email, password));
        }
        return result;
    }

}
