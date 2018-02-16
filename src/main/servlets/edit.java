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

@WebServlet("/edit")
public class edit extends HttpServlet{

    EquipmentManager manager = new EquipmentManager();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("eqp_name");
        Equipment eq = new Equipment();
        eq.setEqp_id(id);

        try {
            Equipment bean = manager.getElementByName(eq);
            HttpSession session = req.getSession();
            session.setAttribute("bean", bean);
            String url = resp.encodeRedirectURL("/edit_equipment.jsp");
            resp.sendRedirect(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
