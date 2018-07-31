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
import java.text.ParseException;


@WebServlet("/employee/add")
public class AddEmployee extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String name = request.getParameter("name");
    String surname = request.getParameter("surname");
    String address = request.getParameter("address");
    int phone = Integer.parseInt(request.getParameter("phone"));
    String note = request.getParameter("note");
    float rate = Float.parseFloat(request.getParameter("rate"));

    Employee employee = new Employee(name, surname, address, phone, note, rate);

        try {
        EmployeeDAO.save(employee);
    } catch (SQLException e) {
        e.printStackTrace();
    }
        response.sendRedirect("/employees");
}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/addEmployee.jsp").forward(request, response);

    }
}
