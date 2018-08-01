package pl.coderslab.servlet;

import pl.coderslab.dao.VehicleDAO;
import pl.coderslab.model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/vehicles")
public class Vehicles extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        List<Vehicle> vehicles = null;
        try {
            vehicles = VehicleDAO.loadAllByCustomerId(Integer.parseInt(request.getParameter("customerId")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("vehicles", vehicles);
        request.setAttribute("customer", request.getParameter("customer"));
        getServletContext().getRequestDispatcher("/WEB-INF/vehicles.jsp").forward(request, response);

    }
}
