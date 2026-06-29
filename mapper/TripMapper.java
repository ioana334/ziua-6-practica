package com.company.booking.mapper;

import com.company.booking.dto.response.TripResponse;
import com.company.booking.entity.Trip;

public class TripMapper {

    public static TripResponse toResponse( Trip trip) {

        return new TripResponse(
                trip.getId(),
                trip.getDestination(),
                trip.getStartDate(),
                trip.getEndDate(),
                trip.getUsers() !=null ? trip.getUser().getId() :null
                companyId
                
        );
    }
}