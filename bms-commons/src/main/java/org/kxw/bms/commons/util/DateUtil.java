package org.kxw.bms.commons.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 日期处理工具类
 * Create by kangxiongwei on 2018/8/11 下午12:19
 */
public class DateUtil {

    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String TIME_FORMAT = "HH:mm:ss";
    public static final String DATE_TIME_FORMAT = DATE_FORMAT + " " + TIME_FORMAT;

    /**
     * 字符串转日期
     *
     * @param date
     * @return
     */
    public static Date stringToDate(String date) {
        LocalDateTime ldt = LocalDateTime.parse(date, DateTimeFormatter.ofPattern(DATE_TIME_FORMAT));
        return Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 日期转字符串
     *
     * @param date
     * @return
     */
    public static String dateToString(Date date) {
        LocalDateTime ldt = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        return ldt.format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT));
    }

}
