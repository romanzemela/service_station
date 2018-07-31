package pl.coderslab.dao;

import pl.coderslab.model.Vehicle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VehicleDAO {
    public static List<Vehicle> loadAll() throws SQLException {
        String sql = "SELECT `id`, `model`, `brand`, `production_year`, `plate_number`, `next_inspection_date`, `client_id` FROM `vehicles`";
        try (Connection conn = DbUtil.getConn()) {
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            List<Vehicle> result = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt(1);
                String model = rs.getString(2);
                String brand = rs.getString(3);
                Year productionYear = Year.of(rs.getInt(4));
                String plateNumber = rs.getString(5);
                Date nextInpectionDate = rs.getDate(6);
                int customerId = rs.getInt(7);
                result.add(new Vehicle(id, model, brand, productionYear, plateNumber, nextInpectionDate, CustomerDAO.loadById(customerId)));
            }
            return result;
        } catch (SQLException e) {
            throw e;
        }


    }

    public static Vehicle loadById(int id) throws SQLException {
        String sql = "SELECT `model`, `brand`, `production_year`, `plate_number`, `next_inspection_date`, `client_id` FROM `vehicles` WHERE `id`=?";
        try (Connection conn = DbUtil.getConn()) {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String model = rs.getString(1);
                String brand = rs.getString(2);
                Year productionYear = Year.of(rs.getInt(3));
                String plateNumber = rs.getString(4);
                Date nextInpectionDate = rs.getDate(5);
                int customerId = rs.getInt(6);
                return new Vehicle(id, model, brand, productionYear, plateNumber, nextInpectionDate, CustomerDAO.loadById(customerId));
            }
        } catch (SQLException e) {
            throw e;
        }
        return null;
    }

    public static int save(Vehicle vehicle) throws SQLException {
        if (vehicle != null) {
            if (vehicle.getId() == 0) {
                return insert(vehicle);
            } else {
                return update(vehicle);
            }
        }
        return 0;
    }

    private static int update(Vehicle vehicle) throws SQLException {
        String sql = "UPDATE `vehicles` SET `model`=?, `brand`=?, `production_year`=?, `plate_number`=?, `next_inspection_date`=?, `client_id`=? FROM `vehicle` WHERE `id`=?";
        try (Connection conn = DbUtil.getConn()) {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, vehicle.getModel());
            st.setString(2, vehicle.getBrand());
            st.setInt(3, vehicle.getProductionYear().getValue());
            st.setString(4, vehicle.getPlateNumber());
            st.setDate(5, (java.sql.Date) vehicle.getNextInspectionDate());
            st.setInt(6, vehicle.getCustomer().getId());
            st.setInt(7, vehicle.getId());
            if (st.executeUpdate() > 0) {
                return vehicle.getId();
            }
        } catch (SQLException e) {
            throw e;
        }
        return 0;
    }

    private static int insert(Vehicle vehicle) throws SQLException {
        String sql = "INSERT INTO `vehcles`(`model`, `brand`, `production_year`, `plate_number`, `next_inspection_date`, `client_id`) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DbUtil.getConn()) {
            String[] generatedColumns = {"id"};
            PreparedStatement st = conn.prepareStatement(sql, generatedColumns);
            st.setString(1, vehicle.getModel());
            st.setString(2, vehicle.getBrand());
            st.setInt(3, vehicle.getProductionYear().getValue());
            st.setString(4, vehicle.getPlateNumber());
            st.setDate(5, (java.sql.Date) vehicle.getNextInspectionDate());
            st.setInt(6, vehicle.getCustomer().getId());
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

    public static int delete(Vehicle vehicle) throws SQLException {
        String sql = "DELETE FROM `vehicles` WHERE `id`=?";
        if (vehicle.getId() != 0) {
            try (Connection conn = DbUtil.getConn()) {
                PreparedStatement st = conn.prepareStatement(sql);
                st.setInt(1, vehicle.getId());
                int result = st.executeUpdate();
                vehicle.setId(0);
                return result;
            } catch (SQLException e) {
                throw e;
            }
        }
        return 0;
    }


}
