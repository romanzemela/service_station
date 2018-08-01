package pl.coderslab.servlet;

import pl.coderslab.dao.OrderDAO;
import pl.coderslab.model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/")
public class Orders extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Order> orders = null;
        try {
            int employeeId = Integer.parseInt(request.getParameter("employeeId"));
            orders = OrderDAO.loadByEmployeeId(employeeId);
        } catch (NumberFormatException ignore) {
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (orders == null) {
                orders = OrderDAO.loadAll();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("orders", orders);
        getServletContext().getRequestDispatcher("/WEB-INF/orders.jsp").forward(request, response);
    }
}
