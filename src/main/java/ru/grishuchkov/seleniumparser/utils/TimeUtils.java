package ru.grishuchkov.seleniumparser.utils;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class TimeUtils {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    public String getCurrentDateAndTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.format(formatter);
    }
}
