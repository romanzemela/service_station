package pl.coderslab.dao;

import pl.coderslab.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    public static List<Employee> loadAll() throws SQLException {

        String sql = "SELECT `id`, `name`, `surname`, `address`, `phone`, `note`, `rate` FROM `employees`";
        try (Connection conn = DbUtil.getConn()) {
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            List<Employee> result = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String surname = rs.getString(3);
                String address = rs.getString(4);
                int phone = rs.getInt(5);
                String note = rs.getString(6);
                float rate = rs.getFloat(7);

                result.add(new Employee(id, name, surname, address, phone, note, rate));
            }
            return result;
        } catch (SQLException e) {
            throw e;
        }
    }

    public static Employee loadById(int id) throws SQLException {

        String sql = "SELECT `id`, `name`, `surname`, `address`, `phone`, `note`, `rate` FROM `employees` WHERE `id`=?";
        try (Connection conn = DbUtil.getConn()) {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String name = rs.getString(2);
                String surname = rs.getString(3);
                String address = rs.getString(4);
                int phone = rs.getInt(5);
                String note = rs.getString(6);
                float rate = rs.getFloat(7);
                return new Employee(id, name, surname, address, phone, note, rate);
            }
        } catch (SQLException e) {
            throw e;
        }
        return null;
    }

    public static int save(Employee employee) throws SQLException {
        if (employee != null) {
            if (employee.getId() == 0) {
                return insert(employee);
            } else {
                return update(employee);
            }
        }
        return 0;
    }

    private static int insert(Employee employee) throws SQLException {
        String sql = "INSERT INTO `employees` (`name`, `surname`, `address`, `phone`, `note`, `rate`) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DbUtil.getConn()) {
            String[] generatedColumns = {"id"};
            PreparedStatement st = conn.prepareStatement(sql, generatedColumns);
            st.setString(1, employee.getName());
            st.setString(2, employee.getSurname());
            st.setString(3, employee.getAddress());
            st.setString(4, String.valueOf(employee.getPhone()));
            st.setString(5, employee.getNote());
            st.setString(6, String.valueOf(employee.getRate()));

            st.executeUpdate();
            ResultSet res = st.getGeneratedKeys();
            if (res.next()) {
                return res.getInt(1);
            }
        } catch (SQLException e) {
            throw e;
        }
        return 0;
    }

    private static int update(Employee employee) throws SQLException {
        String sql = "UPDATE `employees` SET `name`=?, `surname`=?, `address`=?, `phone`=?, `note`=?, `rate`=? WHERE `id`=?";
        try (Connection conn = DbUtil.getConn()) {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, employee.getName());
            st.setString(2, employee.getSurname());
            st.setString(3, employee.getAddress());
            st.setString(4, String.valueOf(employee.getPhone()));
            st.setString(5, employee.getNote());
            st.setString(6, String.valueOf(employee.getRate()));

            st.setInt(7, employee.getId());
            if (st.executeUpdate() > 0) {
                return employee.getId();
            }
        } catch (SQLException e) {
            throw e;
        }
        return 0;

    }

    public static int delete(Employee employee) throws SQLException {
        String sql = "DELETE FROM `employees` WHERE `id`=?";
        if (employee.getId() != 0) {
            try (Connection conn = DbUtil.getConn()) {
                PreparedStatement st = conn.prepareStatement(sql);
                st.setInt(1, employee.getId());
                int result = st.executeUpdate();
                employee.setId(0);
                return result;
            } catch (SQLException e) {
                throw e;
            }
        }
        return 0;
    }

}
