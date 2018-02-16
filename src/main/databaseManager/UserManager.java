package main.databaseManager;

import main.ConnectionManager;
import main.Utility;
import main.beans.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;

public class UserManager {

    Utility utility = new Utility();

    /* add a user */
    public boolean addUser(User user) throws SQLException {

        String sql = "INSERT INTO users(user_id, name, password, " +
                "faculty, department, email, role) VALUES (?,?,?,?,?,?,?)";

        Connection conn = null;

        PreparedStatement st = null;

        try {
            conn = ConnectionManager.getInstance().getConnection();
            st = conn.prepareStatement(sql);
            st.setString(1, user.getUser_id());
            st.setString(2, user.getName());
            st.setString(3, utility.hashpwd(user.getPassword()));
            st.setString(4, user.getFaculty());
            st.setString(5, user.getDepartment());
            st.setString(6, user.getEmail());
            st.setString(7, user.getRole());

            if (st.execute())
                return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (st != null)
                st.close();
        }

        return false;
    }

    /* Get all users */
    public ArrayList<User> getAllUsers() throws SQLException {

        String sql = "SELECT * FROM users";

        Connection conn = null;
        Statement st  = null;
        ResultSet rs = null;

        try {
            conn = ConnectionManager.getInstance().getConnection();

            st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery(sql);

            ArrayList<User> users = new ArrayList<>();
            while (rs.next()){
                users.add(new User(
                        rs.getString("user_id"),
                        rs.getString("name"),
                        rs.getString("password"),
                        rs.getString("faculty"),
                        rs.getString("department"),
                        rs.getString("email"),
                        rs.getString("role")
                ));
            }

            return users;

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

    /* get one user using user Id */
    public User getUserByUserId(User user) throws SQLException {
        String sql = "SELECT * FROM users WHERE user_id = ?";

        Connection conn = null;
        PreparedStatement st  = null;
        ResultSet rs = null;

        try {
            conn = ConnectionManager.getInstance().getConnection();

            st = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            st.setString(1, user.getUser_id());
            rs = st.executeQuery(sql);

            User users = new User();
            while (rs.next()){
                users = new User(
                        rs.getString("user_id"),
                        rs.getString("name"),
                        rs.getString("password"),
                        rs.getString("faculty"),
                        rs.getString("department"),
                        rs.getString("email"),
                        rs.getString("role")
                );
            }

            return users;

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

    /* update a single user */
    public boolean updateUser(User user) throws SQLException {

        String sql = "UPDATE users SET user_id = ?, name = ?, password = ?, " +
                "faculty = ?, department = ?, email = ?, role = ?" +
                " WHERE user_id = ?)";

        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = ConnectionManager.getInstance().getConnection();
            st = conn.prepareStatement(sql);
            st.setString(1, user.getUser_id());
            st.setString(2, user.getName());
            st.setString(3, utility.hashpwd(user.getPassword()));
            st.setString(4, user.getFaculty());
            st.setString(5, user.getDepartment());
            st.setString(6, user.getEmail());
            st.setString(7, user.getRole());
            st.setString(8, user.getUser_id());

            if (st.execute())
                return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (st != null)
                st.close();
        }

        return false;
    }

    /* delete a user */
    public boolean deleteUser(User user) throws SQLException {

        String sql = "DELETE FROM users WHERE user_id = ?)";

        Connection conn = null;

        PreparedStatement st = null;

        try {
            conn = ConnectionManager.getInstance().getConnection();
            st = conn.prepareStatement(sql);
            st.setString(1, user.getUser_id());

            if (st.execute())
                return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (st != null)
                st.close();
        }

        return false;
    }

    public User login(User user) throws SQLException {
        String sql = "SELECT * FROM users WHERE user_id = ?";

        Connection conn = null;

        ResultSet rs = null;
        PreparedStatement st = null;

        try {
            conn  = ConnectionManager.getInstance().getConnection();
            if (conn != null){
                System.out.println("conn ok");
            }
            st = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            st.setString(1, user.getUser_id());
//            st.setString(2, utility.hashpwd(user.getPassword()));
            rs = st.executeQuery();

            while (rs.next()) {
                User user1 = new User(
                        rs.getString("user_id"),
                        rs.getString("name"),
                        rs.getString("password"),
                        rs.getString("faculty"),
                        rs.getString("department"),
                        rs.getString("email"),
                        rs.getString("role")
                );
                return user1;
            }

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
}
