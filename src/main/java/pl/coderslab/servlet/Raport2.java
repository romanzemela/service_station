package pl.coderslab.servlet;

import pl.coderslab.dao.RaportDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/raport2")
public class Raport2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer raport2 = null;
        try {
            raport2 = RaportDAO.getRaport2();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("raport2", raport2);
        getServletContext().getRequestDispatcher("/WEB-INF/raport2.jsp").forward(request, response);
    }
}

