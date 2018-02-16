package main.servlets;

import main.Validation.validate;
import main.beans.User;
import main.databaseManager.UserManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/register")
public class register extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        validate validator = new validate();
        User user = validator.validateNewUser(req, resp);

        if (user != null){
            System.out.println("user validated");
            UserManager manager = new UserManager();
            try {
                manager.addUser(user);
                System.out.println("user added");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            HttpSession session = req.getSession();
            session.setAttribute("user", user.getUser_id());
            session.setMaxInactiveInterval(30*60);
            Cookie userName = new Cookie("user", user.getUser_id());
            userName.setMaxAge(30*60);
            resp.addCookie(userName);
            /* url encoding */
            String url = resp.encodeRedirectURL("/technician");
            resp.sendRedirect(url);
        }else {
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        }


    }
}
