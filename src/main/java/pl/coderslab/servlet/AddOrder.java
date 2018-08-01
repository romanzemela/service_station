package pl.coderslab.servlet;

import pl.coderslab.dao.EmployeeDAO;
import pl.coderslab.dao.VehicleDAO;
import pl.coderslab.model.Employee;
import pl.coderslab.model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/orders/add")
public class AddOrder extends HttpServlet {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Employee> employees = EmployeeDAO.loadAll();
            List<Vehicle> vehicles = VehicleDAO.loadAll();

            request.setAttribute("arrivalDate", sdf.format(new Date()));
            request.setAttribute("plannedRepairDate", sdf.format(new Date()));
            request.setAttribute("employees", employees);
            request.setAttribute("vehicles", vehicles);

            getServletContext().getRequestDispatcher("/WEB-INF/addOrder.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
