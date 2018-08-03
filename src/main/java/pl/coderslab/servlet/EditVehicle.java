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

@WebServlet("/vehicles/edit")
public class EditVehicle extends HttpServlet {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyyy-MM-dd");

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String model = request.getParameter("model");
        String brand = request.getParameter("brand");
        Year productionYear = Year.parse(request.getParameter("productionYear"));
        String plateNumber = request.getParameter("plateNumber");
        String nextInspectionDate = request.getParameter("nextInspectionDate");
        Date nextInspectionDateDate = null;
        try {
            nextInspectionDateDate = sdf.parse(nextInspectionDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Integer customerId = Integer.parseInt(request.getParameter("customer"));
        String redirectString = "/vehicles?customerId=";
        try {
            Vehicle vehicle = new Vehicle(id, model, brand, productionYear, plateNumber, nextInspectionDateDate, CustomerDAO.loadById(customerId));
            VehicleDAO.save(vehicle);
            redirectString += vehicle.getCustomer().getId();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect(redirectString);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = 0;
        Vehicle vehicle = null;
        try {
            id = Integer.parseInt(request.getParameter("id"));
            vehicle = VehicleDAO.loadById(id);
            request.setAttribute("vehicle", vehicle);

            int year = Calendar.getInstance().get(Calendar.YEAR);
            request.setAttribute("maxYear", year);

            List<Customer> customers = CustomerDAO.loadAll();
            request.setAttribute("customers", customers);
            getServletContext().getRequestDispatcher("/WEB-INF/editVehicle.jsp").forward(request, response);
        } catch (NumberFormatException ignore) {
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
