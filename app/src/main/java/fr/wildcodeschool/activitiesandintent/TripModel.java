package fr.wildcodeschool.activitiesandintent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Date;


public class TripModel extends AppCompatActivity {

    private String firstName;
    private String lastName;
    private Date date;
    private int prix;

    public TripModel(String firstName, String lastName, Date date,int prix){

        this.firstName = firstName;
        this.lastName = lastName;
        this.date = date;
        this.prix = prix;
    }

    public void setFirstName(String firstName){

        this.firstName = firstName;
    }

    public String getFirstName(){

        return this.firstName;
    }

    public void setLastName(String lastName){

        this.lastName = lastName;
    }

    public String getLastName(){

        return this.lastName;
    }

    public void setDate(Date date){

        this.date = date;
    }

    public Date getDate(){

        return this.date;
    }

    public void setPrix(int prix){

        this.prix = prix;
    }

    public int getPrix(){

        return this.prix;
    }


}
