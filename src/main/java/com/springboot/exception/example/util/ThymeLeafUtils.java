package com.springboot.exception.example.util;

import com.springboot.exception.example.constant.CommonConstant;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utilities to be used in thymeleaf context
 */
public class ThymeLeafUtils {

    public int getStudentAge(Date date)
    {
       return DateTimeUtils.getDiffYears(date, new Date());
    }




}


