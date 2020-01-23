package com.cn.crm.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    private static Logger logger = LoggerFactory.getLogger(DateUtil.class);

    /**
     * 秒
     */
    public static final long SECOND_MILLI = 1000;

    /**
     * 分
     */
    public static final long MINUTE_MILLI = 60 * 1000;

    /**
     * 时
     */
    public static final long HOUR_MILLI = 60 * 60 * 1000;

    /**
     * 天
     */
    public static final long DAY_MILLI = 24 * 60 * 60 * 1000;

    /**
     * 东八区
     */
    private static final String ZONE_8 = "+8";

    /**
     * 获取当前时间
     * @return  当前时间
     */
    public static LocalDateTime localDateTime(){
        return LocalDateTime.now();
    }

    /**
     * 当前时间 date 类型
     * @return date类型
     */
    public static Date date(){
        return new Date();
    }

    public static Date localDateTime2Date(LocalDateTime localDateTime){
        return Date.from(localDateTime
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }

    public static LocalDateTime date2LocalDateTime(Date date){
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }


    /**
     * 获取当前时间戳
     * @return  时间戳
     */
    public static long timeStamp(){
        return Instant.now().getEpochSecond();
    }


    /**
     * 获取相应时间的时间戳
     * @param localDateTime 时间
     * @return  毫秒级时间戳
     */
    public static long timeStamp(LocalDateTime localDateTime){
        return localDateTime.toInstant(ZoneOffset.of(ZONE_8)).toEpochMilli();
    }

    /**
     * 将String转化成date
     *
     * @throws ParseException
     * */
    public static Date stringToDate(String str, String sfgs)
            throws ParseException {
        SimpleDateFormat sf = new SimpleDateFormat(sfgs);
        return sf.parse(str);
    }


    /**
     * datetime -> String
     * @return
     */
    public static String getDateTimeStr(Date date){
        String dateStr = "";
        if(date != null){
            Format format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            dateStr = format.format(date);
        }
        return dateStr;
    }

    /**
     * 取得两个日期的间隔天数
     * @param one
     * @param two
     * @return
     */
    public static int getDiffDays(Date one, Date two) {
        long from = one.getTime();
        long to = two.getTime();

        //一天等于多少毫秒：24*3600*1000

        int day = (int)((to-from)/(24*60*60*1000));
        return day;
    }


    /**
     * 取得新的日期
     *
     * @param date1
     *            日期
     * @param days
     *            天数
     *
     * @return 新的日期
     */
    public static Date addDays(Date date1, long days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        cal.add(Calendar.DATE, (int) days);
        return cal.getTime();
    }

    /**
     * 比较时间大小
     * @param date1
     * @param date2
     * @return
     */
    public static boolean compareDate(Date date1, Date date2){
        if (date1.getTime() > date2.getTime()) {
            return true;
        }
        return false;
    }

    /**
     *获取选择时间前几天时间
     *  @param days
     */
    public static Date getDaysBefore(int days, Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }


    public static Long strToTimestamp(String str){
        return DateUtil.timeStamp(DateUtil.date2LocalDateTime(DateUtil.strToDate(str)))/1000;
    }

    public static void main(String[] args) {
        System.out.println(monthBeforeStringDate("2018-08-01",-2));
        String str = "2020-01-22 00:00:00";
        System.out.println(DateUtil.strToDate(str));

        System.out.println(DateUtil.timeStamp(DateUtil.date2LocalDateTime(DateUtil.strToDate(str))));
        // System.out.println(getDiffDays(getDaysBefore(-1,new Date()),new Date()));
    }

    /**
     * 字符串转换成日期
     * @param str
     * @return date
     */
    public static Date strToDate(String str) {
        if(StringUtils.isEmpty(str)){
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获取前三个月日期
     * @return
     */
    public static String monthBeforeDate(int month) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, month);    //得到前3个月
        System.out.print(format.format(calendar.getTime()));
        return format.format(calendar.getTime());
    }

    /**
     * 根据指定日期往前获取前几个月
     * @param month
     * @return
     */
    public static String monthBeforeStringDate(String date,int month) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date dateNew = null;
        try {
            dateNew = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateNew);
        calendar.add(Calendar.MONTH, month);    //得到前3个月
        System.out.print(format.format(calendar.getTime()));
        return format.format(calendar.getTime());
    }



    public static String replaceDateRule(String source){
        return source.replace("-","").substring(0,6);

    }
    /**
     * 获得某天最小时间 2017-10-15 00:00:00
     * @param date
     * @return
     */
    public static Date getStartOfDay(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        LocalDateTime startOfDay = localDateTime.with(LocalTime.MIN);
        return Date.from(startOfDay.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获得某天最大时间 2017-10-15 23:59:59
     * @param date
     * @return
     */
    public static Date getEndOfDay(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()),       ZoneId.systemDefault());;
        LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
        return Date.from(endOfDay.atZone(ZoneId.systemDefault()).toInstant());
    }
}
