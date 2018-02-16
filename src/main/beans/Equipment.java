package main.beans;

import java.io.Serializable;
import java.sql.Date;

public class Equipment implements Serializable {

    private String eqp_id;
    private String eqpname;
    private String eqpdetails;
    private double eqpcost;
    private int quantity;
    private String eqpCategory;
    private Date last_calibration;

    public Equipment(){}

    public Equipment(String eqp_id, String eqpname, String eqpdetails, double eqpcost, int quantity,String eqpCategory, Date date_created) {
        this.eqp_id = eqp_id;
        this.eqpname = eqpname;
        this.eqpdetails = eqpdetails;
        this.eqpcost = eqpcost;
        this.quantity = quantity;
        this.eqpCategory = eqpCategory;
        this.last_calibration = date_created;
    }

    public String getEqp_id() {
        return eqp_id;
    }

    public void setEqp_id(String eqp_id) {
        this.eqp_id = eqp_id;
    }

    public String getEqpname() {
        return eqpname;
    }

    public void setEqpname(String eqpname) {
        this.eqpname = eqpname;
    }

    public String getEqpdetails() {
        return eqpdetails;
    }

    public void setEqpdetails(String eqpdetails) {
        this.eqpdetails = eqpdetails;
    }

    public double getEqpcost() {
        return eqpcost;
    }

    public void setEqpcost(double eqpcost) {
        this.eqpcost = eqpcost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getEqpCategory() {
        return eqpCategory;
    }

    public void setEqpCategory(String eqpCategory) {
        this.eqpCategory = eqpCategory;
    }

    public Date getLast_calibration() {
        return last_calibration;
    }

    public void setLast_calibration(Date date_created) {
        this.last_calibration = date_created;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "eqp_id" + eqp_id + '\'' +
                "eqpname='" + eqpname + '\'' +
                ", eqpdetails='" + eqpdetails + '\'' +
                ", eqpcost=" + eqpcost +
                ", quantity=" + quantity +
                ", date_created='" + last_calibration + '\'' +
                '}';
    }
}
