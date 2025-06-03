package com.example.app_renta_autos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO {
    private Integer id;
    private String model;
    private String brand;
    private String plate;
    private double fee;
    private double basePrice;
    private String owner;
    private boolean status;
    private String imageURL;
}
