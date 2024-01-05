package ru.grishuchkov.seleniumparser.utils;

import org.springframework.stereotype.Component;

@Component
public class StringUtils {

    public int getPeopleCount(String stringWithCount){
        String countString = stringWithCount.split(" ")[1];
        return Integer.parseInt(countString);
    }
}
