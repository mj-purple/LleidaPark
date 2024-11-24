package com.parking.parkingLleida.service;

import com.parking.parkingLleida.dao.ParkingLotRepository;
import com.parking.parkingLleida.dao.ParkingSpotRepository;
import com.parking.parkingLleida.model.ParkingLot;
import com.parking.parkingLleida.model.ParkingSpot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ParkingLotService {
    @Autowired
    private ParkingLotRepository parkingLotRepository;
    @Autowired
    private ParkingSpotRepository parkingSpotRepository;

    public ResponseEntity getAllParkingLots() {
        List<ParkingLot> parkingLots = parkingLotRepository.findAll();
        if(parkingLots == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        if(parkingLots.size() == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(parkingLots);
    }

    public ResponseEntity getParkingLotById(int id) {
        try {
            ParkingLot parkingLot = parkingLotRepository.findById(id).get();
            return ResponseEntity.status(HttpStatus.OK).body(parkingLot);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    public ResponseEntity getParkingLotsByName(String name) {
        try {
            List<ParkingLot> parkingLots = parkingLotRepository.findParkingLotByNameContaining(name);
            return ResponseEntity.status(HttpStatus.OK).body(parkingLots);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    public ResponseEntity getParkingLotFreeSpots(int id) {
        try {
            int freeSpots = parkingSpotRepository.findByIdAndIsOccupied(id, false).size();
            return ResponseEntity.status(HttpStatus.OK).body(freeSpots);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    public ResponseEntity getParkingLotOccupiedSpots(int id) {
        try {
            int freeSpots = parkingSpotRepository.findByIdAndIsOccupied(id, true).size();
            return ResponseEntity.status(HttpStatus.OK).body(freeSpots);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
