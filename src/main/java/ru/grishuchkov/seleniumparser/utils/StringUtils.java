package ru.grishuchkov.seleniumparser.utils;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class StringUtils {

    public int getPeopleCount(String stringWithCount){
        String countString = stringWithCount.split(" ")[1];
        return Integer.parseInt(countString);
    }
}
