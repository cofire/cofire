package com.cofire.utils.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtilsC {

    private static final String DATE_PATTERN = "yyyy-MM-dd";
    private static final String DATE_NUMBER_PATTERN = "yyyyMMdd";
    private static final String DATE_TIME = "HHmmss";
    private static final String TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static final String TIME_PATTERN2 = "yyyyMMddHHmmss";
    private static final String TIME_PATTERN3 = "yyyy-MM-dd HHmmss";
    private static final String TIME_PATTERN4 = "HH:mm:ss";
    private static final String DATE_NUMBER = "yyyyMM";
    private static final String TIME_PATTERN5 = "yyyyMMddHHmmss";
    private static final String DATE_NUMBER_PATTERN1 = "yyyy/MM/dd";

    /**
     * 由日期返回yyyy-MM-dd格式的字符串
     * 
     * @param date
     * @return
     */
    public static String dateToString(Date date) {
        if (date == null)
            return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtilsC.DATE_PATTERN);
        return simpleDateFormat.format(date);
    }

    /**
     * 由日期返回HHmmss格式的字符串
     * 
     * @param date
     * @return
     */
    public static String dateToTime(Date date) {
        if (date == null)
            return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtilsC.DATE_TIME);
        return simpleDateFormat.format(date);
    }

    /**
     * 由日期返回yyyyMMdd格式的字符串
     * 
     * @param date
     * @return
     */
    public static String dateToNumber(Date date) {
        if (date == null)
            return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtilsC.DATE_NUMBER_PATTERN);
        return simpleDateFormat.format(date);
    }

    /**
     * 由日期返回yyyy/MM/dd格式的字符串
     * 
     * @param date
     * @return
     */
    public static String dateToNumber1(Date date) {
        if (date == null)
            return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtilsC.DATE_NUMBER_PATTERN1);
        return simpleDateFormat.format(date);
    }

    /**
     * 由日期返回yyyyMMdd格式的字符串
     * 
     * @param date
     * @return
     */
    public static String dateToNumber3(Date date) {
        if (date == null)
            return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtilsC.TIME_PATTERN2);
        return simpleDateFormat.format(date);
    }

    public static String dateToNumber5(Date date) {
        if (date == null)
            return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtilsC.TIME_PATTERN5);
        return simpleDateFormat.format(date);
    }

    /**
     * 由日期返回 dd 格式的字符串
     * 
     * @param date
     * @return
     */
    public static String getDay(Date date) {
        if (date == null)
            return null;
        return DateUtilsC.dateToNumber(date).substring(6, 8);
    }

    /**
     * 由日期返回 mm 格式的字符串
     * 
     * @param date
     * @return
     */
    public static String getMonth(Date date) {
        if (date == null)
            return null;
        return DateUtilsC.dateToNumber(date).substring(4, 6);
    }

    /**
     * 由日期返回 yyyy 格式的字符串
     * 
     * @param date
     * @return
     */
    public static String getYear(Date date) {
        if (date == null)
            return null;
        return DateUtilsC.dateToNumber(date).substring(0, 4);
    }

    /**
     * 由日期返回yyyy-MM-dd HH:mm:ss格式的字符串
     * 
     * @param time
     * @return
     */
    public static String timeToString(Date time) {
        if (time == null)
            return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtilsC.TIME_PATTERN);
        return simpleDateFormat.format(time);
    }

    /**
     * 由日期返回yyyyMMddHHmmss格式的字符串
     * 
     * @param time
     * @return
     */
    public static String timeToNumber(Date time) {
        if (time == null)
            return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return simpleDateFormat.format(time);
    }

    /**
     * 由日期返回yyyy-MM-dd-HH.mm.ss.SSSSSS格式的字符串
     * 
     * @param date Date格式日期
     * @return String yyyy-MM-dd-HH.mm.ss.SSSSSS格式 的字符串
     */
    public static String getTimeStampFormat(Date date) {
        if (date == null)
            return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss.SSSSSS");
        return simpleDateFormat.format(date);
    }

    /**
     * 由yyyy-MM-dd HH:mm:ss格式的字符串返回日期时间
     * 
     * @param String 时间
     * @return
     */
    public static Date stringToTime(String string) {
        if (string == null)
            return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtilsC.TIME_PATTERN);

        try {
            return simpleDateFormat.parse(string);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }

        return null;
    }

    /**
     * 由yyyy-MM-dd格式的字符串返回日期
     * 
     * @param date
     * @return
     */
    public static Date stringToDate(String string) {
        if (string == null)
            return null;
        if (string.trim().length() == 0)
            return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtilsC.DATE_PATTERN);

        try {
            return simpleDateFormat.parse(string);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 由yyyy-MM-dd HHmmss格式的字符串返回日期
     * 
     * @param date
     * @return
     */
    public static Date stringToDate2(String string) {
        if (string == null)
            return null;
        if (string.trim().length() == 0)
            return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtilsC.TIME_PATTERN3);

        try {
            return simpleDateFormat.parse(string);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 由yyyyMMddHHmmss格式的字符串返回日期
     * 
     */
    public static Date stringToDate3(String string) {
        if (string == null)
            return null;
        if (string.trim().length() == 0)
            return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtilsC.TIME_PATTERN2);

        try {
            return simpleDateFormat.parse(string);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 由yyyyMMddHHmmss格式的字符串转化为yyyy-MM-dd HH:mm:ss格式的字符串
     * 
     * @param date
     * @return
     */
    public static String stringToDateString(String string) {
        if (string == null)
            return null;
        String time = "";
        for (int i = 0; i < 14; i++) {
            time += string.substring(i, i + 1);
            if (i == 3 || i == 5) {
                time += "-";
            } else if (i == 7) {
                time += " ";
            } else if (i == 9 || i == 11) {
                time += ":";
            }
        }
        return time;

    }

    /**
     * 由yyyyMMdd格式的字符串返回日期
     * 
     * @param date
     * @return
     */
    public static Date numberToDate(String string) {
        if (string == null)
            return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtilsC.DATE_NUMBER_PATTERN);

        try {
            return simpleDateFormat.parse(string);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 将"yyyy-mm-dd"格式的日期字符串转换成"yyyymmdd"的格式
     * 
     * @param date 日期
     * @return "yyyymmdd"的日期字符串
     */
    public static String dateStringToNumber(String date) {
        if (date == null) {
            return null;
        }
        return date.replaceAll("-", "");
    }

    /**
     * 将"yyyymmdd"格式的日期字符串转换成"yyyy-mm-dd"的格式
     * 
     * @param date 日期
     * @return "yyyy-mm-dd"的日期字符串
     */
    public static String numberToDateString(String date) {
        if (date == null || date.trim().length() != 8)
            return "";
        else
            return date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + date.substring(6, 8);
    }

    /**
     * 将"yyyymmddhhmmss"格式的日期字符串转换成"yyyy-mm-dd hh:mm:ss"的格式
     * 
     * @param date 日期
     * @return "yyyy-mm-dd hh:mm:ss"的日期字符串
     */
    public static String numberToTimeString(String time) {
        if (time == null || time.trim().length() != 14)
            return "";
        else
            return time.substring(0, 4) + "-" + time.substring(4, 6) + "-" + time.substring(6, 8) + " " + time.substring(8, 10) + ":" + time.substring(10, 12)
                    + ":" + time.substring(12, 14);
    }

    /**
     * 将"hhmmss"格式的日期字符串转换成"hh:mm:ss"的格式 Added by cx 08-09-28
     * 
     * @param time 时间
     * @return "hh:mm:ss"的日期字符串
     */
    public static String numberToTimeString2(String time) {
        if (time == null || time.trim().length() != 6)
            return "";
        else
            return time.substring(0, 2) + ":" + time.substring(2, 4) + ":" + time.substring(4, 6);
    }

    /**
     * 
     * @param date
     * @return
     */
    public static Date numberToTime(String string) {
        if (string == null)
            return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtilsC.TIME_PATTERN4);

        try {
            return simpleDateFormat.parse(string);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 将"yyyy-mm-dd"格式的日期字符串转换成"yyyymm"的格式
     * 
     * @return "yyyymmdd"的日期字符串
     */
    public static String dateStringToNumber6(String date) {
        return date.replaceAll("-", "").substring(0, 6);
    }

    public static String getSpecialNaturalDate(String curDate, Integer DateDays) {
        Date date = numberToDate(curDate);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, DateDays);

        Date returnDate = cal.getTime();

        return dateToNumber(returnDate);
    }

    public static void main(String[] args) {
        System.out.println(getSpecialNaturalDate("20190102", -1));
    }
}
