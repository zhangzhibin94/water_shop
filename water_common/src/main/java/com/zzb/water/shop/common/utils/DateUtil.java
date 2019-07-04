package com.zzb.water.shop.common.utils;

import com.zzb.water.shop.common.context.FormatConfig;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author by 张志斌 .
 * @Date 16:55 2019/7/4
 */
public class DateUtil {
    private static final Log log = LogFactory.getLog(DateUtil.class);
    public static final int SECONDS_OF_MINITE = 60;
    public static final int SECONDS_OF_HOUR = 3600;
    public static final int MILLISECONDS_OF_MINITE = 60000;
    public static final int MILLISECONDS_OF_HOUR = 3600000;
    public static final long MILLISECONDS_OF_DAY = 86400000L;
    public static final int SECONDS_OF_DAY = 86400;
    public static final int DATE_FORMAT_BY_TIME = 1;
    public static final int DATE_FORMAT_BY_DATE = 2;
    public static final int DATE_FORMAT_BY_OTHER_TIME = 3;
    public static final int DATE_FORMAT_BY_OTHER_DATE = 4;
    public static final int DATE_FORMAT_BY_SIAMPLE_TIME = 5;
    public static final int DATE_FORMAT_BY_SIAMPLE_DATE = 6;
    private static final SimpleDateFormat rssDate;
    private static final SimpleTimeZone aZone;

    public DateUtil() {
    }

    public static SimpleDateFormat getTimeFormat() {
        return new SimpleDateFormat(FormatConfig.TIME);
    }

    public static SimpleDateFormat getOtherTimeFormat() {
        return new SimpleDateFormat(FormatConfig.OTHER_TIME);
    }

    public static SimpleDateFormat getOtherDateFormat() {
        return new SimpleDateFormat(FormatConfig.OTHER_DATE);
    }

    public static SimpleDateFormat getDateFormat() {
        return new SimpleDateFormat(FormatConfig.DATE);
    }

    public static SimpleDateFormat getSampleTimeFormat() {
        return new SimpleDateFormat(FormatConfig.SAMPLE_TIME);
    }

    public static SimpleDateFormat getSampleDateFormat() {
        return new SimpleDateFormat(FormatConfig.SAMPLE_DATE);
    }

    public static SimpleDateFormat getHourDateFormat() {
        return new SimpleDateFormat(FormatConfig.HOUR_TIME);
    }

    public static SimpleDateFormat getHHmmFormat() {
        return new SimpleDateFormat(FormatConfig.HH_MM);
    }

    public static String formatHHmm(Date date) {
        return getHHmmFormat().format(date);
    }

    public static String dateToRssDate(Date d) {
        return rssDate.format(d);
    }

    public static Date getNowMinuteDate() {
        Calendar c = Calendar.getInstance();
        c.set(13, 0);
        c.set(14, 0);
        return c.getTime();
    }

    public static Date getNowHourDate() {
        Calendar c = Calendar.getInstance();
        c.set(13, 0);
        c.set(12, 0);
        c.set(14, 0);
        return c.getTime();
    }

    public static Date getHourDate(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(13, 0);
        c.set(12, 0);
        c.set(14, 0);
        return c.getTime();
    }

    public static Date[] getPreDates(int days) {
        Date[] dates = new Date[days];
        Calendar c = Calendar.getInstance();
        c.set(11, 0);
        c.set(12, 0);
        c.set(13, 0);
        c.set(14, 0);
        dates[0] = c.getTime();

        for(int i = 1; i < days; ++i) {
            c.add(6, -1);
            dates[i] = c.getTime();
        }

        return dates;
    }

    public static Date getYesterday() {
        Calendar c = Calendar.getInstance();
        c.set(11, 0);
        c.set(12, 0);
        c.set(13, 0);
        c.set(14, 0);
        c.add(6, -1);
        return c.getTime();
    }

    public static String hourTimeFormat(Date date) {
        return getHourDateFormat().format(date);
    }

    public static String[] formats(SimpleDateFormat sdf, Date[] dates) {
        String[] dateFormats = new String[dates.length];

        try {
            for(int i = 0; i < dates.length; ++i) {
                dateFormats[i] = sdf.format(dates[i]);
            }
        } catch (Exception var4) {
            log.error("formats " + dates[0], var4);
        }

        return dateFormats;
    }

    public static String[] formats(SimpleDateFormat sdf, List<Date> dateList, int size) {
        if(dateList == null || dateList.size() > size) {
            log.error("formats error");
        }

        String[] dateFormats = new String[size];

        try {
            for(int i = 0; i < dateList.size(); ++i) {
                dateFormats[i] = sdf.format((Date)dateList.get(i));
            }
        } catch (Exception var5) {
            log.error("formats " + dateList.get(0), var5);
        }

        return dateFormats;
    }

    public static Date rssDateToDate(String rd) {
        boolean ret = false;

        try {
            Date d = rssDate.parse(rd);
            ret = true;
            Date var3 = d;
            return var3;
        } catch (Exception var7) {
            log.error("rssDateToDate date " + rd, var7);
        } finally {
            if(!ret) {
                log.error("rssDateToDate date " + rd);
            }

        }

        return null;
    }

    public static String sampleTimeFormat(Date date) {
        return getSampleTimeFormat().format(date);
    }

    public static String sampleDateFormat(Date date) {
        return getSampleDateFormat().format(date);
    }

    public static String otherTimeFormat(Date date) {
        return getOtherTimeFormat().format(date);
    }

    public static String timeFormat(Date date) {
        return getTimeFormat().format(date);
    }

    public static String dateFormat(Date date) {
        return getDateFormat().format(date);
    }

    public static String otherDateFormat(Date date) {
        return getOtherDateFormat().format(date);
    }

    public static Date parseTime(String date) {
        boolean ret = false;

        try {
            Date d = getTimeFormat().parse(date);
            ret = true;
            Date var3 = d;
            return var3;
        } catch (Exception var7) {
            log.error("parseTime date " + date, var7);
        } finally {
            if(!ret) {
                log.error("parseTime date " + date);
            }

        }

        return null;
    }

    public static Date parseSampleTime(String date) {
        boolean ret = false;

        try {
            Date d = getSampleTimeFormat().parse(date);
            ret = true;
            Date var3 = d;
            return var3;
        } catch (Exception var7) {
            log.error("parseSampleTime date " + date, var7);
        } finally {
            if(!ret) {
                log.error("parseSampleTime date " + date);
            }

        }

        return null;
    }

    public static Date parseSampleDate(String date) {
        boolean ret = false;

        try {
            Date d = getSampleDateFormat().parse(date);
            ret = true;
            Date var3 = d;
            return var3;
        } catch (Exception var7) {
            log.error("parseSampleDate date " + date, var7);
        } finally {
            if(!ret) {
                log.error("parseSampleDate date " + date);
            }

        }

        return null;
    }

    public static Date parseOtherTime(String date) {
        boolean ret = false;

        try {
            Date d = getOtherTimeFormat().parse(date);
            ret = true;
            Date var3 = d;
            return var3;
        } catch (ParseException var7) {
            log.error("parseOtherTime date " + date, var7);
        } finally {
            if(!ret) {
                log.error("parseOtherTime date " + date);
            }

        }

        return null;
    }

    public static Date parseDate(String date) {
        boolean ret = false;

        try {
            Date d = getDateFormat().parse(date);
            ret = true;
            Date var3 = d;
            return var3;
        } catch (Exception var7) {
            log.error("parseDate date " + date, var7);
        } finally {
            if(!ret) {
                log.error("parseDate date " + date);
            }

        }

        return null;
    }

    public static Date parseOtherDate(String date) {
        boolean ret = false;

        try {
            Date d = getOtherDateFormat().parse(date);
            Date var3 = d;
            return var3;
        } catch (ParseException var7) {
            log.error("parseOtherDate date " + date, var7);
        } finally {
            if(!ret) {
                log.error("parseOtherDate date " + date);
            }

        }

        return null;
    }

    public static String getOtherNowTime() {
        return otherTimeFormat(new Date());
    }

    public static String getNowTime() {
        return timeFormat(new Date());
    }

    public static String getNowDate() {
        return dateFormat(new Date());
    }

    public static long getNowSec() {
        return System.currentTimeMillis() / 1000L;
    }

    public static long getNowMillis() {
        return System.currentTimeMillis();
    }

    public static Timestamp nowTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    public static Date timeMillisToDate(long timeMillis) {
        return new Date(timeMillis);
    }

    public static Date timeSecondsToDate(long timeSeconds) {
        return timeMillisToDate(timeSeconds * 1000L);
    }

    public static Timestamp timeMillisToTimestamp(long timeMillis) {
        return new Timestamp(timeMillis);
    }

    public static Timestamp timeSecondsToTimestamp(long timeSeconds) {
        return timeMillisToTimestamp(timeSeconds * 1000L);
    }

    public static Date nowDate() {
        return new Date();
    }

    public static Date getDate() {
        Calendar c = Calendar.getInstance();
        c.set(11, 0);
        c.set(12, 0);
        c.set(13, 0);
        c.set(14, 0);
        return c.getTime();
    }

    public static Date getDate(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(11, 0);
        c.set(12, 0);
        c.set(13, 0);
        c.set(14, 0);
        return c.getTime();
    }

    public static Date[] getDates() {
        Date[] dates = new Date[2];
        Calendar c = Calendar.getInstance();
        dates[0] = c.getTime();
        c.set(11, 0);
        c.set(12, 0);
        c.set(13, 0);
        c.set(14, 0);
        dates[1] = c.getTime();
        return dates;
    }

    public static Calendar getCalendar() {
        Calendar c = Calendar.getInstance();
        c.set(11, 0);
        c.set(12, 0);
        c.set(13, 0);
        c.set(14, 0);
        return c;
    }

    public static Date preDate(Date date, int subDay) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(6, -subDay);
        c.set(11, 0);
        c.set(12, 0);
        c.set(13, 0);
        c.set(14, 0);
        return c.getTime();
    }

    public static Date preDate(int subDay) {
        Calendar c = Calendar.getInstance();
        c.add(6, -subDay);
        c.set(11, 0);
        c.set(12, 0);
        c.set(13, 0);
        c.set(14, 0);
        return c.getTime();
    }

    public static Date preMonthDate() {
        Calendar c = Calendar.getInstance();
        c.add(2, -1);
        c.set(11, 0);
        c.set(12, 0);
        c.set(13, 0);
        c.set(14, 0);
        return c.getTime();
    }

    public static Date preWeekDate() {
        return preDate(6);
    }

    public static int getWeek(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int week = c.get(7);
        return week == 1?7:week - 1;
    }

    public static int getWeek() {
        Calendar c = Calendar.getInstance();
        int week = c.get(7);
        return week == 1?7:week - 1;
    }

    public static boolean isGreaterThan(int hourOfDay, Date time) {
        Calendar c = Calendar.getInstance();
        c.setTime(time);
        c.set(11, hourOfDay);
        c.set(12, 0);
        c.set(13, 0);
        c.set(14, 0);
        return time.getTime() >= c.getTimeInMillis();
    }

    public static int getDiffDaysByHour(Date beginDate, Date endDate, int hourOfDay) {
        Calendar begin = Calendar.getInstance();
        begin.setTime(beginDate);
        begin.set(11, hourOfDay);
        begin.set(12, 0);
        begin.set(13, 0);
        begin.set(14, 0);
        long bt = begin.getTimeInMillis();
        begin.set(11, 0);
        if(beginDate.getTime() >= bt) {
            begin.add(6, 1);
        }

        Calendar end = Calendar.getInstance();
        end.setTime(endDate);
        end.set(11, hourOfDay);
        end.set(12, 0);
        end.set(13, 0);
        end.set(14, 0);
        long et = end.getTimeInMillis();
        end.set(11, 0);
        if(endDate.getTime() >= et) {
            end.add(6, 1);
        }

        return (int)((end.getTimeInMillis() - begin.getTimeInMillis()) / 86400000L);
    }

    public static int getDiffDays(Date beginDate, Date endDate) {
        Calendar begin = Calendar.getInstance();
        begin.setTime(beginDate);
        begin.set(11, 0);
        begin.set(12, 0);
        begin.set(13, 0);
        begin.set(14, 0);
        Calendar end = Calendar.getInstance();
        end.setTime(endDate);
        end.set(11, 0);
        end.set(12, 0);
        end.set(13, 0);
        end.set(14, 0);
        return (int)((end.getTimeInMillis() - begin.getTimeInMillis()) / 86400000L);
    }

    public static int parseTime2Int(String time) {
        String[] hm = time.split(":");
        return Integer.parseInt(hm[0]) * 60 + Integer.parseInt(hm[1]);
    }

    public static Date get5Multiple(long time) {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date(time));
        c.set(13, 0);
        c.set(14, 0);
        int min = c.get(12);
        min += 5 - min % 5;
        c.set(12, min);
        return c.getTime();
    }

    public static int getDiffHour(Date begin, Date end) {
        Calendar c0 = Calendar.getInstance();
        c0.setTime(begin);
        c0.set(12, 0);
        c0.set(13, 0);
        c0.set(14, 0);
        Calendar c1 = Calendar.getInstance();
        c1.setTime(end);
        c1.set(12, 0);
        c1.set(13, 0);
        c1.set(14, 0);
        return (int)((c1.getTimeInMillis() - c0.getTimeInMillis()) / 3600000L);
    }

    public static int getDiffMinite(Date begin, Date end) {
        Calendar c0 = Calendar.getInstance();
        c0.setTime(begin);
        c0.set(13, 0);
        c0.set(14, 0);
        Calendar c1 = Calendar.getInstance();
        c1.setTime(end);
        c1.set(13, 0);
        c1.set(14, 0);
        return (int)((c1.getTimeInMillis() - c0.getTimeInMillis()) / 60000L);
    }

    public static boolean isSameDay(Date beginDate, Date endDate) {
        return getDiffDays(beginDate, endDate) == 0;
    }

    public static boolean isSameWeek(Date beginDate, Date endDate) {
        Calendar begin = Calendar.getInstance();
        begin.setTime(beginDate);
        Calendar end = Calendar.getInstance();
        end.setTime(endDate);
        int beginDayOfWeek = begin.get(7);
        if(beginDayOfWeek == 1) {
            begin.add(6, -6);
        } else if(beginDayOfWeek > 2) {
            begin.add(6, 2 - beginDayOfWeek);
        }

        int endDayOfWeek = end.get(7);
        if(endDayOfWeek == 1) {
            end.add(6, -6);
        } else if(endDayOfWeek > 2) {
            end.add(6, 2 - endDayOfWeek);
        }

        return end.get(1) == begin.get(1) && end.get(6) == begin.get(6);
    }

    public static boolean isInTime(Date time, Date begin, Date end) {
        long mill = time.getTime();
        return begin.getTime() < mill && mill < end.getTime();
    }

    public static boolean isInTime(String time, String begin, String end) {
        try {
            String[] timeArr = time.split(":");
            if(timeArr.length != 2) {
                return false;
            } else {
                byte hour = Byte.parseByte(timeArr[0]);
                byte min = Byte.parseByte(timeArr[1]);
                String[] beginArr = begin.split(":");
                if(beginArr.length != 2) {
                    return false;
                } else {
                    byte bHour = Byte.parseByte(beginArr[0]);
                    byte bMin = Byte.parseByte(beginArr[1]);
                    String[] endArr = end.split(":");
                    if(endArr.length != 2) {
                        return false;
                    } else {
                        byte eHour = Byte.parseByte(endArr[0]);
                        byte eMin = Byte.parseByte(endArr[1]);
                        return isInTime(hour, min, bHour, bMin, eHour, eMin);
                    }
                }
            }
        } catch (Exception var12) {
            log.error("", var12);
            return false;
        }
    }

    public static boolean isInTime(Date time, Date comp, int bHour, int bMin, int eHour, int eMin) {
        Calendar c = Calendar.getInstance();
        c.setTime(time);
        int d0 = c.get(6);
        Calendar c1 = Calendar.getInstance();
        c.setTime(comp);
        int d1 = c1.get(6);
        if(d0 != d1) {
            return false;
        } else {
            byte hour = (byte)c.get(11);
            byte min = (byte)c.get(12);
            return isInTime(hour, min, bHour, bMin, eHour, eMin);
        }
    }

    public static boolean isInTime(Date time, int bHour, int bMin, int eHour, int eMin) {
        Calendar c = Calendar.getInstance();
        c.setTime(time);
        byte hour = (byte)c.get(11);
        byte min = (byte)c.get(12);
        return isInTime(hour, min, bHour, bMin, eHour, eMin);
    }

    public static boolean isInTime(int hour, int min, int bHour, int bMin, int eHour, int eMin) {
        int time = hour * 60 + min;
        int begin = bHour * 60 + bMin;
        int end = eHour * 60 + eMin;
        return begin <= time && time <= end;
    }

    public static int getInTimeStatus(Date date, int bHour, int bMin, int eHour, int eMin) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        byte hour = (byte)c.get(11);
        byte min = (byte)c.get(12);
        int time = hour * 60 + min;
        int begin = bHour * 60 + bMin;
        int end = eHour * 60 + eMin;
        return time < begin?-1:(time > end?1:0);
    }

    public static byte[] parseTime2Array(String time) {
        String[] fArr = time.split("\\-");
        String[] fArr0 = fArr[0].split(":");
        String[] fArr1 = fArr[1].split(":");
        return new byte[]{Byte.parseByte(fArr0[0]), Byte.parseByte(fArr0[1]), Byte.parseByte(fArr1[0]), Byte.parseByte(fArr1[1])};
    }

    public static Date moveDate(Date date, int dayNum, boolean clearTime) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int curDay = c.get(6);
        c.set(6, curDay + dayNum);
        if(clearTime) {
            c.set(11, 0);
            c.set(12, 0);
            c.set(13, 0);
            c.set(14, 0);
        }

        return c.getTime();
    }

    public static Date getDateByHm(int hour, int minute) {
        Calendar c = Calendar.getInstance();
        c.set(11, hour);
        c.set(12, minute);
        c.set(13, 0);
        c.set(14, 0);
        return c.getTime();
    }

    public static Date getPreDateByHm(int hour, int minute) {
        Calendar c = Calendar.getInstance();
        c.set(11, hour);
        c.set(12, minute);
        c.set(13, 0);
        c.set(14, 0);
        c.add(6, -1);
        return c.getTime();
    }

    public static Date getNextDateByHm(int hour, int minute) {
        Calendar c = Calendar.getInstance();
        c.set(11, hour);
        c.set(12, minute);
        c.set(13, 0);
        c.set(14, 0);
        c.add(6, 1);
        return c.getTime();
    }

    public static Date moveHour(Date date, int housrNum, boolean clearTime) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int curHour = c.get(11);
        c.set(11, curHour + housrNum);
        if(clearTime) {
            c.set(12, 0);
            c.set(13, 0);
            c.set(14, 0);
        }

        return c.getTime();
    }

    public static Date moveMinit(Date date, int minitNum, boolean clearTime) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int curHour = c.get(12);
        c.set(12, curHour + minitNum);
        if(clearTime) {
            c.set(13, 0);
            c.set(14, 0);
        }

        return c.getTime();
    }

    public static String format(Date date) {
        return format(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static String format(Date date, String pattern) {
        if(date == null) {
            return "null";
        } else {
            if(pattern == null || pattern.equals("") || pattern.equals("null")) {
                pattern = "yyyy-MM-dd HH:mm:ss";
            }

            return (new SimpleDateFormat(pattern)).format(date);
        }
    }

    public static Date format(String date) {
        return format((String)date, (String)null);
    }

    public static Date format(String date, String pattern) {
        if(pattern == null || pattern.equals("") || pattern.equals("null")) {
            pattern = "yyyy-MM-dd HH:mm:ss";
        }

        if(date != null && !date.equals("") && !date.equals("null")) {
            Date d = null;

            try {
                d = (new SimpleDateFormat(pattern)).parse(date);
            } catch (ParseException var4) {
                ;
            }

            return d;
        } else {
            return new Date();
        }
    }

    public static Date getStartTimeOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTime();
    }

    public static Date getEndTimeOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(11, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        calendar.set(14, 999);
        return calendar.getTime();
    }

    public static String transferNetDateString(Date date) {
        return date == null?"":"/Date(" + date.getTime() + "-0000)/";
    }

    public static Date transferDateFromNetDate(String netDate) {
        if(StringUtils.isBlank(netDate)) {
            return null;
        } else {
            Date date = new Date();
            String time = netDate.substring(netDate.indexOf("Date(") + 5, netDate.indexOf("-000"));
            date.setTime(Long.parseLong(time.replaceAll("-", "")));
            return date;
        }
    }

    static {
        rssDate = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss z", Locale.US);
        aZone = new SimpleTimeZone(8, "GMT");
        rssDate.setTimeZone(aZone);
    }
}
