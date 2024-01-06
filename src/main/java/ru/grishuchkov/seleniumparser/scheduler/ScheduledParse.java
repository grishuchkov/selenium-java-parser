package ru.grishuchkov.seleniumparser.scheduler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.grishuchkov.seleniumparser.client.GoogleSheetsClient;
import ru.grishuchkov.seleniumparser.dto.Report;
import ru.grishuchkov.seleniumparser.service.ParseService;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
@Slf4j
public class ScheduledParse {

    private final ParseService parseService;
    private final GoogleSheetsClient googleSheetsClient;

    @Value("${site.arta-gym.url}")
    private String arataGymUrl;

    @Value("${site.arta-gym.name}")
    private String artaGymName;

    @Value("${site.alex-fitness.url}")
    private String alexFitnessUrl;

    @Value("${site.alex-fitness.name}")
    private String alexFitnessName;

    @Scheduled(fixedDelay = 1, timeUnit = TimeUnit.MINUTES)
    private void parse(){
        parseArtaGym();
        parseAlexFitness();
    }

    private void parseAlexFitness() {
        Report report = parseService.parse(alexFitnessUrl);
        report.setClub(alexFitnessName);
        googleSheetsClient.sendReport(report);
    }

    private void parseArtaGym() {
        Report report = parseService.parse(arataGymUrl);
        report.setClub(artaGymName);
        googleSheetsClient.sendReport(report);
    }
}
