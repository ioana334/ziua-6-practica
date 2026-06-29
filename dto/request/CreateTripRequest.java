package com.company.booking.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CreateTripRequest(

        @NotBlank(message = "Destination is required")
        String destination,

        @NotBlank(message = "Start date is required")
        String startDate;

        @NotBlank(message = "End date is required")
        String endDate;
        Long userId
) {}