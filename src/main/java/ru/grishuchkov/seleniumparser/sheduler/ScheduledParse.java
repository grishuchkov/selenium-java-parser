package ru.grishuchkov.seleniumparser.sheduler;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.grishuchkov.seleniumparser.service.ParseService;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class ScheduledParse {

    private final ParseService parseService;

    @Scheduled(fixedDelay = 1, timeUnit = TimeUnit.MINUTES)
    public void doParse(){
        parseService.parse();
    }

}
