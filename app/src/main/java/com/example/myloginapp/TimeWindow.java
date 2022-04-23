package com.example.myloginapp;
import java.util.ArrayList;

public class TimeWindow{
    //data
    private ArrayList<TimeFrame> window;
    private int bDay;
    private int bMonth;
    private int bYear;
    private int duration;
    private int minute;
    private int hour;
    
    //constructor
    public TimeWindow(int bDay, int bMonth, int bYear, int duration){
        window = new ArrayList<>();
        this.bDay = bDay;
        this.bYear = bYear;
        this.bMonth = bMonth;
        //duration is in term of dates
        this.duration = duration;
        minute = 0;
        hour = 0;
    }
    
    
    //method
    public void createWindow (){
        //hour is in military time
        for (int i = 0; i <= duration * 48; i++) {
        	TimeFrame object = new TimeFrame(bMonth, bDay, bYear, hour, minute);
            window.add(object);
            minute += 30;       
            Check();
        }
    }
    public String toString() {
        String x = "";
        createWindow();
        for (TimeFrame f: window){
            x = x + f.toString();
        }
        return x;
    }
    
    public void Check() {
    	
    	 if (minute == 60) {
             hour++;
             minute = 0;
         }

         if (hour == 24) {
             bDay += 1;
             hour = 0;
         }
         //make methods to handle the changing of the month (february)
         //assuming each month has 30 days
         if (bDay == 31) {
             bMonth++;
             bDay = 1;
         }

         if (bMonth == 13) {
             bYear++;
             bMonth = 1;
         }
    }
}
