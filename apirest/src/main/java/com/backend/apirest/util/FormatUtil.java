package com.backend.apirest.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FormatUtil {

    FormatUtil(){

    }
    public static String formatDateToStrings(Date inDate) {
        String pattern = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat(pattern);
        String dateString = simpleDateFormat.format(inDate);
        return dateString;
    }

}
