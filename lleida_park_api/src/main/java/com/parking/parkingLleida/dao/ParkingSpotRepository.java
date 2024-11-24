package com.parking.parkingLleida.dao;

import com.parking.parkingLleida.model.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, Integer> {
    ArrayList<ParkingSpot> findByIdAndIsOccupied(int id, boolean isOccupied);
}
