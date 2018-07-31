package pl.coderslab.dao;

import pl.coderslab.model.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

    public static List<Order> loadAll() throws SQLException {

        String sql = "SELECT `id`, `arrival_date`, `planned_repair_date`, `real_repair_date`, `emplyees_id`, `problem_description`, `reppair_description`, `status`, `vehicles_id`, `total_cost`, `parts_cost`, `working_hours` FROM `orders`";
        try (Connection conn = DbUtil.getConn()) {
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            List<Order> result = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt(1);
                Date arrival_date = rs.getDate(2);
                Date planned_repair_date = rs.getDate(3);
                Date real_repair_date = rs.getDate(4);
                int emplyes_id = rs.getInt(5);
                String problem_description = rs.getString(6);
                String repair_description = rs.getString(7);
                String status = rs.getString(8);
                int vehicles_id = rs.getInt(9);
                float total_cost = rs.getFloat(10);
                float parts_cost = rs.getFloat(11);
                int working_hours = rs.getInt(12);
                result.add(new Order(id, arrival_date, planned_repair_date, real_repair_date, emplyes_id, problem_description, repair_description, status, vehicles_id, total_cost, parts_cost, working_hours));
            }
            return result;
        } catch (SQLException e) {
            throw e;
        }
    }

    public static Order loadById(int id) throws SQLException {

        String sql = "SELECT `arrival_date`, `planned_repair_date`, `real_repair_date`, `emplyees_id`, `problem_description`, `reppair_description`, `status`, `vehicles_id`, `total_cost`, `parts_cost`, `working_hours`  FROM `orders` WHERE `id`=?";
        try (Connection conn = DbUtil.getConn()) {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Date arrival_date = rs.getDate(1);
                Date planned_repair_date = rs.getDate(2);
                Date real_repair_date = rs.getDate(3);
                int emplyes_id = rs.getInt(4);
                String problem_description = rs.getString(5);
                String repair_description = rs.getString(6);
                String status = rs.getString(7);
                int vehicles_id = rs.getInt(8);
                float total_cost = rs.getFloat(9);
                float parts_cost = rs.getFloat(10);
                int working_hours = rs.getInt(11);
                return new Order(id, arrival_date, planned_repair_date, real_repair_date, emplyes_id, problem_description, repair_description, status, vehicles_id, total_cost, parts_cost, working_hours);
            }
        } catch (SQLException e) {
            throw e;
        }
        return null;
    }

    public static int save(Order order) throws SQLException {
        if (order != null) {
            if (order.getId() == 0) {
                return insert(order);
            } else {
                return update(order);
            }
        }
        return 0;
    }

    private static int insert(Order order) throws SQLException {
        String sql = "INSERT INTO `orders` (`arrival_date`, `planned_repair_date`, `real_repair_date`, `emplyees_id`, `problem_description`, `reppair_description`, `status`, `vehicles_id`, `total_cost`, `parts_cost`, `working_hours`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DbUtil.getConn()) {
            String[] generatedColumns = {"id"};
            PreparedStatement st = conn.prepareStatement(sql, generatedColumns);
            st.setDate(1, order.getArrival_date());
            st.setDate(2, order.getPlanned_repair_date());
            st.setDate(3, order.getReal_repair_date());
            st.setInt(4, order.getEmployees_id());
            st.setString(5, order.getProblem_description());
            st.setString(6, order.getRepair_description());
            st.setString(7, order.getStatus());
            st.setInt(8, order.getVehicles_id());
            st.setFloat(9, order.getTotal_cost());
            st.setFloat(10, order.getParts_cost());
            st.setInt(11, order.getWorking_hours());
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

    private static int update(Order order) throws SQLException {
        String sql = "UPDATE `orders` SET `arrival_date`=?, `planned_repair_date`=?, `real_repair_date`=?, `emplyees_id`=?, `problem_description`=?, `reppair_description`=?, `status`=?, `vehicles_id`=?, `total_cost`=?, `parts_cost`=?, `working_hours`=? WHERE `id`=?";
        try (Connection conn = DbUtil.getConn()) {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setDate(1, order.getArrival_date());
            st.setDate(2, order.getPlanned_repair_date());
            st.setDate(3, order.getReal_repair_date());
            st.setInt(4, order.getEmployees_id());
            st.setString(5, order.getProblem_description());
            st.setString(6, order.getRepair_description());
            st.setString(7, order.getStatus());
            st.setInt(8, order.getVehicles_id());
            st.setFloat(9, order.getTotal_cost());
            st.setFloat(10, order.getParts_cost());
            st.setInt(11, order.getWorking_hours());
            if (st.executeUpdate() > 0) {
                return order.getId();
            }
        } catch (SQLException e) {
            throw e;
        }
        return 0;

    }

    public static int delete(Order order) throws SQLException {
        String sql = "DELETE FROM `orders` WHERE `id`=?";
        if (order.getId() != 0) {
            try (Connection conn = DbUtil.getConn()) {
                PreparedStatement st = conn.prepareStatement(sql);
                st.setInt(1, order.getId());
                int result = st.executeUpdate();
                order.setId(0);
                return result;
            } catch (SQLException e) {
                throw e;
            }
        }

        return 0;
    }

}
