package pl.coderslab.dao;

import pl.coderslab.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerDAO {

    public static List<Customer> loadAll() {

        try (Connection conn = DbUtil.getConn()) {
            String sql = "SELECT id, first_name, second_name, birthday FROM customer;";
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

    public static Customer loadById(int id){

        try (Connection conn = DbUtil.getConn()) {
            String sql = "SELECT first_name, second_name, birthday FROM customer WHERE id=?;";
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

    public static int save(Customer customer){
        if(customer != null){
            if(customer.getId() == 0){
                return insert(customer);
            }
            else {
                return update(customer);
            }
        }
        return 0;
    }

    private static int insert(Customer customer) {
        return 0;
    }

    private static int update(Customer customer) {
        return 0;

    }
}
