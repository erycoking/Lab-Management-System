package main.Validation;

import main.beans.User;

import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter({"/register", "/addEquipment"})
public class validate extends HttpFilter{

    public User validateNewUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        HttpSession session = req.getSession();
        String user_id = req.getParameter("user_id");
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String faculty = req.getParameter("faculty");
        String department = req.getParameter("department");
        String email = req.getParameter("email");
        String role = req.getParameter("role");

        User user;

        if (user_id.matches("([\\w]{3,4}[/]{1}[\\d]{5}[/]{1}[\\d]+)")){
            if (name.matches("([a-zA-Z]+[ ']*)+")){
                if (password.matches("([A-z]+\\d*[*/-]*)+")){
                    if (faculty.matches("([A-z]{3,}[ ]*)+")){
                        if (department.matches("([A-z]{3,}[ ]*)+")){
                            if (email.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:" +
                                    "[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")" +
                                    "@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|" +
                                    "[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:" +
                                    "(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")){
                                if (role.matches("[A-z]{3,}")){
                                    user = new User(
                                            user_id,
                                            name,
                                            password,
                                            faculty,
                                            department,
                                            email,
                                            role
                                    );

                                    return user;
                                }else {
                                    session.setAttribute("role", "Incorrect role");
                                    System.out.println("Incorrect role");
                                }
                            }else {
                                session.setAttribute("emailErrMsg", "Incorrect email");
                                System.out.println("Incorrect email");
                            }
                        }else {
                            session.setAttribute("departmentErrMsg", "Incorrect department");
                            System.out.println("Incorrect department");
                        }
                    }else {
                        session.setAttribute("facultyErrMsg", "incorrect faculty");
                        System.out.println("Incorrect faculty");

                    }
                }else {
                    session.setAttribute("passwordErrMsg", "Weak Password");
                    System.out.println("Incorrect password");

                }
            }else{
                session.setAttribute("nameErrMsg", "Incorrect name");
                System.out.println("Incorrect name");

            }
        }else {
            session.setAttribute("useridErrMsg", "Incorrect User Id");
            System.out.println("Incorrect userID");

        }

        return null;
    }
}
