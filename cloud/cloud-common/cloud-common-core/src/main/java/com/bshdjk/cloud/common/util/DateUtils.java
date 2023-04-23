/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.bshdjk.cloud.common.util;

import com.bshdjk.cloud.common.exception.BshCloudException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Slf4j
public class DateUtils {

    public static final String COMMON_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_DATE_YMD = "yyyy-MM-dd";
    public static final String DATE_FORMAT_YMDHM = "yyyy-MM-dd HH:mm";
    public static final String DATE_FORMAT_YMDHMS = "yyyyMMddhhmmss";
    public static final String DATE_FORMAT_YMDHMS_PARRTERN = "yyyy.MM.dd HH:mm:ss";
    public static final String DATE_FORMAT_Y = "yyyy";

    private DateUtils() {
    }

    /**
     * 获取每个月的第一天
     *
     * @param date
     * @return
     */
    public static String getFirstDay(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date firstDayOfMonth = calendar.getTime();
        return simpleDateFormat.format(firstDayOfMonth);
    }

    /**
     * 获取每个月的最后一天
     *
     * @param date
     * @return
     */
    public static String getLastDate(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, 1);//加一个月
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date lastDayOfMonth = calendar.getTime();
        return simpleDateFormat.format(lastDayOfMonth);
    }

    /**
     * 获取当天
     *
     * @param date
     * @return
     */
    public static String getNow(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(date);
    }

    /**
     * 获取日期，格式为yyyy-MM-dd HH:mm:ss
     *
     * @param d
     * @return String
     */
    public static String getYMDHMSDateYmd(Date d) {
        if (null == d) {
            return StringUtils.EMPTY;
        }
        try {
            SimpleDateFormat destsmf = new SimpleDateFormat(COMMON_PATTERN);
            return destsmf.format(d);
        } catch (Exception e) {
            return StringUtils.EMPTY;
        }
    }

    /**
     * 获取每周的第一天
     *
     * @param date
     * @return
     */
    public static String getFirstOfWeek(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_WEEK, 2);
        Date firstDayOfMonth = calendar.getTime();
        return simpleDateFormat.format(firstDayOfMonth);
    }

    /**
     * 获取每周的最后一天
     *
     * @param date
     * @return
     */
    public static String getLastOfWeek(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_WEEK, 2);
        calendar.add(Calendar.WEEK_OF_MONTH, 1);//加一周
        calendar.add(Calendar.DAY_OF_WEEK, -1);//在当前时间上减去天数
        Date firstDayOfMonth = calendar.getTime();
        return simpleDateFormat.format(firstDayOfMonth);
    }

    public static String before7Days(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -6);//在当前时间上减去天数
        Date before7Days = calendar.getTime();
        return simpleDateFormat.format(before7Days);
    }

    public static String before30Days(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -29);//在当前时间上减去天数
        Date before7Days = calendar.getTime();
        return simpleDateFormat.format(before7Days);
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse("2020-01-02");
        System.out.println(before7Days(date));
    }

    /**
     * 将long类型的timestamp转为LocalDateTime
     *
     * @param timestamp
     * @return
     */
    public static LocalDateTime getDateTimeOfTimestamp(long timestamp) {
        Instant instant = Instant.ofEpochMilli(timestamp);
        ZoneId zone = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zone);
    }

    /**
     * 将LocalDateTime转为long类型的timestamp
     *
     * @param localDateTime
     * @return
     */
    public static long getTimestampOfDateTime(LocalDateTime localDateTime) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        return instant.toEpochMilli();
    }

    /**
     * 获取两个日期间隔的天数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int getDayBetween(Date date1, Date date2) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date sdate = sdf.parse(sdf.format(date1));
            Date edate = sdf.parse(sdf.format(date2));
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdate);
            long time1 = cal.getTimeInMillis();
            cal.setTime(edate);
            long time2 = cal.getTimeInMillis();
            return Integer.parseInt((time2 - time1) / (1000 * 3600 * 24) + "");
        } catch (Exception e) {
            log.error("获取两个日期间隔的天数异常", e);
            return 0;
        }
    }

    /**
     * 将localDateTime转换为Date
     *
     * @param localDateTime
     * @return
     */
    public static Date asDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static String getStringOfLocalDateTime(LocalDateTime localDateTime) {
        if (null == localDateTime) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(COMMON_PATTERN);
        return formatter.format(localDateTime);
    }

    /**
     * 月一号的时间 时间为00:00:00
     *
     * @return
     */
    public static Long monthFirstTime(Date date) {
        if (date == null) {
            date = new Date();
        }
        Calendar calendar = getCalendarMonthDay(date, 0);

        return calendar.getTimeInMillis();
    }

    /**
     * 月末的时间 时间为23:59:59 999
     *
     * @return
     */
    public static Long monthEndTime(Date date) {
        if (date == null) {
            date = new Date();
        }
        Calendar calendar = getCalendarMonthDay(date, 1);
        calendar.add(Calendar.SECOND, -1);
        return calendar.getTimeInMillis();
    }

    /**
     * 取monthNum个月的月初时间 时间为00:00:00
     *
     * @param date
     * @param monthNum
     * @return
     */
    private static Calendar getCalendarMonthDay(Date date, int monthNum) {
        if (date == null) {
            throw new NullPointerException();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, monthNum);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        return calendar;
    }

    /**
     * 获取当前日期
     *
     * @return
     */
    public static String getFormatDate() {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        return sf.format(new Date());
    }

    /**
     * 获取unix时间戳
     *
     * @return
     */
    public static String getUnixTimestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }


    /**
     * 将String类型的时间转换为LocalDate
     *
     * @param time
     * @return
     */
    public static LocalDate getLocalDate(String time) {
        if (null == time) {
            return null;
        }
        return LocalDate.parse(time, DateTimeFormatter.ofPattern(FORMAT_DATE_YMD));
    }

    /**
     * 将String类型转换为LocalDateTime
     *
     * @param time
     * @return
     */
    public static LocalDateTime getLocalDateTime(String time) {
        if (StringUtils.isBlank(time)) {
            return null;
        }
        try {
            LocalDateTime dateTime = LocalDateTime.parse(time, DateTimeFormatter.ofPattern(COMMON_PATTERN));
            return dateTime;
        } catch (Exception e) {
            throw new BshCloudException("日期格式错误");
        }
    }

    /**
     * 将String类型转换为LocalDateTime
     *
     * @param time
     * @return
     */
    public static LocalDateTime getSSSLocalDateTime(String time) {
        if (StringUtils.isBlank(time)) {
            return null;
        }
        try {
            LocalDateTime dateTime = LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
            return dateTime;
        } catch (Exception e) {
            throw new BshCloudException("日期格式错误");
        }
    }

    /**
     * LocalDateTime转换为String类型
     *
     * @param time
     * @return
     */
    public static String getLocalDateToString(LocalDateTime time) {
        if (null == time) {
            return null;
        }
        DateTimeFormatter df = DateTimeFormatter.ofPattern(FORMAT_DATE_YMD);
        return df.format(time);
    }

    /**
     * 数据库查询出来的统计数据有时候日期是不连续的.
     * 但是前端展示要补全缺失的日期.
     * 此方法返回一个给定日期期间的所有日期字符串列表.
     * 具体在业务逻辑中去判断补全.
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return
     */
    public static List<String> completionDate(LocalDateTime startDate, LocalDateTime endDate) {
        if (null == startDate || null == endDate) {
            log.info("获取两日期之间的间隔日期,起始日期与结束日期不允许为空!");
            return null;
        }
        //日期格式化
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DateUtils.FORMAT_DATE_YMD);
        List<String> dateList = new ArrayList<>();
        //遍历给定的日期期间的每一天
        for (int i = 0; !Duration.between(startDate.plusDays(i), endDate).isNegative(); i++) {
            //添加日期
            dateList.add(startDate.plusDays(i).format(formatter));
        }
        return dateList;
    }

    /**
     * 将String类型转换为LocalDateTime
     *
     * @param time
     * @return
     */
    public static LocalDateTime getLocalDateTimeFromYMD(String time) {
        if (StringUtils.isBlank(time)) {
            return null;
        }
        try {
            LocalDate localDate = LocalDate.parse(time, DateTimeFormatter.ofPattern(FORMAT_DATE_YMD));
            return localDate.atStartOfDay();
        } catch (Exception e) {
            throw new BshCloudException("日期格式错误");
        }
    }

    /**
     * 用yyyy-MM-dd 来格式化日期
     *
     * @param d
     * @return String
     * @author qinying
     */
    public static String getDateString(Date d, String template) {
        try {
            SimpleDateFormat destsmf = new SimpleDateFormat(template);
            return destsmf.format(d);
        } catch (Exception e) {
            log.error("格式化日期出错", e);
        }
        return StringUtils.EMPTY;
    }

    /**
     * Date类型转LocalDate类型
     *
     * @param date
     * @return
     */
    public static LocalDate dateToLocalDate(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDate localPriceDate = instant.atZone(zoneId).toLocalDate();
        return localPriceDate;
    }

    /**
     * 获取一段时间内有多少个星期几
     *
     * @param from    开始日期
     * @param to      结束日期
     * @param weekDay 星期几(Calendar.SUNDAY)
     * @return
     */
    public static int getWeekDayCount(String from, String to, int weekDay) {
        Calendar calendar = Calendar.getInstance();
        String[] array = { from, to };
        Date[] ds = new Date[array.length];
        for (int i = 0; i < array.length; i++) {
            String[] fs = array[i].split("[^\\d]+");
            calendar.set(Integer.parseInt(fs[0]), Integer.parseInt(fs[1]) - 1, Integer.parseInt(fs[2]));
            ds[i] = calendar.getTime();
        }
        int count = 0;
        for (Date x = ds[0]; x.compareTo(ds[1]) <= 0; ) {
            calendar.setTime(x);

            if (calendar.get(Calendar.DAY_OF_WEEK) == weekDay) {
                System.out.println(x);
                count++;
            }
            calendar.add(Calendar.DATE, 1);
            x = calendar.getTime();
        }
        return count;
    }

    /**
     * 时间类型转换
     *
     * @param time
     * @param format
     * @return
     */
    public static Date parseDateByFormat(String time, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        try {
            return simpleDateFormat.parse(time);
        } catch (ParseException e) {
            log.error("格式化日期出错", e);
        }
        return null;
    }

    /**
     * 判断该日期是否在两个日期内
     *
     * @param date
     * @param start
     * @param end
     * @return
     */
    public static boolean isBetween(Date date, Date start, Date end) {
        boolean isBetween = date.compareTo(start) >= 0 && date.getTime() <= (end.getTime() + 999);
        return isBetween;
    }

    public static Date add(Date date, int calendarField, int amount) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(calendarField, amount);
        return c.getTime();
    }

    /**
     * 获取日期，格式为yyyy-MM-dd
     *
     * @param d
     * @return String
     */
    public static String getDateYmd(Date d) {
        if (null == d) {
            return StringUtils.EMPTY;
        }
        try {
            SimpleDateFormat destsmf = new SimpleDateFormat(FORMAT_DATE_YMD);
            return destsmf.format(d);
        } catch (Exception e) {
            log.error("格式化日期出错，date=" + d, e);
            return StringUtils.EMPTY;
        }
    }

    /**
     * 获取日期 格式为yyyy-MM-dd ，并转换为日期格式
     * @param dateTime
     * @return
     */
    public static LocalDateTime getLocalDateTimeYmd(LocalDateTime dateTime) {
        return DateUtils.getLocalDateTime(DateUtils.getLocalDateToString(dateTime));
    }


    /**
     * LocalDateTime转换为String类型
     *
     * @param time
     * @return
     */
    public static String getLocalDateToStringYMDHM(LocalDateTime time) {
        if (null == time) {
            return null;
        }
        DateTimeFormatter df = DateTimeFormatter.ofPattern(COMMON_PATTERN);
        return df.format(time);
    }

    /**
     * LocalDateTime转换为String类型
     *
     * @param time
     * @return
     */
    public static String getLocalDateToStringYMDHM(LocalDateTime time, String parrtern) {
        if (null == time || StringUtils.isBlank(parrtern)) {
            return null;
        }
        DateTimeFormatter df = DateTimeFormatter.ofPattern(parrtern);
        return df.format(time);
    }


}
