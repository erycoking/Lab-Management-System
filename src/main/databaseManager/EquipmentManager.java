package main.databaseManager;

import main.ConnectionManager;
import main.beans.Equipment;

import java.sql.*;
import java.util.ArrayList;

public class EquipmentManager {

    public boolean addEquipments(Equipment eq) throws SQLException {

        String sql = "INSERT INTO equipments(eqp_id, eqp_name, eqp_desc, eqp_cost," +
                "eqp_quantity, eqp_category, calibration_date) VALUES (?,?,?,?,?,?,?)";

        Connection conn  = null;

        PreparedStatement st = null;

        try {
            conn  = ConnectionManager.getInstance().getConnection();
            st = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            st.setString(1, eq.getEqp_id());
            st.setString(2, eq.getEqpname());
            st.setString(3, eq.getEqpdetails());
            st.setDouble(4, eq.getEqpcost());
            st.setDouble(5, eq.getQuantity());
            st.setString(6, eq.getEqpCategory());
            st.setDate(7, eq.getLast_calibration());

            if (st.execute()){
                if(addAvailable(eq))
                    return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (st != null)
                st.close();
        }
        return false;
    }

    public boolean addAvailable(Equipment eq) throws SQLException {

        String sql = "INSERT INTO equipments(eqp_id, eqp_quantity) VALUES (?,?)";

        Connection conn  = null;

        PreparedStatement st = null;

        try {
            conn  = ConnectionManager.getInstance().getConnection();
            st = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            st.setString(1, eq.getEqp_id());
            st.setDouble(2, eq.getQuantity());

            if (st.execute()){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (st != null)
                st.close();
        }
        return false;
    }



    /* gets all equipments*/
    public ArrayList<Equipment> getAllEquipments() throws SQLException {
        ArrayList<Equipment> data = new ArrayList<>();
        String sql = "SELECT * FROM `asm`.`equipments`";
        ResultSet rs = null;
        Statement st = null;

        Connection conn = null;

        try {
            conn = ConnectionManager.getInstance().getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()){
                data.add(new Equipment(
                        rs.getString("eqp_id"),
                        rs.getString("eqp_name"),
                        rs.getString("eqp_desc"),
                        rs.getDouble("eqp_cost"),
                        rs.getInt("eqp_quantity"),
                        rs.getString("eqp_category"),
                        rs.getDate("calibration_date")
                ));
                System.out.println(data);
            }
            return data;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            if (rs != null)
                rs.close();
            if (st != null)
                st.close();
        }
    }

    /* get a single equipment by id */
    public Equipment getElementById(Equipment eq) throws SQLException {
        String sql = "Select * from equipments where eqp_id = ?";

        Connection conn  = null;

        ResultSet rs = null;
        PreparedStatement st = null;

        try {
            conn  = ConnectionManager.getInstance().getConnection();
            st = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            st.setString(1, eq.getEqp_id());
            rs = st.executeQuery();
            Equipment bean = null;
            while (rs.next()){
                bean = new Equipment(
                        rs.getString("eqp_id"),
                        rs.getString("eqp_name"),
                        rs.getString("eqp_desc"),
                        rs.getInt("eqp_cost"),
                        rs.getInt("eqp_quantity"),
                        rs.getString("eqp_category"),
                        rs.getDate("calibration_date")
                );
            }
            return bean;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null)
                rs.close();
            if (st != null)
                st.close();
        }
        return null;
    }

    /* gets a single element by name*/
    public Equipment getElementByName(Equipment eq) throws SQLException {
        String sql = "Select * from equipments where eqp_name = ?";

        Connection conn  = null;

        ResultSet rs = null;
        PreparedStatement st = null;

        try {
            conn  = ConnectionManager.getInstance().getConnection();
            st = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            st.setString(1, eq.getEqpname());
            rs = st.executeQuery();
            Equipment bean = null;
            while (rs.next()){
                bean = new Equipment(
                        rs.getString("eqp_id"),
                        rs.getString("eqp_name"),
                        rs.getString("eqp_desc"),
                        rs.getInt("eqp_cost"),
                        rs.getInt("eqp_quantity"),
                        rs.getString("eqp_category"),
                        rs.getDate("calibration_date")
                );
            }
            return bean;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null)
                rs.close();
            if (st != null)
                st.close();
        }
        return null;
    }

    /* updates an equipment */
    public boolean updateEquipments(Equipment eq) throws SQLException {

        String sql = "UPDATE equipments SET eqp_id = ?, eqp_name = ?, eqp_desc = ?," +
                "eqp_cost = ?, eqp_quantity = ?, eqo_category = ?, calibartion_date = ?" +
                "WHERE eqp_name = ?";

        Connection conn  = null;

        PreparedStatement st = null;

        try {
            conn  = ConnectionManager.getInstance().getConnection();
            st = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            st.setString(1, eq.getEqp_id());
            st.setString(2, eq.getEqpname());
            st.setString(3, eq.getEqpdetails());
            st.setDouble(4, eq.getEqpcost());
            st.setDouble(5, eq.getQuantity());
            st.setString(6, eq.getEqpCategory());
            st.setDate(7, eq.getLast_calibration());
            st.setString(8, eq.getEqpname());

            if (st.execute())
                return true;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (st != null)
                st.close();
        }
        return false;
    }

    /* deletes an equipment using name */
    public boolean deleteEquipmentsByName(Equipment eq) throws SQLException {

        String sql = "DELETE  FROM `asm`.`equipment` WHERE `eqp_id` = ?";

        Connection conn  = null;

        PreparedStatement st = null;

        try {
            conn  = ConnectionManager.getInstance().getConnection();
            st = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            st.setString(1, eq.getEqpname());

            if (st.execute())
                return true;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (st != null)
                st.close();
        }

        return false;
    }

    /* deletes an equipment using id*/
    public boolean deleteEquipmentsById(Equipment eq) throws SQLException {

        String sql = "DELETE  FROM `asm`.`equipment` WHERE `eqp_name` = ?";

        Connection conn  = null;

        PreparedStatement st = null;

        try {
            conn  = ConnectionManager.getInstance().getConnection();
            st = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            st.setString(1, eq.getEqp_id());

            if (st.execute())
                return true;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (st != null)
                st.close();
        }

        return false;
    }

    public ArrayList<Equipment> getBookedEquipment() throws SQLException {

        ArrayList<Equipment> data = new ArrayList<>();
        String sql = "SELECT equipments.eqp_id, equipments.eqp_name, equipments.eqp_desc, equipments.eqp_cost, " +
                "equipments.eqp_category, equipments.calibration_date, booked_eqp.eqp_quantity from equipments " +
                "inner join booked_eqp on equipments.eqp_id=booked_eqp.eqp_id";

        ResultSet rs = null;
        Statement st = null;

        Connection conn = null;

        try {
            conn = ConnectionManager.getInstance().getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()){
                data.add(new Equipment(
                        rs.getString("eqp_id"),
                        rs.getString("eqp_name"),
                        rs.getString("eqp_desc"),
                        rs.getInt("eqp_cost"),
                        rs.getInt("eqp_quantity"),
                        rs.getString("eqp_category"),
                        rs.getDate("calibration_date")
                ));
            }
            return data;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (rs != null)
                rs.close();
            if (st != null)
                st.close();
        }

        return null;
    }

    public ArrayList<Equipment> getAvailableEquipment() throws SQLException {

        ArrayList<Equipment> data = new ArrayList<>();
        String sql = "SELECT equipments.eqp_id, equipments.eqp_name, equipments.eqp_desc, equipments.eqp_cost, " +
                "equipments.eqp_category, equipments.calibration_date, available_equipments.eqp_quantity from equipments " +
                "inner join booked_eqp on equipments.eqp_id=available_equipments.eqp_id";

        ResultSet rs = null;
        Statement st = null;

        Connection conn = null;

        try {
            conn = ConnectionManager.getInstance().getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()){
                data.add(new Equipment(
                        rs.getString("eqp_id"),
                        rs.getString("eqp_name"),
                        rs.getString("eqp_desc"),
                        rs.getInt("eqp_cost"),
                        rs.getInt("eqp_quantity"),
                        rs.getString("eqp_category"),
                        rs.getDate("calibration_date")
                ));
            }
            return data;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (rs != null)
                rs.close();
            if (st != null)
                st.close();
        }

        return null;
    }
}
