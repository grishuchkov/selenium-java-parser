package ru.grishuchkov.seleniumparser.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.grishuchkov.seleniumparser.dto.Report;
import ru.grishuchkov.seleniumparser.utils.StringUtils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
@Slf4j
public class ParseServiceImpl implements ParseService {

    private final WebDriver webDriver;
    private final StringUtils utils;

    @Value("${site.people-class}")
    private String classNameWithPeopleCounter;


    private Report doParse(String siteUrl) {
        log.info("Start parse: " + siteUrl);

        webDriver.get(siteUrl);

        webDriver.manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(5));

        String stringWithCount = webDriver
                .findElement(By.className(classNameWithPeopleCounter))
                .getText();


        int peopleCount = utils.getPeopleCount(stringWithCount);

        log.info("Stop parse");

        Report report = new Report(peopleCount, getDate());
        log.info(String.valueOf(report));

        return report;
    }

    @Override
    public Report parse(String url) {
        Report report = new Report();
        try {
            report = doParse(url);
        } catch (Exception exception) {
            log.error(exception.getMessage());
        }
        return report;
    }

    @NotNull
    private String getDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.format(formatter);
    }


}
