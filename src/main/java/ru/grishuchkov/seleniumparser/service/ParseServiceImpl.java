package ru.grishuchkov.seleniumparser.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.grishuchkov.seleniumparser.client.GoogleSheetsClient;
import ru.grishuchkov.seleniumparser.dto.Report;
import ru.grishuchkov.seleniumparser.utils.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
@Slf4j
public class ParseServiceImpl implements ParseService {

    private final WebDriver webDriver;
    private final StringUtils utils;
    private final GoogleSheetsClient googleSheetsClient;

    @Value("${site.url}")
    private String siteUrl;

    @Value("${site.people-class}")
    private String classNameWithPeopleCounter;

    @Override
    public void parse() {
        log.info("Start parse");

        webDriver.get(siteUrl);

        String stringWithCount = webDriver
                .findElement(By.className(classNameWithPeopleCounter))
                .getText();

        int peopleCount = utils.getPeopleCount(stringWithCount);

        log.info("Stop parse");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime localDateTime = LocalDateTime.now();
        String date = localDateTime.format(formatter);

        Report report = new Report(peopleCount, date);

        log.info(String.valueOf(report));

        googleSheetsClient.sendReport(report);
    }

}
