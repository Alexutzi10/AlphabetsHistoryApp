package com.example.istoriaalfabetelor.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateConverter {
    private static final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);

    public static Date toDate(String date) throws ParseException {
        if (date == null) {
            return null;
        } else {
            return dateFormatter.parse(date);
        }
    }

    public static String toText(Date date) {
        if (date == null) {
            return null;
        } else {
            return dateFormatter.format(date);
        }
    }
}
