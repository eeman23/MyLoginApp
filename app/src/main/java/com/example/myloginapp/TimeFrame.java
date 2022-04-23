package com.example.myloginapp;

public class TimeFrame {
    //data
    private int month;
    private int day;
    private int year;
    private int hour;
    private int minute;
    private static int duration = 30;
    private boolean available;

    //constructor
    //multiple constructors
    public TimeFrame(int m, int da, int y, int h, int min){
        month = m;
        day = da;
        year= y;
        hour = h;
        minute = min;
        available = false;
    }

    //methods

    //make getters for each data
    public int getMonth(){
        return month;
    }
    public int getDay(){
        return day;
    }
    public int getHour(){
        return hour;
    }
    public int getYear(){
        return year;
    }
    public int getMinute(){
        return minute;
    }

    public boolean getAvailable(){
        return available;
    }

    public void setAvailable(){
        available = true;
    }



}

