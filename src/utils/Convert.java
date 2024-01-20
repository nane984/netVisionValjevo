/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author brasa
 */
public class Convert {

    public static String shiftPoint(int a, int br) {
        try {
            double x = (double) a;
            if (x > 32768) {  // zbog unsigned
                x = 0;
            }

            for (int i = 1; i <= br; i++) {
                x = x * .1;
            }

            DecimalFormat df = new DecimalFormat("#####.####");
            return df.format(x);
        } catch (Exception ex) {
            return "_";
        }
    }
    
    public static String shiftPoint(double a, int br) {
        try {
            double x = a;
            if (x > 32768) {  // zbog unsigned
                x = 0;
            }

            for (int i = 1; i <= br; i++) {
                x = x * .1;
            }

            DecimalFormat df = new DecimalFormat("#####.####");
            return df.format(x);
        } catch (Exception ex) {
            return "_";
        }
    }

    public static double shiftPointDouble(int a, int br) {
        try {
            double x = (double) a;

            if (x > 32768) {  // zbog unsigned
                x = x - 65536;
            }

            for (int i = 1; i <= br; i++) {
                x = x * .1;
            }

            DecimalFormat df = new DecimalFormat("#####.##");
            return Double.parseDouble(df.format(x));
            //return x;
        } catch (Exception ex) {
            return 0;
        }
    }

    public static String doubleToString(double a) {
        double x = (double) a;
        //for (int i = 1; i <= br; i++) {
        //    x = x * .1;
        //}

        DecimalFormat df = new DecimalFormat("#####.####");
        return df.format(x);
    }

    public static int doubleToInt(double a, int br) {
        try {

            for (int i = 1; i <= br; i++) {
                a = a * 10;
            }
            return (int) a;
        } catch (Exception e) {
            return 0;
        }
    }

    public static int objectToInt(Object a, int br) {
        try {
            double x = (double) a;
            if (br > 0) {
                x = Math.round(x * Math.pow(10, br)) / Math.pow(10, br);
                for (int i = 1; i <= br; i++) {
                    x = x * 10;
                }
            }

            return (int) x;
        } catch (Exception e) {
            return 0;
        }
    }

    public static double stringToDouble(String a) {
        try {
            double x = Double.parseDouble(a);
            return x;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Uneli ste slovo.",
                    "Alert", JOptionPane.WARNING_MESSAGE);
            return 0;
        }

    }
    
    public static double stringToDouble(String a, int point) {
        try {
            double x = Double.parseDouble(a);
            for(int i = 0; i<point; i++){
                x = x*10;
            }
            
            return x;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Uneli ste slovo.",
                    "Alert", JOptionPane.WARNING_MESSAGE);
            return 0;
        }

    }

    public static String getTwoRegisterIntShiftPoint(String hight, String low, int point) {
        try {
            long h = Long.parseLong(hight);
            long l = Long.parseLong(low);
            long c = (long) h << 16 | l;
            double x = c;
            String form = "";

            for (int i = 1; i <= point; i++) {
                x = x * .1;
                form = form + "#";
            }
            DecimalFormat df;
            if (point == 0) {
                df = new DecimalFormat("######");
            } else {
                df = new DecimalFormat("######." + form);
            }

            return df.format(x);
        } catch (Exception e) {
            return "0";
        }
    }

    public static double getTwoRegisterIntShiftPointToDouble(int hight, int low, int point) {
        try {
            long h = hight;
            long l = low;
            long c = (long) h << 16 | l;
            double x = c;
            String form = "";

            for (int i = 1; i <= point; i++) {
                x = x * .1;
                form = form + "#";
            }

            return x;
        } catch (Exception e) {
            return 0;
        }
    }
    
     public static int[] convertDoubleToTwoInt(long in) {
        int[] data = new int[2];
        
        data[0] = (int) (in & 0xFFFF);
        data[1] = (int) ((in >> 16) & 0xFFFF);
        
        if (data[0] > 32768) {  // zbog unsigned
                data[0] = data[0] - 65536;
        }
        
        if (data[1] > 32768) {  // zbog unsigned
                data[1] = data[1] - 65536;
        }
       
        return data;
        
     }

    public static String convertDateToString(Date date) {
        String dateStr = new String();
        String format = "dd.MM.yyyy  HH:mm:ss";
        DateFormat df = new SimpleDateFormat(format);
        try {
            dateStr = df.format(date);
        } catch (Exception ex) {
            //System.out.println(ex);
        }
        return dateStr;
    }

    public static String convertDateToStringTime(Date date) {
        String dateStr = new String();
        String format = "HH:mm:ss";
        DateFormat df = new SimpleDateFormat(format);
        try {
            dateStr = df.format(date);
        } catch (Exception ex) {
            //System.out.println(ex);
        }
        return dateStr;
    }

    public static String convertDateToStringDate(Date date) {
        String dateStr = new String();
        String format = "dd.MM.yyyy";
        DateFormat df = new SimpleDateFormat(format);
        try {
            dateStr = df.format(date);
        } catch (Exception ex) {
            //System.out.println(ex);
        }
        return dateStr;
    }

    public static Date convertStringToDate(String dateStr) {
        Date date = null;
        DateFormat df = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        if (dateStr.length() > 7) {

            String[] datum = dateStr.split("\\.");

            String day = datum[0];
            String month = datum[1];
            String year = datum[2];

            try {
                date = df.parse(year + "-" + month + "-" + day + " 00" + ":" + "00" + ":" + "00");
                //System.out.println("Datum je " + convertDateToString(date));
            } catch (Exception ex) {
                System.out.println(ex);
            }
        } else {
            try {
                //date=df.parse("2001-01-01");
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        return date;
    }

    public static Date convertStringToDate(String dateStr, String vreme) {
        Date date = null;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //System.out.println("Vreme je " + vreme);
        if (dateStr.length() > 7) {

            String[] datum = dateStr.split("\\.");

            String day = datum[0];
            String month = datum[1];
            String year = datum[2];

            String[] time = vreme.split("\\:");

            String hour = time[0];
            String min = time[1];

            try {
                date = df.parse(year + "-" + month + "-" + day + " " + hour + ":" + min + ":" + "59");
                //System.out.println("Datum je " + convertDateToString(date));
            } catch (Exception ex) {
                System.out.println(ex);
            }
        } else {
            try {
                //date=df.parse("2001-01-01");
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        return date;
    }

    public static double round2Decimal(double br) {
        try {
            double val = br;
            val = val * 100;
            val = Math.round(val);
            val = val / 100;
            return val;
        } catch (Exception e) {
            return 1;
        }
    }
    
    

    public static double cutDecimal(double br) {
        try {
            double d = br;
            DecimalFormat df = new DecimalFormat("####");
            df.setRoundingMode(RoundingMode.DOWN);
            double outputNum = Double.valueOf(df.format(d));
            return outputNum;
        } catch (Exception e) {
            return 0;
        }
    }

    public static String format2decimals(double value) {
        try{
        DecimalFormat df = new DecimalFormat("#####.##");

        return df.format(value);
        }catch(Exception e){
            return "0";
        }

    }

    public static String nextValueValid(double oldValue, double newValue) {
        DecimalFormat df = new DecimalFormat("#####.##");

        if (newValue > oldValue) {
            return df.format(newValue);
        } else {
            return df.format(oldValue);
        }

    }
    
    public static String getRounFloat(float db, int Format){
        BigDecimal bd = new BigDecimal(Float.toString(db));
        bd = bd.setScale(Format, RoundingMode.HALF_UP);
        return bd.toString();
    }
    
    public static String getRoundDouble(double db, int Format){
        BigDecimal bd = new BigDecimal(Double.toString(db));
        bd = bd.setScale(Format, RoundingMode.HALF_UP);
        return bd.toString();
    }
    
    public static int[] convertLongInTwoIntOnlyPositiv(double br1, String zalihe, int brDec){
        int[] result;
        if((br1 - Convert.stringToDouble(zalihe,brDec))>0){
            result = convertDoubleToTwoInt((long) ((long) br1 - Convert.stringToDouble(zalihe,brDec)));
        }else{
            result = new int[2];
            result[0]= doubleToInt(br1,0);
        }
       return result;
    }
}
