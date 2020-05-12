package com.cofire.basic.dataType.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

public class PrintDateAndWeekDay {

    public static final String[] weekArr = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };

    public static void printDate(Calendar begin, Calendar end) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String flag = "0";
        while (begin.compareTo(end) < 0) {
            if (begin.get(begin.DAY_OF_WEEK) == 1 || begin.get(begin.DAY_OF_WEEK) == 7) {
                flag = "0";
            } else {
                flag = "1";
            }
            System.out.println(
                    "'" + getUUID32() + "','BKL','" + sdf.format(begin.getTime()) + "','" + flag + "','" + weekArr[begin.get(begin.DAY_OF_WEEK) - 1] + "'");
            begin.add(Calendar.DAY_OF_MONTH, 1);
        }
    }

    public static String getUUID32() {
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        return uuid;
    }

    public static void main(String[] args) {
        Calendar begin = Calendar.getInstance();
        begin.set(2019, 0, 1);
        Calendar end = Calendar.getInstance();
        end.set(2019, 11, 31);
        printDate(begin, end);
    }
}
