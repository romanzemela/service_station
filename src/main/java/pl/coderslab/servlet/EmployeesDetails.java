package pl.coderslab.servlet;


import pl.coderslab.dao.EmployeeDAO;
import pl.coderslab.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/employees/details")
public class EmployeesDetails extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = 0;
        Employee employee = null;
        try {
            id = Integer.parseInt(request.getParameter("id"));
            employee = EmployeeDAO.loadById(id);
            request.setAttribute("employee", employee);
            getServletContext().getRequestDispatcher("/WEB-INF/employeesDetail.jsp").forward(request,response);
        } catch (NumberFormatException ignore) {
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
