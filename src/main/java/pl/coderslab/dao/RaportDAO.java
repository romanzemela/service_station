package pl.coderslab.dao;

import pl.coderslab.model.Raport1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RaportDAO {
    public static List<Raport1> getRaport1() throws SQLException {

        String sql = "select `e`.`name`, `e`.`surname`, sum(`o`.`working_hours`) as `ilosc_roboczogodzin` from `employees` `e` left join  `orders` `o` on `e`.`id` = `o`.`employees_id` group by `e`.`id` order by `ilosc_roboczogodzin` desc, `e`.`surname` asc, `e`.`name` asc";
        try (Connection conn = DbUtil.getConn()) {
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            List<Raport1> result = new ArrayList<>();
            while (rs.next()) {
                String firstName = rs.getString(1);
                String secondName = rs.getString(2);
                Integer iloscRoboczogodzin = rs.getInt(3);
                result.add(new Raport1(firstName, secondName, iloscRoboczogodzin));
            }
            return result;
        } catch (SQLException e) {
            throw e;
        }
    }
}
