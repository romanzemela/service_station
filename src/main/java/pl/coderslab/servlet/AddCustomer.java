package pl.coderslab.servlet;

import pl.coderslab.dao.CustomerDAO;
import pl.coderslab.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/customers/add")
public class AddCustomer extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String secondName = request.getParameter("secondName");
        String date = request.getParameter("birthDay");
        Date birthday = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyy-MM-dd");
        try {
            birthday = sdf.parse(date);
        } catch (ParseException ignore) {
        }
        Customer customer = new Customer(firstName, secondName, birthday);

        try {
            CustomerDAO.save(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/customers");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/addCustomer.jsp").forward(request, response);

    }
}
