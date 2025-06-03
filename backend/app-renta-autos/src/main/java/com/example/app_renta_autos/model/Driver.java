package com.example.app_renta_autos.model;

import com.example.app_renta_autos.dto.DriverDTO;
import com.example.app_renta_autos.utils.IMapper;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_driver")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Driver implements IMapper<DriverDTO> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String driversLicense;
    private boolean tripStatus;
    private Integer totalTrips;
    private String tripDetails;
    private String imageURL;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "driver")
    private List<Trip> trips = new ArrayList<>();

    @Override
    public DriverDTO getDto() {
        return DriverDTO.builder()
                .id(id)
                .name(name)
                .email(email)
                .driversLicense(driversLicense)
                .tripStatus(tripStatus)
                .totalTrips(totalTrips)
                .tripDetails(tripDetails)
                .imageURL(imageURL)
                .build();
    }

    @Override
    public void setData(DriverDTO driverDTO) {
        this.id = driverDTO.getId();
        this.name = driverDTO.getName();
        this.email = driverDTO.getEmail();
        this.driversLicense = driverDTO.getDriversLicense();
        this.tripStatus = driverDTO.isTripStatus();
        this.totalTrips = driverDTO.getTotalTrips();
        this.tripDetails = driverDTO.getTripDetails();
        this.imageURL = driverDTO.getImageURL();
    }
}
