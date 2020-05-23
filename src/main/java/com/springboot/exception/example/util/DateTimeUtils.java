package com.springboot.exception.example.util;

import com.springboot.exception.example.constant.CommonConstant;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateTimeUtils {


    public static String formatDate(Date date ) {
        DateFormat dateFormat = new SimpleDateFormat(CommonConstant.DATE_FORMAT);
        return dateFormat.format(date);
    }

    public static int getDiffYears(Date first, Date last) {
        Calendar a = getCalendar(first);
        Calendar b = getCalendar(last);
        int diff = b.get(Calendar.YEAR) - a.get(Calendar.YEAR);
        if (a.get(Calendar.MONTH) > b.get(Calendar.MONTH) ||
                (a.get(Calendar.MONTH) == b.get(Calendar.MONTH) && a.get(Calendar.MONTH) > b.get(Calendar.MONTH))) {
            diff--;
        }
        return diff;
    }

    public static Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.setTime(date);
        return cal;
    }
    public static void main(String[] args) {
        try {
            Date  dateOfBirth= new SimpleDateFormat(CommonConstant.DATE_FORMAT).parse("1984-08-14");
            Date presentTime= new Date();
            System.out.println("getPresentYear = " + formatDate(presentTime));
            System.out.println("Date of Birth = " + formatDate(dateOfBirth));
            System.out.println("age Diff " + getDiffYears(dateOfBirth, new Date()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}
