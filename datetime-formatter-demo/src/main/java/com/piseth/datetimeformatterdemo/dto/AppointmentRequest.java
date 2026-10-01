package com.piseth.datetimeformatterdemo.dto;

import jakarta.validation.constraints.NotBlank;

public record AppointmentRequest(
        @NotBlank(message = "Appointment name is required")
        String name,
        @NotBlank(message = "Appointment date/time is required")
        String appointmentDateTime
) {
}
