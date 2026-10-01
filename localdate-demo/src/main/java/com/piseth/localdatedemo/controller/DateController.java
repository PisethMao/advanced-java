package com.piseth.localdatedemo.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Map;

@RestController
@RequestMapping("/api/dates")
public class DateController {
    @GetMapping("/today")
    public LocalDate today() {
        return LocalDate.now();
    }

    @GetMapping("/info")
    public Map<String, Object> getDateInfo(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate date
    ) {
        return Map.of(
                "date", date,
                "year", date.getYear(),
                "month", date.getMonth(),
                "monthValue", date.getMonthValue(),
                "dayOfMonth", date.getDayOfMonth(),
                "dayOfWeek", date.getDayOfWeek(),
                "dayOfYear", date.getDayOfYear()
        );
    }

    @GetMapping("/add-days")
    public Map<String, Object> addDays(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate date,
            @RequestParam
            long days
    ) {
        LocalDate result = date.plusDays(days);
        return Map.of("originalDate", date, "daysAdded", days, "result", result);
    }

    @GetMapping("/days-between")
    public Map<String, Object> daysBetween(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate from,
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate to
    ) {
        long days = ChronoUnit.DAYS.between(from, to);
        return Map.of("from", from, "to", to, "days", days);
    }

    @GetMapping("/period")
    public Map<String, Object> period(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate from,
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate to
    ) {
        Period period = Period.between(from, to);
        return Map.of(
                "from", from,
                "to", to,
                "years", period.getYears(),
                "months", period.getMonths(),
                "days", period.getDays()
        );
    }

    @GetMapping("/compare")
    public Map<String, Object> compare(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate first,
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate second
    ) {
        return Map.of(
                "first", first,
                "second", second,
                "firstIsBefore", first.isBefore(second),
                "firstIsAfter", first.isAfter(second),
                "sameDate", first.isEqual(second)
        );
    }
}