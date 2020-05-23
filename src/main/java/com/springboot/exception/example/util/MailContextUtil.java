package com.springboot.exception.example.util;


import org.springframework.context.i18n.LocaleContextHolder;
import org.thymeleaf.context.AbstractContext;

import java.util.Map;

public class MailContextUtil extends AbstractContext {

    public MailContextUtil(Map<String, Object> data ){

        super(LocaleContextHolder.getLocale(),data);
    }

    /**
     * Converts data to thymeleaf context
     * @param data
     * @return
     */
    public static MailContextUtil toThymeLeafContext(Map<String, Object> data){
        data.put("dateTimeUtils",new ThymeLeafUtils());
        return new MailContextUtil(data);
    }






}
