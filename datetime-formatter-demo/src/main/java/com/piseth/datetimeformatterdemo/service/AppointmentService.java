package com.piseth.datetimeformatterdemo.service;

import com.piseth.datetimeformatterdemo.dto.AppointmentRequest;
import com.piseth.datetimeformatterdemo.dto.AppointmentResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Service
public class AppointmentService {
    private static final DateTimeFormatter INPUT_FORMATTER =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private static final DateTimeFormatter NORMAL_FORMATTER =
            DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    private static final DateTimeFormatter TWELVE_HOUR_FORMATTER =
            DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm a");
    private static final DateTimeFormatter READABLE_FORMATTER =
            DateTimeFormatter.ofPattern(
                    "EEEE, dd MMMM yyyy 'at' hh:mm a",
                    Locale.ENGLISH
            );

    public AppointmentResponse createAppointment(AppointmentRequest request) {
        LocalDateTime appointmentDateTime =
                LocalDateTime.parse(
                        request.appointmentDateTime(), INPUT_FORMATTER
                );
        String isoDateTime = appointmentDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        String normalFormat = appointmentDateTime.format(NORMAL_FORMATTER);
        String twelveHourFormat = appointmentDateTime.format(TWELVE_HOUR_FORMATTER);
        String readableFormat = appointmentDateTime.format(READABLE_FORMATTER);
        return new AppointmentResponse(
                request.name(),
                request.appointmentDateTime(),
                isoDateTime,
                normalFormat,
                twelveHourFormat,
                readableFormat
        );
    }
}
