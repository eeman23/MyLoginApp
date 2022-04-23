package com.example.myloginapp;
public class Tester {
    public static void main(String args[]) {
        TimeFrame one = new TimeFrame(4, 20, 2022, 16, 30);
        TimeFrame two = new TimeFrame(4, 20, 2022, 17, 00);
        TimeFrame three = new TimeFrame(4, 20, 2022, 17, 30);

        TimeWindow window = new TimeWindow(20,4,2022,1);
        System.out.println(window.toString());

    }
 }
