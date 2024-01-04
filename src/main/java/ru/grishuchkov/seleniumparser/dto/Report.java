package ru.grishuchkov.seleniumparser.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Report {
    private int count;
    private String date;
}
