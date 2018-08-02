package pl.coderslab.servlet;

import pl.coderslab.dao.CustomerDAO;
import pl.coderslab.dao.VehicleDAO;
import pl.coderslab.model.Customer;
import pl.coderslab.model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@WebServlet("/vehicles")
public class Vehicles extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer customerId = null;
        List<Vehicle> vehicles = Collections.emptyList();
        try {
            customerId = Integer.parseInt(request.getParameter("customerId"));
        } catch (NumberFormatException ignore) {
        }
        try {
            if (customerId == null) {
                vehicles = VehicleDAO.loadAll();

            } else {
                vehicles = VehicleDAO.loadAllByCustomerId(customerId);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("vehicles", vehicles);

        try {
            List<Customer> customers = CustomerDAO.loadAll();
            request.setAttribute("customers", customers);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        getServletContext().getRequestDispatcher("/WEB-INF/vehicles.jsp").forward(request, response);

    }
}
