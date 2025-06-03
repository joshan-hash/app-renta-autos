package com.example.app_renta_autos.model;

import com.example.app_renta_autos.dto.CarDTO;
import com.example.app_renta_autos.utils.IMapper;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_car")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car implements IMapper<CarDTO> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String model;
    private String brand;
    private String plate;
    private double fee;
    private double basePrice;
    private String owner;
    private boolean status;
    private String imageURL;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "car")
    private List<Trip> trips = new ArrayList<>();

    @Override
    public CarDTO getDto() {
        return CarDTO.builder()
                .id(id)
                .model(model)
                .brand(brand)
                .plate(plate)
                .fee(fee)
                .basePrice(basePrice)
                .owner(owner)
                .status(status)
                .imageURL(imageURL)
                .build();
    }

    @Override
    public void setData(CarDTO carDTO) {
        this.id = carDTO.getId();
        this.model = carDTO.getModel();
        this.brand = carDTO.getBrand();
        this.plate = carDTO.getPlate();
        this.fee = carDTO.getFee();
        this.basePrice = carDTO.getBasePrice();
        this.owner = carDTO.getOwner();
        this.status = carDTO.isStatus();
        this.imageURL = carDTO.getImageURL();
    }
}
