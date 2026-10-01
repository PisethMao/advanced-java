package com.piseth.datetimeformatterdemo.dto;

public record AppointmentResponse(
        String name,
        String originalInput,
        String isoDateTime,
        String normalFormat,
        String twelveHourFormat,
        String readableFormat
) {
}
