package com.parking.parkingLleida.dao;

import com.parking.parkingLleida.model.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface ParkingLotRepository extends JpaRepository<ParkingLot, Integer> {
    ArrayList<ParkingLot> findParkingLotByNameContaining(String name);
}
