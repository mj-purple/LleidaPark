package com.parking.parkingLleida.service;

import com.parking.parkingLleida.dao.ParkingSpotRepository;
import com.parking.parkingLleida.model.ParkingSpot;
import com.parking.parkingLleida.model.SpotRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ParkingSpotService {
    @Autowired
    private ParkingSpotRepository parkingSpotRepository;
    public ResponseEntity getParkingSpotById(int id) {
        try {
            ParkingSpot parkingSpot = parkingSpotRepository.findById(id).get();
            return ResponseEntity.status(HttpStatus.OK).body(parkingSpot);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    public ResponseEntity updateParkingSpotStatus(SpotRequest spotRequest) {
        try {
            ParkingSpot parkingSpot = parkingSpotRepository.findById(spotRequest.getId()).get();
            parkingSpot.setOccupied(spotRequest.isOccupied());
            parkingSpotRepository.save(parkingSpot);
            return ResponseEntity.status(HttpStatus.OK).body(parkingSpot);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
