package com.example.app_renta_autos.service;

import com.example.app_renta_autos.dto.TripDTO;
import com.example.app_renta_autos.model.Car;
import com.example.app_renta_autos.model.Driver;
import com.example.app_renta_autos.model.Trip;
import com.example.app_renta_autos.repository.CarRepository;
import com.example.app_renta_autos.repository.DriverRepository;
import com.example.app_renta_autos.repository.TripRepository;
import com.example.app_renta_autos.utils.ICrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripService implements ICrud<TripDTO> {

    @Autowired
    private TripRepository tripRepository;
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private CarRepository carRepository;

    @Override
    public TripDTO add(TripDTO tripDTO) {
        Optional<Driver> driver = this.driverRepository.findById(tripDTO.getDriver().getId());
        Optional<Car> car = this.carRepository.findById(tripDTO.getCar().getId());

        if (driver.isEmpty()) return TripDTO.builder().build();
        if (car.isEmpty()) return TripDTO.builder().build();
        if (!car.get().isStatus()) return TripDTO.builder().build();
        if (!driver.get().isTripStatus()) return TripDTO.builder().build();

        Trip trip = new Trip();
        trip.setDriver(driver.get());
        trip.setCar(car.get());
        trip.setData(tripDTO);

        driver.get().setTripStatus(false);
        car.get().setStatus(false);

        this.driverRepository.save(driver.get());
        this.carRepository.save(car.get());

        return this.tripRepository.save(trip).getDto();
    }

    public TripDTO updateStatus(TripDTO tripDTO) {
        Optional<Trip> trip = this.tripRepository.findById(tripDTO.getId());

        if (trip.isEmpty()) return TripDTO.builder().build();

        trip.get().getCar().setStatus(true);
        trip.get().getDriver().setTripStatus(true);

        this.driverRepository.save(trip.get().getDriver());
        this.carRepository.save(trip.get().getCar());

        return this.tripRepository.save(trip.get()).getDto();
    }

    @Override
    public TripDTO update(TripDTO tripDTO) {
        Optional<Trip> trip = this.tripRepository.findById(tripDTO.getId());
        if (trip.isEmpty()) {
            return TripDTO.builder().build();
        }
        trip.get().setData(tripDTO);
        return this.tripRepository.save(trip.get()).getDto();
    }

    @Override
    public TripDTO delete(TripDTO tripDTO) {
        Optional<Trip> trip = this.tripRepository.findById(tripDTO.getId());
        if (trip.isEmpty()) {
            return TripDTO.builder().build();
        }
        this.tripRepository.delete(trip.get());
        return trip.get().getDto();
    }

    @Override
    public List<TripDTO> getAll() {
        return this.tripRepository.findAll().stream().map(Trip::getDto).toList();
    }

    @Override
    public TripDTO findById(Integer id) {
        Optional<Trip> trip = tripRepository.findById(id);
        if (trip.isEmpty()) {
            return TripDTO.builder().build();
        }
        return trip.get().getDto();
    }
}
