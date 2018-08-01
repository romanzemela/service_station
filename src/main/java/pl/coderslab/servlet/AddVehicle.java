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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@WebServlet("/vehicles/add")
public class AddVehicle extends HttpServlet {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String model = request.getParameter("model");
        String brand = request.getParameter("brand");
        Integer productionYear = Integer.parseInt(request.getParameter("productionYear"));
        String plateNumber = request.getParameter("plateNumber");
        String nextInspectionDate = request.getParameter("nextInspectionDate");
        Integer customerId = Integer.parseInt(request.getParameter("customer"));

        Date nextInspectionDateDate = null;
        try {
            nextInspectionDateDate = sdf.parse(nextInspectionDate);

        } catch (ParseException ignore) {
        }
        try {
            Vehicle vehicle = new Vehicle(model, brand, Year.of(productionYear),
                    plateNumber, nextInspectionDateDate, CustomerDAO.loadById(customerId));
            VehicleDAO.save(vehicle);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/customers");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Customer> customers = CustomerDAO.loadAll();
            List<Vehicle> vehicles = VehicleDAO.loadAll();
            request.setAttribute("customers", customers);
            int year = Calendar.getInstance().get(Calendar.YEAR);
            request.setAttribute("year", year);
            request.setAttribute("vehicles", vehicles);
            getServletContext().getRequestDispatcher("/WEB-INF/addVehicle.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
