package com.parking.parkingLleida.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="parking_spot")
public class ParkingSpot {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    private int id;
    @Column
    private boolean isOccupied;
    @Column
    private int x_coordinate;
    @Column
    private int y_coordinate;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="lot_id", nullable=false)
    private ParkingLot parkingLot;
}
