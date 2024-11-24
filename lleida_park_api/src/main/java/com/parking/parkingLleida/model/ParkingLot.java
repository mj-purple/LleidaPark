package com.parking.parkingLleida.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="parking_lot")
public class ParkingLot {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    private int id;
    @Column
    private int maxSpots;
    @Column
    private String name;
    @Column
    private int x_coordinate;
    @Column
    private int y_coordinate;

    @OneToMany(mappedBy = "parkingLot")
    private List<ParkingSpot> parkingSpots;
}
