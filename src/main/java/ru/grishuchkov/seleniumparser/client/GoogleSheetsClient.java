package ru.grishuchkov.seleniumparser.client;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import ru.grishuchkov.seleniumparser.client.response.GoogleResponse;
import ru.grishuchkov.seleniumparser.dto.Report;

import java.net.URI;
import java.util.Objects;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
@RequiredArgsConstructor
@Slf4j
public class GoogleSheetsClient {

    private final RestClient restClient;

    @Value("${google-client.url}")
    private String googleSheetUrl;

    public boolean sendReport(Report report){

        ResponseEntity<Void> response = restClient
                .post()
                .uri(googleSheetUrl)
                .body(report)
                .contentType(APPLICATION_JSON)
                .retrieve()
                .toBodilessEntity();

        URI redirectUrl = response.getHeaders().getLocation();

        ResponseEntity<GoogleResponse> googleResponse = restClient
                .get()
                .uri(redirectUrl)
                .retrieve()
                .toEntity(GoogleResponse.class);

        return googleResponse.getBody().getSuccess();
    }

}
