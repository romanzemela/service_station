package pl.coderslab.servlet;


import pl.coderslab.dao.EmployeeDAO;
import pl.coderslab.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;


@WebServlet("/employees/edit")
public class EmployeeEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String address = request.getParameter("address");
        int phone = Integer.parseInt(request.getParameter("phone"));
        String note = request.getParameter("note");
        BigDecimal rate = BigDecimal.valueOf(Double.parseDouble(request.getParameter("rate")));

        Employee employee = new Employee(id,name, surname, address, phone, note, rate);

        try {
            EmployeeDAO.save(employee);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/employees");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = 0;
        Employee employee = null;
        try {
            id = Integer.parseInt(request.getParameter("id"));
            employee = EmployeeDAO.loadById(id);
            request.setAttribute("employee", employee);
            getServletContext().getRequestDispatcher("/WEB-INF/editEmployee.jsp").forward(request,response);
        } catch (NumberFormatException ignore) {
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
