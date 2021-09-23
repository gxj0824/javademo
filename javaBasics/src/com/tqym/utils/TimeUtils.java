package com.tqym.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @ClassName TimeUtils
 * @Description 操作时间的工具类
 * @Author 洛城天使
 * @Date: 2021/9/23 22:39
 * @Version 1.0
 */
public class TimeUtils {


    /**
     * 取得当前时间的时间戳（精确到毫秒）
     *
     * @return long
     */
    public static long timeStamp() {
        return System.currentTimeMillis();
    }

    /**
     * 获取昨天这个时间的时间戳(精确到毫秒)
     *
     * @return long
     */
    public static long getYesterdayTimeStamp() {
        //当前时间日历
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        return calendar.getTime().getTime();
    }

    /**
     * 计算今天0点的时间戳(精确到毫秒)
     *
     * @return long
     */
    public static long getToday0TimeStamp() {
        //当前时间的时间戳j
        long time = timeStamp();
        long zero = time / (1000 * 3600 * 24) * (1000 * 3600 * 24) - TimeZone.getDefault().getRawOffset();
        Timestamp timestamp = new Timestamp(zero);
        //今天零点零分零秒
        return timestamp.getTime();
    }

    /**
     * 计算今天23点59分59秒的时间戳(精确到毫秒)
     *
     * @return long
     */
    public static long getToday24TimeStamp() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
        return calendar.getTime().getTime();
    }


    /**
     * 计算昨天0点的时间戳(精确到毫秒)
     *
     * @return long
     */
    public static long getYesterday0TimeStamp() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH) - 1, 0, 0, 0);
        return calendar.getTime().getTime();
    }

    /**
     * 计算昨天23:59:59 秒的时间戳(精确到毫秒)
     *
     * @return long
     */
    public static long getYesterday24TimeStamp() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH) - 1, 23, 59, 59);
        return calendar.getTime().getTime();
    }


    /**
     * 时间戳转换成日期格式字符串
     *
     * @param seconds 精确到毫秒的字符串
     * @param format  日期格式字符串
     * @return 日期字符串
     */
    public static String timeStamp2Date(String seconds, String format) {
        if (seconds == null || seconds.length() == 0) {
            return "";
        }
        if (format == null || format.isEmpty()) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(Long.parseLong(seconds)));
    }

    /**
     * 日期格式字符串 转换成 精确到毫秒的时间戳
     *
     * @param date_str 字符串日期
     * @param format   如：yyyy-MM-dd HH:mm:ss
     * @return 时间戳
     */
    public static String date2TimeStamp(String date_str, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return String.valueOf(sdf.parse(date_str).getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


}
