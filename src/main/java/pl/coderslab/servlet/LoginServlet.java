package pl.coderslab.servlet;

import pl.coderslab.dao.UserDAO;
import pl.coderslab.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        User user = null;
        try {
            user = UserDAO.loadByUsername(username);
        } catch (SQLException ignore) {
        }

        if (user != null && UserDAO.checkPassword(user, password)) {
            session.setAttribute("id", user.getId());
            String url = (String) session.getAttribute("url");
            response.sendRedirect(url);
        } else {
            request.setAttribute("password", false);
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }

        protected void doGet (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }
