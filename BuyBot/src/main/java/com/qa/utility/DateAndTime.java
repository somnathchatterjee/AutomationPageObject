package com.qa.utility;

import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateAndTime {

    public static String dateonly(){
        Date today = new Date();
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
        String date = DATE_FORMAT.format(today);
        return date;
    }

    public static String dateAndTime(){
        Date today = new Date();
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datetime = DATE_FORMAT.format(today);
        System.out.println(datetime);
        return datetime;
    }

    public static String dateAndTime(int increaseMin){
        Date dNow = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(dNow);
        cal.add(Calendar.MINUTE, increaseMin);
        dNow = cal.getTime();
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datetime = DATE_FORMAT.format(dNow);
        return datetime;
    }

    public static String dateAndTimeMonth(int increaseMon){
        Date dNow = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(dNow);
       // cal.add(Calendar.MINUTE, increaseMin);
        cal.add(Calendar.MONTH,increaseMon);
        dNow = cal.getTime();
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datetime = DATE_FORMAT.format(dNow);
        return datetime;
    }
}
