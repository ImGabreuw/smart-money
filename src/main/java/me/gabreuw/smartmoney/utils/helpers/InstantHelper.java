package me.gabreuw.smartmoney.utils.helpers;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class InstantHelper {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter
            .ofLocalizedDateTime(FormatStyle.LONG)
            .withZone(ZoneId.systemDefault());

    public static String format(Instant moment) {
        return FORMATTER.format(moment);
    }

}
