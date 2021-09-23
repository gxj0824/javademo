package com.tqym.basicdemo.demo4_time;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName TimeDemo
 * @Description 测试时间日期相关的类
 * @Author 洛城天使
 * @Date: 2021/9/23 22:01
 * @Version 1.0
 */
public class TimeDemo {

    /**
     * Calendar:Calendar转为Date
     */
    @Test
    private void testCalendar() {
        //Calendar日历类
        Calendar time = Calendar.getInstance();
        System.out.println("当前日历：" + time);
        //Calendar转为Date
        System.out.println("Calendar转为Date：" + time.getTime());
        System.out.println("年" + time.get(Calendar.YEAR));
        //月（西方月份是0~11，所以中国需要＋1）
        System.out.println("月" + (time.get(Calendar.MONTH) + 1));
        System.out.println("天" + time.get(Calendar.DAY_OF_MONTH));
        System.out.println("天" + time.get(Calendar.DATE));
    }

    /**
     * Date:Date与毫秒值相互转换
     */
    @Test
    private void testDate2() {
        //时间原点：1970 1.1 00:00:00（英国格林威治时间）
        //中国属于东八区，时间原点是：1970 1.1 08:00:00
        Date date1 = new Date(0);
        System.out.println("时间原点：" + date1);

        //Date(Long date):传递毫秒值，把毫秒值转换为日期
        //System.currentTimeMillis()：获取当前系统时间距离时间原点的毫秒值
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println("当前时间毫秒值：" + currentTimeMillis);
        Date date2 = new Date(currentTimeMillis);
        System.out.println("当前时间毫秒值转为Date：" + date2);

        //getTime()把日期转换为毫秒值。相当于System.currentTimeMillis()
        long date3Time = date2.getTime();
        System.out.println("Date转为毫秒值：" + date3Time);
    }

    /**
     * Date:Date与String相互转换
     */
    @Test
    private void testDate1() throws ParseException {
        //Date()获取当前系统的日期和时间
        Date date = new Date();
        System.out.println("当前系统的日期和时间:" + date);
        //将Date转为指定格式的String
        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String currentTime = sdf.format(date);
        System.out.println("Date转为指定格式的String:" + currentTime);
        //将指定格式的String转为Date
        Date parse = sdf.parse(currentTime);
        System.out.println("将指定格式的String转为Date" + parse);
    }

    /**
     * LocalDate
     */
    @Test
    private void testLocalDate() {
        LocalDate now = LocalDate.now();//获取当前时间2021-09-23
        System.out.println(now);
        System.out.print(now.getYear() + "-");//年
        System.out.print(now.getMonthValue() + "-");//月
        System.out.println(now.getDayOfMonth());//日
        //增加两个月
        LocalDate localDate = now.plusMonths(2);
        System.out.println(localDate);
    }
}
