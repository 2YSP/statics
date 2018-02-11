package cn.sp.jdk_8;

import java.time.*;
import java.time.temporal.ChronoField;

/**
 * @Author: 2YSP
 * @Description: 日期API
 * @Date: Created in 2018/2/11
 */
public class TimeTest {

    public static void main(String[] args) {
//        test1();
        test2();
    }

    /**
     * 创建一个LocalDate对象并读取其值
     */
    public static void  test1(){
        LocalDate date = LocalDate.of(2014, 3, 18);
        int year = date.getYear();
        System.out.println("年份:"+year);
        Month month = date.getMonth();
        System.out.println("月份："+month);
        int day = date.getDayOfMonth();
        System.out.println("该月"+day+"号");
        DayOfWeek dow = date.getDayOfWeek();
        System.out.println("周几?"+dow.toString());
        int len = date.lengthOfMonth();
        System.out.println("该月有多少天?"+len);
        boolean leap = date.isLeapYear();
        System.out.println("该年是否为闰年："+leap);
        //获取当前时间
        LocalDate now = LocalDate.now();
        int y = now.get(ChronoField.YEAR);
        int m = now.get(ChronoField.MONTH_OF_YEAR);
        int d = now.get(ChronoField.DAY_OF_MONTH);
        System.out.println("现在是"+y+"年"+m+"月"+d+"号");
    }

    public static void  test2(){
        LocalTime time = LocalTime.of(14, 9, 51);
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();
        //通过解析字符串
        LocalTime time2 = LocalTime.parse("14:09:51");
        LocalDate date = LocalDate.parse("2018-02-11");
        System.out.println(date);
        System.out.println(time2);
        
        //合并日期和时间
        LocalDateTime dt1 = LocalDateTime.of(date, time);
        LocalDateTime dt2 = LocalDateTime.of(2018, Month.FEBRUARY, 11, 14, 9, 51);
        LocalDateTime dt3 = date.atTime(time);
        LocalDateTime dt4 = date.atTime(14, 9, 51);
        LocalDateTime dt5 = time.atDate(date);
        System.out.println(dt1.equals(dt2));
    }
}
