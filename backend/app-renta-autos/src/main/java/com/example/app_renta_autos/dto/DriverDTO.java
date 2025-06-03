package com.example.app_renta_autos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DriverDTO {
    private Integer id;
    private String name;
    private String email;
    private String driversLicense;
    private boolean tripStatus;
    private Integer totalTrips;
    private String tripDetails;
    private String imageURL;
}
