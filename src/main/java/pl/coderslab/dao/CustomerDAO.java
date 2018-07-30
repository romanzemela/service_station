package pl.coderslab.dao;

import pl.coderslab.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerDAO {

    public static List<Customer> loadAll() {

        String sql = "SELECT `id`, `name`, `surname`, `birth_date` FROM `customers`";
        try (Connection conn = DbUtil.getConn()) {
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            List<Customer> result = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt(1);
                String firstName = rs.getString(2);
                String secondName = rs.getString(3);
                Date birthday = rs.getDate(4);
                result.add(new Customer(id, firstName, secondName, birthday));
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public static Customer loadById(int id) {

        String sql = "SELECT `name`, `surname`, `birth_date` FROM `customers` WHERE `id`=?";
        try (Connection conn = DbUtil.getConn()) {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String firstName = rs.getString(1);
                String secondName = rs.getString(2);
                Date birthday = rs.getDate(3);
                return new Customer(id, firstName, secondName, birthday);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int save(Customer customer) {
        if (customer != null) {
            if (customer.getId() == 0) {
                return insert(customer);
            } else {
                return update(customer);
            }
        }
        return 0;
    }

    private static int insert(Customer customer) {
        String sql = "INSERT INTO `customers` (`name`, `surname`, `birth_date`) VALUES (?, ?, ?)";
        try (Connection conn = DbUtil.getConn()) {
            String[] generatedColumns = {"id"};
            PreparedStatement st = conn.prepareStatement(sql, generatedColumns);
            st.setString(1, customer.getFirstName());
            st.setString(2, customer.getSecondName());
            st.setDate(3, new Date(customer.getBirthday().getTime()));
            st.executeUpdate();
            ResultSet res = st.getGeneratedKeys();
            if (res.next()) {
                return res.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private static int update(Customer customer) {
        String sql = "UPDATE `customers` SET `name`=?, `surname`='?, `birth_date`=? WHERE `id`=?";
        try (Connection conn = DbUtil.getConn()) {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, customer.getFirstName());
            st.setString(2, customer.getSecondName());
            st.setDate(3, (Date) customer.getBirthday());
            st.setInt(4, customer.getId());
            if (st.executeUpdate() > 0) {
                return customer.getId();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;

    }

    public static int delete(Customer customer) {
        String sql = "DELETE FROM `customers` WHERE `id`=?";
        if (customer.getId() != 0) {
            try (Connection conn = DbUtil.getConn()) {
                PreparedStatement st = conn.prepareStatement(sql);
                st.setInt(1, customer.getId());
                int result = st.executeUpdate();
                customer.setId(0);
                return result;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return 0;
    }
}
