package main.servlets;

import main.Utility;
import main.beans.User;
import main.databaseManager.UserManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class login extends HttpServlet {

    Utility tools = new Utility();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String password = req.getParameter("password");


        User user = new User();
        user.setUser_id(id);


        try {
            UserManager manager = new UserManager();
            User loggedInUser = manager.login(user);
            if (loggedInUser != null) {
                if(tools.verifyPasswd(password, loggedInUser.getPassword())){
                    System.out.println("password correct");
                    System.out.println(loggedInUser);
                    HttpSession session = req.getSession();
                    session.setAttribute("user", loggedInUser);
                    session.setMaxInactiveInterval(30*60);
                    Cookie userName = new Cookie("user", loggedInUser.getUser_id());
                    userName.setMaxAge(30*60);
                    resp.addCookie(userName);
                    String url = resp.encodeRedirectURL("/technician");
                    resp.sendRedirect(url);
                }else {
                    System.out.println("password Incorrect");
                    resp.sendRedirect("/");
                }
            }else {
                System.out.println("no user available");
                resp.sendRedirect("/");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
