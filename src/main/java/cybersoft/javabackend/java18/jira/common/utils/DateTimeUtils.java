package cybersoft.javabackend.java18.jira.common.utils;

import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@UtilityClass
public class DateTimeUtils {
    public static final String DATETIME_FORMAT_dd_MM_yyyy_HH_mm_ss = "dd-MM-yyyy HH:mm:ss";

    public static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern(DATETIME_FORMAT_dd_MM_yyyy_HH_mm_ss);

    public static String now() {
        return LocalDateTime.now()
                .format(formatter);
    }
}
