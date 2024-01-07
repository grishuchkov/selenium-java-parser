package ru.grishuchkov.seleniumparser.config;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestClient;

import java.net.MalformedURLException;
import java.net.URL;

@Configuration
@Slf4j
@PropertySource("classpath:application.yaml")
public class AppConfig {

    @Value("${selenium.chrome-url}")
    String remoteChromeUrl;

    @Bean
    public WebDriver webDriver() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        return new RemoteWebDriver(new URL(remoteChromeUrl), options);
    }

    @Bean
    public RestClient restClient() {
        return RestClient
                .builder()
                .build();
    }
}
