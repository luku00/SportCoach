package com.sport.coach.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 *
 * @author luku00
 */
public class ConvertionUtil {

    public static Timestamp convertStringToTimestamp(String str) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date parsedDate = format.parse(str);
        Timestamp timeStamp = new Timestamp(parsedDate.getTime());
        return timeStamp;
    }

    public static Long parseStringDoubleToLong(String strDouble) {
        strDouble = strDouble.substring(0, strDouble.indexOf("."));
        return Long.parseLong(strDouble);
    }

    public static String stringFromTimeStamp(Timestamp ts) {
        return new SimpleDateFormat("MM/dd/yyyy").format(ts);
    }

    public static String convertSecondsToTimeString(Long sec) {
        long hours = sec / 3600;
        long minutes = (sec % 3600) / 60;
        long secs = sec % 60;
        return hours + ":" + minutes + ":" + secs;
    }

    public static String convertStrMetersToStrKm(String meters) {
        double m = Double.parseDouble(meters);
        double rounded = (double) Math.round(m);
        return String.valueOf(rounded / 1000) + " Km";

    }
}
