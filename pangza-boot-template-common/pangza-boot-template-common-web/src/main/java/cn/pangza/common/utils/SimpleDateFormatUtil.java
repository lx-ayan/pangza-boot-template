package cn.pangza.common.utils;

import org.apache.commons.lang3.ObjectUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class SimpleDateFormatUtil {
    private static final ThreadLocal<SimpleDateFormat> THREAD_LOCAL = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    public static SimpleDateFormat getTime() {
        SimpleDateFormat simpleDateFormat = THREAD_LOCAL.get();
        if(simpleDateFormat == null){
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
        return simpleDateFormat;
    }

    public static String dateToString(String format, Date date) {
        if(ObjectUtils.isEmpty(date)) return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }

    public static String dateToLString(String format, LocalDate date) {
        if(ObjectUtils.isEmpty(date)) return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }

    public static Date stringToDate(String format, String date) throws ParseException {
        if(ObjectUtils.isEmpty(date)) return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.parse(date);
    }
}
