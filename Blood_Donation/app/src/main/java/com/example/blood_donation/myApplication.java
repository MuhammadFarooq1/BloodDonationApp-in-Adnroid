package com.example.blood_donation;

import android.app.Application;

import java.util.ArrayList;

public class myApplication  extends Application {
  public  static ArrayList<Person> people;
    @Override
    public void onCreate() {
        super.onCreate();
        people = new ArrayList<>();
        people.add(new Person("Farooq","o+","03008826610","joher town"));
        people.add(new Person("Adnan","b+","03008887166","town"));
        people.add(new Person("Uzair","o-", "03008826654","joher"));
        people.add(new Person("Ali","b-",  "03008824545","lahore"));


    }
}
