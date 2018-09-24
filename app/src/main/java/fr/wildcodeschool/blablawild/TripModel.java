package fr.wildcodeschool.blablawild;

import java.util.Date;

public class TripModel {

    //attributs
    private String firstname;
    private String lastname;
    private Date date;
    private int price;

    //constructeurs
    public TripModel(String firstname, String lastname, Date date, int price){
        this.firstname = firstname;
        this.lastname = lastname;
        this.date = date;
        this.price = price;
    }

    //getters et setters


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
