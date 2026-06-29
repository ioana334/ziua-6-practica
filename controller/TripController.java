package com.company.booking.controller;

import com.company.booking.dto.request.CreateTripRequest;
import com.company.booking.dto.request.UpdateTripRequest;
import com.company.booking.dto.response.TripResponse;
import com.company.booking.service.TripService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trips")
public class TripController {

    private final TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @PostMapping
    public ResponseEntity<TripResponse> createTrip(@Valid @RequestBody CreateTripRequest request) {
        return ResponseEntity.ok(tripService.createTrip(request));
    }

    @GetMapping
    public ResponseEntity<List<TripResponse>> getAllTrips() {
        return ResponseEntity.ok(tripService.getAllTrips());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TripResponse> getTripById(@PathVariable Long id) {
        return ResponseEntity.ok(tripService.getTripById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TripResponse> updateTrip(@PathVariable Long id,
                                                   @Valid @RequestBody UpdateTripRequest request) {
        return ResponseEntity.ok(tripService.updateTrip(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrip(@PathVariable Long id) {
        tripService.deleteTrip(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/approve")
    public ResponseEntity<TripResponse> approveTrip(@PathVariable Long id) {
        return ResponseEntity.ok(tripService.approveTrip(id));
    }

    @PostMapping("/{id}/reject")
    public ResponseEntity<TripResponse> rejectTrip(@PathVariable Long id) {
        return ResponseEntity.ok(tripService.rejectTrip(id));
    }
    @GetMapping("/user/{userId}")
public ResponseEntity<List<TripResponse>> getTripsByUser(@PathVariable Long userId) {
    return ResponseEntity.ok(tripService.getTripsByUser(userId));
}

@GetMapping("/status/{status}")
public ResponseEntity<List<TripResponse>> getTripsByStatus(@PathVariable String status) {
    return ResponseEntity.ok(tripService.getTripsByStatus(status));
}

@GetMapping("/destination/{destination}")
public ResponseEntity<List<TripResponse>> getTripsByDestination(@PathVariable String destination) {
    return ResponseEntity.ok(tripService.getTripsByDestination(destination));
}

@GetMapping("/dates")
public ResponseEntity<List<TripResponse>> getTripsByDateRange(
        @RequestParam String start,
        @RequestParam String end
) {
    return ResponseEntity.ok(tripService.getTripsByDateRange(start, end));
}
}