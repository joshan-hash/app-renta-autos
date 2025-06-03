package com.example.app_renta_autos.controller;

import com.example.app_renta_autos.dto.CarDTO;
import com.example.app_renta_autos.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarRESTController {

    @Autowired
    private CarService carService;

    @GetMapping
    public List<CarDTO> getAllCars() {
        return this.carService.getAll();
    }

    @GetMapping("/{id}")
    public CarDTO getCarById(@PathVariable Integer id) {
        return this.carService.findById(id);
    }

    @PostMapping
    public CarDTO createCar(@RequestBody CarDTO carDTO) {
        return this.carService.add(carDTO);
    }

    @PutMapping
    public CarDTO updateCar(@RequestBody CarDTO carDTO) {
        return this.carService.update(carDTO);
    }

    @DeleteMapping
    public CarDTO deleteCar(@RequestBody CarDTO carDTO) {
        return this.carService.delete(carDTO);
    }
}
