package ru.grishuchkov.seleniumparser.service;

import ru.grishuchkov.seleniumparser.dto.Report;

public interface ParseService {

    Report parse(String siteUrl);
}
