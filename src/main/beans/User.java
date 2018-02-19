package main.beans;

public class User {

    private String user_id;
    private String name;
    private String password;
    private String faculty;
    private String department;
    private String email;
    private Role role;

    public User(){}

    public User(String user_id, String name, String password, String faculty, String department, String email, Role role) {
        this.user_id = user_id;
        this.name = name;
        this.password = password;
        this.faculty = faculty;
        this.department = department;
        this.email = email;
        this.role = role;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id='" + user_id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", faculty='" + faculty + '\'' +
                ", department='" + department + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
