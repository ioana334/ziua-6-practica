package com.company.booking.service;

import com.company.booking.dto.request.CreateTripRequest;
import com.company.booking.dto.request.UpdateTripRequest;
import com.company.booking.dto.response.Tripesponse;
import com.company.booking.entity.AppUser;
import com.company.booking.entity.Trip;
import com.company.booking.exception.ResourceNotFoundException;
import com.company.booking.mapper.TripMapper;
import com.company.booking.repository.TripRepository;
import com.company.booking.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {

    private final TripRepository tripRepository;
    private final UserRepository userRepository;

    public TripService createTrip(CreateTripRequest request) {

        AppUser user=userRepository.findById(request.userId())
         .orElseThrowe  (()->new ResourceFoundException("User not found"));

        Trip trip= new Trip();
        trip.setDestionation(request.destination());
        trip.setStartDate(request.startDate());
        trip.setEndDate(request.endDate());
        trip.setStatus("PENDING");
        trip.SetUsers(user);

        Trip saved = tripRepository.save(trip);
        return TripMapper.toResponse(saved);
    }

    public List<Tripesponse>getAllTrips(){

        return tripRepository.findAll()
               .stream()
               .map(TripMapper::toResponse)
               .toList();
    }
    

    public Tripesponse getTripById(Long id){

            Trip trip=tripRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Trip not found"))
                return TripMapper.toResponse(trip);
            
    }
    public Tripesponse UpdateTrip(Long id.UpdateTripRequest request){

            Trip trip=tripRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Trip not found"))

                trip.setDestionation(request.destination());
                trip.setStartDate(request.startDate());
                trip.setEndDate(request.endDate());

                  Trip saved = tripRepository.save(trip);
                  return TripMapper.toResponse(saved); 
            
    }
    public void deleteTrip(Long id){
        Trip trip=tripRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Trip not found"))
                tripRepository.delete(trip);
    }

    public Tripesponse approveTrip(Long id){
        Trip trip=tripRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Trip not found"))
                trip.setStatus("APPROVED");
                Trip saved=tripRepository.save(trip)
                return TripMapper.toResponse(saved); 
    }
    public Tripesponse rejectTrip(Long id){
         Trip trip=tripRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Trip not found"))
                trip.setStatus("REJECTED");
                Trip saved=tripRepository.save(trip)
                return TripMapper.toResponse(saved); 
    }
    public List<TripResponse> getTripsByUser(Long userId) {
    return tripRepository.findByUserId(userId)
            .stream()
            .map(TripMapper::toResponse)
            .toList();
}

public List<TripResponse> getTripsByStatus(String status) {
    return tripRepository.findByStatus(status.toUpperCase())
            .stream()
            .map(TripMapper::toResponse)
            .toList();
}

public List<TripResponse> getTripsByDestination(String destination) {
    return tripRepository.findByDestinationContainingIgnoreCase(destination)
            .stream()
            .map(TripMapper::toResponse)
            .toList();
}

public List<TripResponse> getTripsByDateRange(String start, String end) {
    return tripRepository.findByStartDateBetween(start, end)
            .stream()
            .map(TripMapper::toResponse)
            .toList();
}
}