package com.example.app_renta_autos.model;

import com.example.app_renta_autos.dto.CarDTO;
import com.example.app_renta_autos.dto.DriverDTO;
import com.example.app_renta_autos.dto.TripDTO;
import com.example.app_renta_autos.utils.IMapper;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalTime;

@Entity
@Table(name = "t_trip")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Trip implements IMapper<TripDTO> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime tripBegin;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime tripEnd;
    private String beginLocation;
    private Integer price;
    @ManyToOne
    Driver driver;
    @ManyToOne
    Car car;

    @Override
    public TripDTO getDto() {
        return TripDTO.builder()
                .id(id)
                .tripBegin(tripBegin)
                .tripEnd(tripEnd)
                .beginLocation(beginLocation)
                .price(price)
                .driver(DriverDTO.builder().id(driver.getId()).name(driver.getName()).build())
                .car(CarDTO.builder().id(car.getId()).model(car.getModel()).brand(car.getBrand()).status(car.isStatus()).build())
                .build();
    }

    @Override
    public void setData(TripDTO tripDTO) {
        this.id = tripDTO.getId();
        this.tripBegin = tripDTO.getTripBegin();
        this.tripEnd = tripDTO.getTripEnd();
        this.beginLocation = tripDTO.getBeginLocation();
        this.price = tripDTO.getPrice();
    }
}
