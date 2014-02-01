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
}
