package com.example.app_renta_autos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TripDTO {
    private Integer id;
    private LocalTime tripBegin;
    private LocalTime tripEnd;
    private String beginLocation;
    private Integer price;
    private DriverDTO driver;
    private CarDTO car;
}
