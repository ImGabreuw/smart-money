package me.gabreuw.smartmoney.utils;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class URL {

    public static String decodeToUTF(String text) {
        return URLDecoder.decode(
                text,
                StandardCharsets.UTF_8
        );
    }

}
