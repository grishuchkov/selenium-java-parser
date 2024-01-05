package ru.grishuchkov.seleniumparser.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.grishuchkov.seleniumparser.dto.Report;
import ru.grishuchkov.seleniumparser.utils.StringUtils;
import ru.grishuchkov.seleniumparser.utils.TimeUtils;

import java.time.Duration;

@Service
@RequiredArgsConstructor
@Slf4j
public class ParseServiceImpl implements ParseService {

    private final WebDriver webDriver;
    private final StringUtils stringUtils;
    private final TimeUtils timeUtils;


    @Value("${site.people-class}")
    private String classNameWithPeopleCounter;

    @Override
    public Report parse(String url) {
        Report report = new Report();
        try {
            log.info("Start parse: " + url);
            report = doParse(url);

            log.info(String.valueOf(report));
            log.info("Stop parse");
        } catch (Exception exception) {
            log.error(exception.getMessage());
        }
        return report;
    }

    private Report doParse(String siteUrl) {
        webDriver.get(siteUrl);

        webDriver.manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(5));

        String stringWithCount = webDriver
                .findElement(By.className(classNameWithPeopleCounter))
                .getText();

        int peopleCount = stringUtils
                .getPeopleCount(stringWithCount);

        return new Report(peopleCount, timeUtils.getCurrentDateAndTime());
    }
}
