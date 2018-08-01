package pl.coderslab.dao;

import pl.coderslab.model.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatusDAO {

    public static List<Status> loadAll() throws SQLException {

        String sql = "SELECT `id`, `name` FROM `status`";
        try (Connection conn = DbUtil.getConn()) {
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            return getStatusesFromResultSet(rs);
        }
    }

    public static Status loadById(int id) throws SQLException {

        String sql = "SELECT `id`, `name`  FROM `status` WHERE `id`=?";
        try (Connection conn = DbUtil.getConn()) {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            List<Status> result = getStatusesFromResultSet(rs);
            if(!result.isEmpty()){
                return result.get(0);
            }
        }
        return null;
    }

    private static List<Status> getStatusesFromResultSet(ResultSet rs) throws SQLException {
        List<Status> result = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            result.add(new Status(id, name));
        }
        return result;
    }

}
