package ru.grishuchkov.seleniumparser.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestClient;

@Configuration
public class AppConfig {

    @Bean
    public WebDriver webDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        return new ChromeDriver(options);
    }

    @Bean
    public RestClient restClient(){
        return RestClient
                .builder()
                .build();
    }
}
