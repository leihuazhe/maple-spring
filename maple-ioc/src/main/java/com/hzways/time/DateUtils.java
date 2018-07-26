package com.hzways.time;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * desc: DateUtils
 *
 * @author hz.lei
 * @since 2018年07月25日 下午11:49
 */
public class DateUtils {

    public static final String DATE_FORMAT = "yyyy-MM-dd";

    public static final String TIME_FORMAT = "HH:mm:ss";

    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String DATE_TIME_FORMAT_SHORT = "yyyy-MM-dd HH:mm";

    public static final String TIMESTATMP_FORMAT = "yyyy-MM-dd HH:mm:ss.S";


    /**
     * 得到当前时间,返回long型
     *
     * @return String
     */
    public static long getCurrentLongTime() {
        return LocalDateTime.now(ZoneId.of("Asia/Shanghai")).toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }


    public String getCurrentTime() {
        return LocalDateTime.now(ZoneId.of("Asia/Shanghai")).format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT));


    }

    public String getCurrentTime(String format) {
        return LocalDateTime.now(ZoneId.of("Asia/Shanghai")).format(DateTimeFormatter.ofPattern(format));
    }

    /**
     * 根据格式生成日期时间
     *
     * @param date
     * @param formatStr
     * @return
     */
    public static String generateDateTime(Date date, String formatStr) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.of("Asia/Shanghai"));
        return localDateTime.format(DateTimeFormatter.ofPattern(formatStr));
    }



}

