package com.parking.parkingLleida.api;

import com.parking.parkingLleida.model.SpotRequest;
import com.parking.parkingLleida.service.ParkingSpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ParkingSpotController {
    @Autowired
    private ParkingSpotService parkingSpotService;

    @GetMapping("/spot/{id}")
    private ResponseEntity getParkingSpot(@PathVariable("id") int id) {
        return this.parkingSpotService.getParkingSpotById(id);
    }

    @PutMapping("/spot")
    private ResponseEntity putParkingSpot(@RequestBody SpotRequest spotRequest) {
        return this.parkingSpotService.updateParkingSpotStatus(spotRequest);
    }
}
