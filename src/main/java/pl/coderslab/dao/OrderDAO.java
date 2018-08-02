package pl.coderslab.dao;

import pl.coderslab.model.Employee;
import pl.coderslab.model.Order;
import pl.coderslab.model.Status;
import pl.coderslab.model.Vehicle;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

    public static List<Order> loadAll() throws SQLException {

        String sql = "SELECT `id`, `arrival_date`, `planned_repair_date`, `real_repair_date`, `employees_id`, `problem_description`, `repair_description`, `status_id`, `vehicles_id`, `total_cost`, `parts_cost`, `working_hours` FROM `orders`";
        try (Connection conn = DbUtil.getConn()) {
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            List<Order> result = getOrdersFromResultSet(rs);
            return result;
        }
    }


    public static Order loadById(int id) throws SQLException {

        String sql = "SELECT `id`, `arrival_date`, `planned_repair_date`, `real_repair_date`, `employees_id`, `problem_description`, `repair_description`, `status_id`, `vehicles_id`, `total_cost`, `parts_cost`, `working_hours` FROM `orders` WHERE `id`=?";
        try (Connection conn = DbUtil.getConn()) {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            List<Order> results = getOrdersFromResultSet(rs);
            if(!results.isEmpty()){
                return results.get(0);
            }
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
        String sql = "INSERT INTO `orders` (`arrival_date`, `planned_repair_date`, `real_repair_date`, `employees_id`, `problem_description`, `repair_description`, `status_id`, `vehicles_id`, `total_cost`, `parts_cost`, `working_hours`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DbUtil.getConn()) {
            String[] generatedColumns = {"id"};
            PreparedStatement st = conn.prepareStatement(sql, generatedColumns);
            if(order.getArrivalDate() != null){

                st.setDate(1, new Date(order.getArrivalDate().getTime()));
            }else {
                st.setDate(1, null);
            }

            if (order.getPlannedRepairDate() != null) {
                st.setDate(2, new Date(order.getPlannedRepairDate().getTime()));
            } else {
                st.setDate(2, null);
            }

            if (order.getRealRepairDate() != null){
                st.setDate(3, new Date(order.getRealRepairDate().getTime()));
            }else {
                st.setDate(3,null);
            }
            st.setInt(4, order.getEmployee().getId());
            st.setString(5, order.getProblemDescription());
            st.setString(6, order.getRepairDescription());
            st.setInt(7, order.getStatus().getId());
            st.setInt(8, order.getVehicle().getId());
            st.setBigDecimal(9, order.getTotalCost());
            st.setBigDecimal(10, order.getPartsCost());
            st.setBigDecimal(11, order.getWorkingHours());
            st.executeUpdate();
            ResultSet res = st.getGeneratedKeys();
            if (res.next()) {
                return res.getInt(1);
            }
        }
        return 0;
    }

    private static int update(Order order) throws SQLException {
        String sql = "UPDATE `orders` SET `arrival_date`=?, `planned_repair_date`=?, `real_repair_date`=?, `employees_id`=?, `problem_description`=?, `repair_description`=?, `status_id`=?, `vehicles_id`=?, `total_cost`=?, `parts_cost`=?, `working_hours`=? WHERE `id`=?";
        try (Connection conn = DbUtil.getConn()) {
            PreparedStatement st = conn.prepareStatement(sql);
            if(order.getArrivalDate() != null){

            st.setDate(1, new Date(order.getArrivalDate().getTime()));
            }else {
                st.setDate(1, null);
            }

            if (order.getPlannedRepairDate() != null) {
                st.setDate(2, new Date(order.getPlannedRepairDate().getTime()));
            } else {
                st.setDate(2, null);
            }

            if (order.getRealRepairDate() != null){
                st.setDate(3, new Date(order.getRealRepairDate().getTime()));
            }else {
                st.setDate(3,null);
            }
            st.setInt(4, order.getEmployee().getId());
            st.setString(5, order.getProblemDescription());
            st.setString(6, order.getRepairDescription());
            st.setInt(7, order.getStatus().getId());
            st.setInt(8, order.getVehicle().getId());
            st.setBigDecimal(9, order.getTotalCost());
            st.setBigDecimal(10, order.getPartsCost());
            st.setBigDecimal(11, order.getWorkingHours());
            st.setInt(12, order.getId());

            if (st.executeUpdate() > 0) {
                return order.getId();
            }
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
            }
        }

        return 0;
    }

    public static List<Order> loadByEmployeeId (int employee_id) throws SQLException {

        String sql = "SELECT `id`, `arrival_date`, `planned_repair_date`, `real_repair_date`, `employees_id`, `problem_description`, `repair_description`, `status_id`, `vehicles_id`, `total_cost`, `parts_cost`, `working_hours` FROM `orders` WHERE `employees_id`=?";
        try (Connection conn = DbUtil.getConn()) {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, employee_id);

            ResultSet rs = st.executeQuery();
            List<Order> result = getOrdersFromResultSet(rs);
            return result;
        }
    }


    private static List<Order> getOrdersFromResultSet(ResultSet rs) throws SQLException {
        List<Order> result = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt(1);
            Date arrivalDate = rs.getDate(2);
            Date plannedRepairDate = rs.getDate(3);
            Date realRepairDate = rs.getDate(4);
            Employee employee = EmployeeDAO.loadById(rs.getInt(5));
            String problemDescription = rs.getString(6);
            String repairDescription = rs.getString(7);
            int statusId = rs.getInt(8);
            Vehicle vehicle = VehicleDAO.loadById(rs.getInt(9));
            BigDecimal totalCost = rs.getBigDecimal(10);
            BigDecimal partsCost = rs.getBigDecimal(11);
            BigDecimal workingHours = rs.getBigDecimal(12);
            result.add(new Order(id, arrivalDate, plannedRepairDate, realRepairDate, employee, problemDescription, repairDescription, StatusDAO.loadById(statusId), vehicle, totalCost, partsCost, workingHours));
        }
        return result;
    }

}
