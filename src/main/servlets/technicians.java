package main.servlets;

import main.beans.Equipment;
import main.databaseManager.EquipmentManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/technician")
public class technicians extends HttpServlet{

    EquipmentManager EquipmentManager = new EquipmentManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Equipment> eq = EquipmentManager.getAllEquipments();
            req.setAttribute("data", eq);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/technicians/view_equipments.jsp").forward(req, resp);
    }


}
