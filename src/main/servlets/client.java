package main.servlets;

import main.beans.BookedEquipment;
import main.beans.Equipment;
import main.beans.User;
import main.databaseManager.EquipmentManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/client")
public class client extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<Equipment> eq = new ArrayList<>();
        ArrayList<BookedEquipment> bk = new ArrayList<>();
        EquipmentManager manager = new EquipmentManager();
        HttpSession session  = req.getSession();
        try {
            eq = manager.getAllEquipments();
            User user = (User) session.getAttribute("user");
            bk = manager.getMyBookings(user.getUser_id());
            session.setAttribute("eq", eq);
            session.setAttribute("bk", bk);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String url = resp.encodeRedirectURL("/client.jsp");
        resp.sendRedirect(url);
    }
}
