package pl.coderslab.servlet;

import pl.coderslab.dao.EmployeeDAO;
import pl.coderslab.model.Employee;
import pl.coderslab.model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/employees/employeeOrders")
public class EmployeeOrders extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = 0;
        try {
            id = Integer.parseInt(request.getParameter("id"));
            List<Order> orders = EmployeeDAO.ordersForEmployeeId(id);
            request.setAttribute("orders", orders);
            getServletContext().getRequestDispatcher("/WEB-INF/employeeOrders.jsp").forward(request,response);
        } catch (NumberFormatException ignore) {
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
