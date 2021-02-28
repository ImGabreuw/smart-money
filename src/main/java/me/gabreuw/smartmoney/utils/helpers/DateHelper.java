package me.gabreuw.smartmoney.utils.helpers;

import me.gabreuw.smartmoney.utils.URL;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

public class DateHelper {

    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static String format(Date moment) {
        return FORMAT.format(moment);
    }

    public static Date parse(String moment) {
        try {
            return FORMAT.parse(URL.decodeToUTF(moment));
        } catch (ParseException e) {
            return null;
        }
    }
}
