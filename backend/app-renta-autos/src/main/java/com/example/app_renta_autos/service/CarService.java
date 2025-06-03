package com.example.app_renta_autos.service;

import com.example.app_renta_autos.dto.CarDTO;
import com.example.app_renta_autos.model.Car;
import com.example.app_renta_autos.repository.CarRepository;
import com.example.app_renta_autos.utils.ICrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService implements ICrud<CarDTO> {

    @Autowired
    private CarRepository carRepository;

    @Override
    public CarDTO add(CarDTO carDTO) {
        Car car = new Car();
        car.setData(carDTO);
        return this.carRepository.save(car).getDto();
    }

    @Override
    public CarDTO update(CarDTO carDTO) {
        Optional<Car> car = this.carRepository.findById(carDTO.getId());
        if (car.isEmpty()) {
            return CarDTO.builder().build();
        }
        car.get().setData(carDTO);
        return this.carRepository.save(car.get()).getDto();
    }

    @Override
    public CarDTO delete(CarDTO carDTO) {
        Optional<Car> car = this.carRepository.findById(carDTO.getId());
        if (car.isEmpty()) {
            return CarDTO.builder().build();
        }
        this.carRepository.delete(car.get());
        return car.get().getDto();
    }

    @Override
    public List<CarDTO> getAll() {
        return this.carRepository.findAll().stream().map(Car::getDto).toList();
    }

    @Override
    public CarDTO findById(Integer id) {
        Optional<Car> car = this.carRepository.findById(id);
        if (car.isEmpty()) {
            return CarDTO.builder().build();
        }
        return car.get().getDto();
    }
}
