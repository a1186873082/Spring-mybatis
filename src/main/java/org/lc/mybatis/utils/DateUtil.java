package org.lc.mybatis.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by skyliving on 8/16/16.
 */
public class DateUtil {
    private final static Logger logger = LoggerFactory.getLogger(DateUtil.class);

    public static Date getNow() {
        return new Date();
    }

    /**
     * 把字符串表示的日期转换成日期类型
     */
    public static Date stringToDate(String vStr, String vPatten) {
        if (vStr == null || vPatten == null) {
            throw new IllegalArgumentException("The vStr and the vPatten must not be null");
        }

        if (vStr.equals(""))
            return null;
        try {
            SimpleDateFormat df = new SimpleDateFormat(vPatten);
            return df.parse(vStr);
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * 获取指定日期特定小时后的日期
     *
     * @param date
     * @param hours
     * @return
     */
    public static Date plusHours(Date date, int hours) {

        if (hours < 0) {
            throw new IllegalArgumentException();
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(date.getTime());

        calendar.add(Calendar.HOUR_OF_DAY, hours);

        return calendar.getTime();
    }

    // 日期转换为日期字符串
    public static String getStrDate(Date date, String format) {
        if (date == null || format == null) {
            return "";
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    // 日期转换为日期字符串
    public static String getStrDate(Date date) {
        return getStrDate(date, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * currTime时间seconds后
     *
     * @param currTime
     * @param seconds
     * @return
     */
    public static String dateAddBySec(String currTime, int seconds) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        // String str="20131109012836";
        Date dt;
        try {
            dt = sdf.parse(currTime);
            Calendar rightNow = Calendar.getInstance();
            rightNow.setTime(dt);
            rightNow.add(Calendar.SECOND, seconds);// 日期减十分钟
            Date dt1 = rightNow.getTime();
            return sdf.format(dt1);
        } catch (ParseException e) {
            logger.error("Date parse error:", e);
        }
        return null;
    }

    public static boolean isGreaterThan(String aDate, String bDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date1;
        Date date2;
        try {
            date1 = sdf.parse(aDate);
            date2 = sdf.parse(bDate);

            if (date1.after(date2))
                return true;
            if (date1.before(date2))
                return false;
            if (date1.equals(date2))
                return false;
        } catch (ParseException e) {
            logger.error("Date parse error:", e);
        }
        return false;
    }

    public static boolean isGreaterThan(Date aDate, Date bDate) {
        if (null == aDate) {
            return false;
        }

        if (null == bDate) {
            return true;
        }

        if (aDate.after(bDate))
            return true;
        if (aDate.before(bDate))
            return false;
        if (aDate.equals(bDate))
            return false;
        return false;
    }

    /**
     * 把字符串形式(yyyy-MM-dd HH:mm:ss)转换成时间
     */
    public static Date getDate_yyyyMMddHHmmss(String strDate) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = f.parse(strDate);
        } catch (ParseException e) {
            logger.error("Get date failed.", e);
        }

        return date;
    }

    /**
     * 把时间转换成字符串形式(YYYYMMDDHHSSHHmmss.SSS)
     */
    public static String getDate_yyyyMMddHHmmssSSS(Date date) {
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMddHHmmss.SSS");
        return f.format(date);
    }

    /**
     * 把时间转换成 YYYYMMDDHHSS 形式的字符串
     */
    public static String getYYYYMMDDHHMMSS(Date date) {
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMddHHmmss");
        return f.format(date);
    }

    public static String getCurrentMicro(Date date) {
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return f.format(date);
    }

    /**
     * 将java.util.Date 格式转换为字符串格式'yyyy-MM-dd HH:mm:ss'(24小时制) 如Sat May 11 17:24:21
     * CST 2002 to '2002-05-11 17:24:21'
     *
     * @param date 日期
     * @return String 字符串
     */
    public static String dateToString(Date date) {
        if (null == date) {
            return "";
        }
        SimpleDateFormat formatter;
        formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(date);
    }

    public static String getCurrStrDate(Date date) {
        return getStrDate(date, "yyyy-MM-dd");
    }

    /**
     * 增加日期中某类型的某数值。如增加日期
     *
     * @param date     日期
     * @param dateType 类型
     * @param amount   数值
     * @return 计算后日期
     */
    public static Date addInteger(Date date, int dateType, int amount) {
        Date myDate = null;
        if (date != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(dateType, amount);
            myDate = calendar.getTime();
        }
        return myDate;
    }

    /**
     * 增加日期的分钟。失败返回null。
     *
     * @param date       日期
     * @param hourAmount 增加数量。可为负数
     * @return 增加分钟后的日期
     */
    public static Date addMinute(Date date, int hourAmount) {
        return addInteger(date, Calendar.MINUTE, hourAmount);
    }

    /**
     * 获取过去第几天的日期
     *
     * @param past
     * @return
     */
    public static Date getPastDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        Date date = calendar.getTime();

        return date;
    }

    /**
     * 获取过去第几天的日期
     *
     * @param past
     * @return
     */
    public static Date getPastDate(int past, Date fromDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fromDate);

        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        Date date = calendar.getTime();

        return date;
    }

    /**
     * 获取过去第几周的第一天
     *
     * @param past
     * @return
     */
    public static Date getPastWeek(int past) {
        Calendar cal = Calendar.getInstance();

        int day = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        cal.setFirstDayOfWeek(Calendar.MONDAY);

        return getPastDate(7 * (past - 1) + day - cal.getFirstDayOfWeek());
    }

    /**
     * 获取过去第几月的第一天
     *
     * @param past
     * @return
     */
    public static Date getPastMonth(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE, 1);// 设为当前月的1号
        calendar.add(Calendar.MONTH, 1 - past);// 0表示当前月，-2就是当前月-2
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        Date date = calendar.getTime();

        return date;
    }

    /**
     * 获取过去第几月的第一天
     *
     * @param past
     * @return
     */
    public static Date getPastYear(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 1 - past);// 0表示当前年，-2就是当前年-2
        calendar.set(Calendar.MONTH, 0);// 设为当前年的1月
        calendar.set(Calendar.DATE, 1);// 设为当前月的1号

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        Date date = calendar.getTime();

        return date;
    }

    /**
     * 获取日期属于当年第几周
     *
     * @param date
     * @return
     */
    public static String getWeekOfYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        int year = calendar.getWeekYear();
        int week = calendar.get(Calendar.WEEK_OF_YEAR);

        if (week < 10) {
            return year + "w0" + week;
        } else {
            return year + "w" + week;
        }
    }

    public static String dateToWeek(Date date) {
        String[] weekDays = {"txt.sunday", "txt.monday", "txt.tuesday", "txt.wednesday", "txt.thursday", "txt.friday", "txt.saturday"};
        Calendar cal = Calendar.getInstance(); // 获得一个日历
        cal.setTime(date);

        int w = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天。
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

    /**
     * 根据输入日期和英特网编号分配机构（IANA）的时区数据库转换时区
     *
     * @param date 时间
     * @param iana 时区值（英特网编号分配机构的时区数据库为准）
     * @return
     * @desc 没有iana时，不转换时间
     */
    public static Date timeZoneConversion(Date date, String iana) {
        if (date == null) {
            return date;
        }
        if (StringUtils.isEmpty(iana)) {
            return date;
        }
        ZoneId zoneId = ZoneId.of(iana);
        Instant instant = date.toInstant();
        // atZone()方法返回在指定时区从此Instant生成的ZonedDateTime。
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        //返回转换后的时区
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date getStartTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static void main(String[] args) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int monthUnit = Calendar.MONTH;
        int yearUnit = Calendar.YEAR;
        int quarterUnit = Calendar.MONTH;
        Date now = new Date();
        Date month = addInteger(now, monthUnit, 1);
        Date quarter = addInteger(now, quarterUnit, 3);
        Date year = addInteger(now, yearUnit, 1);

        System.out.println("### now #### " + sf.format(now));
        System.out.println("### month #### " + sf.format(month));
        System.out.println("### quarter #### " + sf.format(quarter));
        System.out.println("### year #### " + sf.format(year));

        System.out.println(getCurrentMicro(new Date()));
    }
}
