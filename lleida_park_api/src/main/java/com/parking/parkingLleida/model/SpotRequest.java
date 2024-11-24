package com.parking.parkingLleida.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpotRequest {
    private int id;
    @JsonProperty("isOccupied")
    private boolean isOccupied;
}
