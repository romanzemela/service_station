package pl.coderslab.servlet;

import pl.coderslab.dao.EmployeeDAO;
import pl.coderslab.dao.OrderDAO;
import pl.coderslab.dao.StatusDAO;
import pl.coderslab.dao.VehicleDAO;
import pl.coderslab.model.Employee;
import pl.coderslab.model.Order;
import pl.coderslab.model.Status;
import pl.coderslab.model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/orders/edit")
public class EditOrder extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String arrivalDate = request.getParameter("arrivalDate");
        String plannedRepairDate = request.getParameter("plannedRepairDate");
        String realRepairDate = request.getParameter("realRepairDate");
        Integer employeeId = Integer.parseInt(request.getParameter("employee"));
        String problemDescription = request.getParameter("problemDescription");
        String repairDescription = request.getParameter("repairDescription");
        int statusId = Integer.parseInt(request.getParameter("status"));
        Integer vehicleId = Integer.parseInt(request.getParameter("vehicle"));
        BigDecimal totalCost = BigDecimal.valueOf(Double.parseDouble(request.getParameter("totalCost")));
        BigDecimal partsCost = BigDecimal.valueOf(Double.parseDouble(request.getParameter("partsCost")));
        Integer workingHours = Integer.parseInt(request.getParameter("workingHours"));


        Date arrivalDateDate = null;
        Date plannedRepairDateDate = null;
        Date realRepairDateDate = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyy-MM-dd");
        try {
            arrivalDateDate = sdf.parse(arrivalDate);
            plannedRepairDateDate = sdf.parse(plannedRepairDate);
            realRepairDateDate = sdf.parse(realRepairDate);
        } catch (ParseException ignore) {
        }
        try {
            Order order = new Order(id, arrivalDateDate, plannedRepairDateDate, realRepairDateDate, EmployeeDAO.loadById(employeeId),
                    problemDescription, repairDescription, StatusDAO.loadById(statusId), VehicleDAO.loadById(vehicleId), totalCost, partsCost, workingHours);
            OrderDAO.save(order);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Order order = OrderDAO.loadById(id);
            List<Employee> employees = EmployeeDAO.loadAll();
            List<Vehicle> vehicles = VehicleDAO.loadAll();
            List<Status> statuses = StatusDAO.loadAll();

            request.setAttribute("order", order);
            request.setAttribute("employees", employees);
            request.setAttribute("vehicles", vehicles);
            request.setAttribute("statuses", statuses);
            getServletContext().getRequestDispatcher("/WEB-INF/editOrder.jsp").forward(request, response);
        } catch (NumberFormatException ignore) {
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
