package main.beans;

import java.sql.Date;

public class AuditTrail {

    private String user_id;
    private String activity;
    private Date from;
    private Date to;

    public AuditTrail(){}

    public AuditTrail(String user_id, String activity, Date from, Date to) {
        this.user_id = user_id;
        this.activity = activity;
        this.from = from;
        this.to = to;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
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

    @Override
    public String toString() {
        return "AuditTrail{" +
                "user_id='" + user_id + '\'' +
                ", activity='" + activity + '\'' +
                ", from=" + from +
                ", to=" + to +
                '}';
    }
}
