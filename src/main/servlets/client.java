package main.servlets;

import main.beans.Equipment;
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
        EquipmentManager manager = new EquipmentManager();
        try {
            eq = manager.getAllEquipments();
            HttpSession session  = req.getSession();
            session.setAttribute("eq", eq);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String url = resp.encodeRedirectURL("/client.jsp");
        resp.sendRedirect(url);
    }
}
