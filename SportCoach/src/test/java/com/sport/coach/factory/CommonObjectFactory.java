/***************************************************************************************************
 * Copyright 2013 TeliaSonera. All rights reserved.
 **************************************************************************************************/
package com.sport.coach.factory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 *
 * @author Lukas Kubicek <lukas.kubicek@netcom-gsm.com>
 */
public class CommonObjectFactory {

    public static final String BIRTH_DAY = "11";
    public static final String BIRTH_MONTH = "5";
    public static final String BIRTH_YEAR = "1985";

    public static Date createJavaDate(String day, String month, String year) throws ParseException {
        return new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(day + "/" + month + "/" + year);
    }

    public static DateTime createDateTime(String day, String month, String year) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
        return formatter.parseDateTime(day + "/" + month + "/" + year);
    }
}
