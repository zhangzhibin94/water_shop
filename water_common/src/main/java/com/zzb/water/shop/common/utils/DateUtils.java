package com.zzb.water.shop.common.utils;

import com.zzb.water.shop.common.context.InfoContext;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * @Author by 张志斌 .
 * @Date 16:51 2019/7/4
 */
public class DateUtils {
    public static String getShortTimeDesc(Date dt) {
        String desc = "";
        int minute = DateUtil.getDiffMinite(dt, new Date());
        int hour = DateUtil.getDiffHour(dt, new Date());
        int day = DateUtil.getDiffDays(dt, new Date());
        if (minute == 0) {
            desc = "刚刚";
        } else if (minute < InfoContext.PER_HOUR_MINUTES) {
            desc = minute + "分钟前";
        } else if (hour < InfoContext.PER_DAY_HOURS) {
            desc = hour + "小时前";
        } else if (day > 0 && day < 8) {
            desc = day + "天前";
        } else {
            DateFormat format = new SimpleDateFormat("MM-dd HH:mm");
            // Math.Floor(day) + "天前";
            desc = format.format(dt);
        }

        return desc;
    }

    public static String getShortTime(Date dt) {
        DateFormat format = new SimpleDateFormat("MM-dd HH:mm");
        return format.format(dt);
    }


    /**
     *  获取当前时间到当天23:59:59，剩余的秒数
     */
    public static Long getSecondsToTomorrow() {
        LocalDateTime midnight = LocalDateTime.now().plusDays(1).withHour(0).withMinute(0).withSecond(0).withNano(0);
        Long seconds = ChronoUnit.SECONDS.between(LocalDateTime.now(), midnight);
        if (seconds != null) {
            return seconds.longValue();
        } else {
            return new Long(0);
        }
    }

    /**
     * 计算日期相差的天数
     *
     * @param smdate
     * @param bdate
     * @return
     */
    public static int daysBetween(Date smdate, Date bdate) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            smdate = sdf.parse(sdf.format(smdate));
            bdate = sdf.parse(sdf.format(bdate));
            Calendar cal = Calendar.getInstance();
            cal.setTime(smdate);
            long time1 = cal.getTimeInMillis();
            cal.setTime(bdate);
            long time2 = cal.getTimeInMillis();
            long betweenDays = (time2 - time1) / (1000 * 3600 * 24);
            return Integer.parseInt(String.valueOf(betweenDays));
        } catch (Exception e) {
            return -1;
        }
    }

    public static int getDiffHour(Date begin, Date end) {
        int diffHour = DateUtil.getDiffHour(begin, end);
        int diffMinite = DateUtil.getDiffMinite(begin, end);
        if(diffMinite < diffHour*InfoContext.PER_HOUR_MINUTES) {
            //入
            diffHour =  diffHour-1;
        }
        return diffHour;
    }

    public static String getNewShortTime(Date dt) {
        if(dt == null) {
            return "";
        }
        Date now = new Date();
        String desc = "";
        int second = getDiffSecond(dt, now);
        int minute = DateUtil.getDiffMinite(dt, now);
        int hour = DateUtil.getDiffHour(dt, now);

        if(second == 0) {
            desc  = "刚刚";
        } else if(second < InfoContext.PER_HOUR_SECOND) {
            desc  = second + "秒前";
        } else if (minute == 0){
            desc  = "1分钟前";
        } else if(minute < InfoContext.PER_HOUR_MINUTES) {
            desc = minute + "分钟前";
        } else if (hour < InfoContext.PER_DAY_HOURS) {
            desc = hour + "小时前";
        } else if (isSameYear(dt, now)) {
            DateFormat format = new SimpleDateFormat("MM-dd HH:mm");
            desc = format.format(dt);
        } else {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            desc = format.format(dt);
        }

        return desc;
    }

    public static int getDiffSecond(Date begin, Date end) {
        Calendar c0 = Calendar.getInstance();
        c0.setTime(begin);
        c0.set(13, 0);
        c0.set(14, 0);
        Calendar c1 = Calendar.getInstance();
        c1.setTime(end);
        c1.set(13, 0);
        c1.set(14, 0);
        return (int)((c1.getTimeInMillis() - c0.getTimeInMillis()) / 1000L);
    }

    public static boolean isSameYear(Date begin, Date end) {
        Calendar c0 = Calendar.getInstance();
        c0.setTime(begin);
        Calendar c1 = Calendar.getInstance();
        c1.setTime(end);
        return c0.get(Calendar.YEAR) == c1.get(Calendar.YEAR);
    }

    public static String getShortTime2(Date dt) {
        if (dt == null) {
            return "";
        }
        String desc = "";
        Date now = new Date();
        if (isSameYear(dt, now)) {
            DateFormat format = new SimpleDateFormat("MM-dd HH:mm");
            desc = format.format(dt);
        } else {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            desc = format.format(dt);
        }

        return desc;
    }
}
