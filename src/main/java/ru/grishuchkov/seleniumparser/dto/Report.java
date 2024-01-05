package ru.grishuchkov.seleniumparser.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Report {
    private String club;
    private int count;
    private String date;

    public Report(int count, String date) {
        this.count = count;
        this.date = date;
    }
}
