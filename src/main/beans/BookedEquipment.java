package main.beans;

import java.sql.Date;

public class BookedEquipment {
    private Equipment eq;
    private Date from;
    private Date to;
    private User user;

    public BookedEquipment() {
    }

    public BookedEquipment(Equipment eq, Date from, Date to, User user) {
        this.eq = eq;
        this.from = from;
        this.to = to;
        this.user = user;
    }

    public Equipment getEq() {
        return eq;
    }

    public void setEq(Equipment eq) {
        this.eq = eq;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
