package com.parking.parkingLleida.api;

import com.parking.parkingLleida.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class ParkingLotController {
    @Autowired
    private ParkingLotService parkingLotService;

    @GetMapping("/lot")
    private ResponseEntity getAllParkingLots() {
        return this.parkingLotService.getAllParkingLots();
    }

    @GetMapping("/lot/{id}")
    private ResponseEntity getParkingLot(@PathVariable("id") int id) {
        return this.parkingLotService.getParkingLotById(id);
    }

    @GetMapping("/lot/{id}/freeSpots")
    private ResponseEntity getParkingLotFreeSpots(@PathVariable("id") int id) {
        return this.parkingLotService.getParkingLotFreeSpots(id);
    }

    @GetMapping("/lot/{id}/occupiedSpots")
    private ResponseEntity getParkingLotOccupiedSpots(@PathVariable("id") int id) {
        return this.parkingLotService.getParkingLotOccupiedSpots(id);
    }

    @GetMapping("/lots")
    private ResponseEntity getParkingLotByName(@RequestParam String name) {
        return this.parkingLotService.getParkingLotsByName(name);
    }
}
