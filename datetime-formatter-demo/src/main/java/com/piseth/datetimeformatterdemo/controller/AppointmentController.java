package com.piseth.datetimeformatterdemo.controller;

import com.piseth.datetimeformatterdemo.dto.AppointmentRequest;
import com.piseth.datetimeformatterdemo.dto.AppointmentResponse;
import com.piseth.datetimeformatterdemo.service.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AppointmentResponse createAppointment(@Valid @RequestBody AppointmentRequest request) {
        return appointmentService.createAppointment(request);
    }

    @GetMapping("/format-date")
    public String formatDate(@RequestParam String date) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter outputFormatter =
                DateTimeFormatter.ofPattern(
                        "dd MMMM yyyy",
                        Locale.ENGLISH
                );
        LocalDate localDate = LocalDate.parse(date, inputFormatter);
        return localDate.format(outputFormatter);
    }

    @GetMapping("/format-time")
    public String formatTime(@RequestParam String time) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("HH:mm");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("hh:mm a");
        LocalTime localTime = LocalTime.parse(time, inputFormatter);
        return localTime.format(outputFormatter);
    }
}