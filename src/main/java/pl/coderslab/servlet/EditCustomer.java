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

@WebServlet("/customers/edit")
public class EditCustomer extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("firstName");
        String secondName = request.getParameter("secondName");
        String date = request.getParameter("birthDay");
        Date birthday = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyy-MM-dd");
        try {
            birthday = sdf.parse(date);
        } catch (ParseException ignore) {
        }
        Customer customer = new Customer(id,firstName, secondName, birthday);

        try {
            CustomerDAO.save(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/customers");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = 0;
        Customer customer = null;
        try {
            id = Integer.parseInt(request.getParameter("id"));
            customer = CustomerDAO.loadById(id);
            request.setAttribute("customer", customer);
            getServletContext().getRequestDispatcher("/WEB-INF/editCustomer.jsp").forward(request,response);
        } catch (NumberFormatException ignore) {
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
