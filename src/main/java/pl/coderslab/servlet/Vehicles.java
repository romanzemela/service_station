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
        List<Vehicle> vehicles = null;
        try {
            vehicles = VehicleDAO.loadAllByClientId(Integer.parseInt(request.getParameter("customer")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("vehicles", vehicles);
        getServletContext().getRequestDispatcher("/WEB-INF/vehicles.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
