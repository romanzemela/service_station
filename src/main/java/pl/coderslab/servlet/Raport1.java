package pl.coderslab.servlet;

import pl.coderslab.dao.RaportDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/raport1")
public class Raport1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<pl.coderslab.model.Raport1> raport1s = null;
        try {
            raport1s = RaportDAO.getRaport1();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("raport1s", raport1s);
        getServletContext().getRequestDispatcher("/WEB-INF/raport1.jsp").forward(request, response);
    }
}
