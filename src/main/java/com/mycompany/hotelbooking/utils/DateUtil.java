/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbooking.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class DateUtil {
    public static String convertDateToString(Date value){
        if(value !=null){
            DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.format(value);
        }
        return null;
    }
    
    public static Date convertStringToDate(String value){
        if(value !=null){
            
            try {
                DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
                return dateFormat.parse(value);
                
            } catch (ParseException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return null;
    }
}
