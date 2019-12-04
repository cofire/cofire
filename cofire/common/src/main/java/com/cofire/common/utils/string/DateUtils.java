package com.cofire.common.utils.string;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public final class DateUtils {

    public DateUtils() {

    }

    public static String dateToString(Date date) {

        if (date == null) {

            return null;
        } else {

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return simpleDateFormat.format(date);
        }
    }

    public static String dateToTime(Date date) {

        if (date == null) {

            return null;
        } else {

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HHmmss");
            return simpleDateFormat.format(date);
        }
    }

    public static String dateToNumber(Date date) {

        if (date == null) {

            return null;
        } else {

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            return simpleDateFormat.format(date);
        }
    }

    public static String getDay(Date date) {

        if (date == null) {
            return null;
        } else {
            return dateToNumber(date).substring(6, 8);
        }
    }

    public static String getMonth(Date date) {

        if (date == null) {
            return null;
        } else {
            return dateToNumber(date).substring(4, 6);
        }
    }

    public static String getYear(Date date) {

        if (date == null) {
            return null;
        } else {
            return dateToNumber(date).substring(0, 4);
        }
    }

    public static String dataTimeToString(Date time) {

        if (time == null) {

            return null;
        } else {

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return simpleDateFormat.format(time);
        }
    }

    public static String dataTimeToNumber(Date time) {

        if (time == null) {

            return null;
        } else {

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            return simpleDateFormat.format(time);
        }
    }

    public static String getTimeStampFormat(Date date) {

        if (date == null) {

            return null;
        } else {

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss.SSSSSS");
            return simpleDateFormat.format(date);
        }
    }

    public static Date stringToFullDateTime(String string) throws ParseException {

        if (string == null) {

            return null;
        } else {

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return simpleDateFormat.parse(string);
        }
    }

    public static Date stringToDate(String string) throws ParseException {

        if (string == null) {
            return null;
        }
        if (string.trim().length() == 0) {

            return null;
        } else {

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return simpleDateFormat.parse(string);
        }
    }

    public static Date stringToDate(String string, String format) throws ParseException {

        if (string == null) {
            return null;
        }
        if (string.trim().length() == 0) {

            return null;
        } else {

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            return simpleDateFormat.parse(string);
        }
    }

    public static Date stringToFullDateTimeWithTimeCompact(String string) throws ParseException {

        if (string == null) {
            return null;
        }
        if (string.trim().length() == 0) {

            return null;
        } else {

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HHmmss");
            return simpleDateFormat.parse(string);
        }
    }

    public static Date stringToFullDateTimeWithCompact(String string) throws ParseException {

        if (string == null) {
            return null;
        }
        if (string.trim().length() == 0) {

            return null;
        } else {

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            return simpleDateFormat.parse(string);
        }
    }

    public static String stringToDateString(String string) {

        if (string == null) {
            return null;
        }
        StringBuilder time = new StringBuilder();
        for (int i = 0; i < 14; i++) {

            time.append(string.substring(i, i + 1));
            if (i == 3 || i == 5) {

                time.append("-");
                continue;
            }
            if (i == 7) {

                time.append(" ");
                continue;
            }
            if (i == 9 || i == 11) {
                time.append(":");
            }
        }

        return time.toString();
    }

    public static Date numberToDate(String string) throws ParseException {

        if (string == null) {

            return null;
        } else {

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            return simpleDateFormat.parse(string);
        }
    }

    public static String dateStringToNumber(String string) {

        return string.replaceAll("-", "");
    }

    public static String numberToDateString(String string) {

        if (string == null || string.trim().length() != 8) {
            return "";
        } else {
            return (new StringBuilder()).append(string.substring(0, 4)).append("-").append(string.substring(4, 6)).append("-").append(string.substring(6, 8))
                    .toString();
        }
    }

    public static String numberToTimeString(String time) {

        if (time == null || time.trim().length() != 14) {
            return "";
        } else {
            return (new StringBuilder()).append(time.substring(0, 4)).append("-").append(time.substring(4, 6)).append("-").append(time.substring(6, 8))
                    .append(" ").append(time.substring(8, 10)).append(":").append(time.substring(10, 12)).append(":").append(time.substring(12, 14)).toString();
        }
    }

    public static String numberToTimeString2(String time) {

        if (time == null || time.trim().length() != 6) {
            return "";
        } else {
            return (new StringBuilder()).append(time.substring(0, 2)).append(":").append(time.substring(2, 4)).append(":").append(time.substring(4, 6))
                    .toString();
        }
    }

    public static Date numberToTime(String string) throws ParseException {

        if (string == null) {

            return null;
        } else {

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
            return simpleDateFormat.parse(string);
        }
    }

    public static String dateStringToNumber6(String date) {

        return date.replaceAll("-", "").substring(0, 6);
    }

    public static long DaysBetween(Date bgdate, Date enddate) {

        long beginTime = bgdate.getTime();
        long endTime = enddate.getTime();
        long days = (long) Math.floor((endTime - beginTime) / 86400000L);
        return days;
    }

    public static int convertDateToDay(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(6);
    }

    public static Date convertDayToDate(int year, int dayInYear) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(1, year);
        calendar.set(6, dayInYear);
        return calendar.getTime();
    }

    public static String getSysTimeString() {

        Date time = new Date();
        return dataTimeToNumber(time);
    }

    public static Date getCalcedDate(int type, int diff) {
        Calendar calendar = Calendar.getInstance();// 得到日历
        Date now = new Date();// 获取当前时间
        calendar.setTime(now);// 把当前时间赋给日历
        if (Calendar.DATE == type) {
            calendar.add(Calendar.DATE, diff); // 设置为前2月
        }
        if (Calendar.MONTH == type) {
            calendar.add(Calendar.MONTH, diff); // 设置为前2月
        }
        if (Calendar.YEAR == type) {
            calendar.add(Calendar.YEAR, diff); // 设置为前2月
        }
        return calendar.getTime();
    }

    public static Date getCalcedDate(Date date, int type, int diff) {
        Calendar calendar = Calendar.getInstance();// 得到日历
        calendar.setTime(date);// 把当前时间赋给日历
        if (Calendar.DATE == type) {
            calendar.add(Calendar.DATE, diff); // 设置为前2月
        }
        if (Calendar.MONTH == type) {
            calendar.add(Calendar.MONTH, diff); // 设置为前2月
        }
        if (Calendar.YEAR == type) {
            calendar.add(Calendar.YEAR, diff); // 设置为前2月
        }
        return calendar.getTime();
    }

    /**
     * 
     * @Title: getDayBegin
     * @author ly
     * @Description:当日开始时间
     * @param @param date
     * @param @return 参数
     * @return Date 返回类型
     */
    public static Date getDayBegin(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 
     * @Title: getDayEnd
     * @author ly
     * @Description:当日结束时间
     * @param @param date
     * @param @return 参数
     * @return Date 返回类型
     */
    public static Date getDayEnd(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    /**
     * 
     * @Title: getWeekBegin
     * @author ly
     * @Description:每周开始时间
     * @param @param date
     * @param @return 参数
     * @return Date 返回类型
     */
    public static Date getWeekBegin(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // 获得当前日期是一个星期的第几天
        int day = cal.get(Calendar.DAY_OF_WEEK);
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        return cal.getTime();
    }

    /**
     * 
     * @Title: getWeekEnd
     * @author ly
     * @Description:每周结束时间
     * @param @param date
     * @param @return 参数
     * @return Date 返回类型
     */
    public static Date getWeekEnd(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // 获得当前日期是一个星期的第几天
        int day = cal.get(Calendar.DAY_OF_WEEK);
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        cal.add(Calendar.DATE, 6);
        return cal.getTime();
    }

    /**
     * 
     * @Title: getMonthBegin
     * @author ly
     * @Description:每月开始时间
     * @param @return 参数
     * @return Date 返回类型
     */
    public static Date getMonthBegin(Date date) {
        Calendar calendar = Calendar.getInstance();// 得到日历
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    /**
     * 
     * @Title: getMonthEnd
     * @author ly
     * @Description:每月结束是时间
     * @param @return 参数
     * @return Date 返回类型
     */
    public static Date getMonthEnd(Date date) {
        Calendar calendar = Calendar.getInstance();// 得到日历
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 0);
        return calendar.getTime();
    }

    /**
     * 
     * @Title: getYearBegin
     * @author ly
     * @Description:当年的开始日期
     * @param @param date
     * @param @return 参数
     * @return Date 返回类型
     */
    public static Date getYearBegin(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MONTH, 1);
        calendar.set(Calendar.DATE, 1);
        return calendar.getTime();
    }

    /**
     * 
     * @Title: getYearEnd
     * @author ly
     * @Description:当年的结束日期
     * @param @param date
     * @param @return 参数
     * @return Date 返回类型
     */
    public static Date getYearEnd(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MONTH, 11);
        calendar.set(Calendar.DATE, 31);
        return calendar.getTime();
    }

    public static int daysBetween(Date beginDate, Date endDate) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            beginDate = sdf.parse(sdf.format(beginDate));
            endDate = sdf.parse(sdf.format(endDate));
            Calendar cal = Calendar.getInstance();
            cal.setTime(beginDate);
            long time1 = cal.getTimeInMillis();
            cal.setTime(endDate);
            long time2 = cal.getTimeInMillis();
            long between_days = (time2 - time1) / (1000 * 3600 * 24);
            return Integer.parseInt(String.valueOf(between_days));
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

    public static List<String> getDiffDays(Date beginDate, Date endDate) {
        List<String> list = new ArrayList<String>();
        if (beginDate == null || endDate == null) {
            return list;
        }
        int cout = daysBetween(beginDate, endDate);
        if (cout < 0) {
            return list;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < cout; i++) {
            list.add(sdf.format(DateUtils.getCalcedDate(beginDate, Calendar.DATE, i)));
        }
        return list;
    }

    public static List<String> getDiffDays(String beginDateStr, String endDateStr, String format) {
        List<String> list = new ArrayList<String>();
        if (StringUtils.isEmpty(beginDateStr) || StringUtils.isEmpty(endDateStr) || StringUtils.isEmpty(format)) {
            return list;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        SimpleDateFormat sdf2 = new SimpleDateFormat(DATE_PATTERN_YYYY_MM_DD);
        try {
            Date beginDate = sdf.parse(beginDateStr);
            Date endDate = sdf.parse(endDateStr);

            int cout = daysBetween(beginDate, endDate);
            if (cout < 0) {
                return list;
            }
            for (int i = 0; i <= cout; i++) {
                list.add(sdf2.format(DateUtils.getCalcedDate(beginDate, Calendar.DATE, i)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static final String DATE_PATTERN_YYYY_MM_DD = "yyyy-MM-dd";
    public static final String DATE_PATTERN_YYYYMMDD = "yyyyMMdd";
    public static final String DATE_PATTERN_YYYYMM = "yyyyMM";
    public static final String DATE_PATTERN_YYYY_MM = "yyyy-MM";
    public static final String TIME_PATTERN_HHMMSS = "HHmmss";
    public static final String TIME_PATTERN_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String TIME_PATTERN_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final String TIME_PATTERN_YYYY_MM_DD_HHMMSS = "yyyy-MM-dd HHmmss";
    public static final String TIME_PATTERN_YYYY_MM_DD_HHMMSSSSSSSS = "yyyy-MM-dd-HH.mm.ss.SSSSSS";
    public static final String TIME_PATTERN_HH_MM_SS = "HH:mm:ss";
    public static final int MILLISECOND_PER_DAY = 86400000;
}