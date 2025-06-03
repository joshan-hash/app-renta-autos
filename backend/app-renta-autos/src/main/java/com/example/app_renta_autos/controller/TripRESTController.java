package com.example.app_renta_autos.controller;

import com.example.app_renta_autos.dto.TripDTO;
import com.example.app_renta_autos.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trips")
public class TripRESTController {

    @Autowired
    TripService tripService;

    @GetMapping
    public List<TripDTO> getAllTrips() {
        return this.tripService.getAll();
    }

    @GetMapping("/{id}")
    public TripDTO getTripById(@PathVariable Integer id) {
        return this.tripService.findById(id);
    }

    @PostMapping
    public TripDTO createTrip(@RequestBody TripDTO tripDTO) {
        return this.tripService.add(tripDTO);
    }

    @PutMapping
    public TripDTO updateTrip(@RequestBody TripDTO tripDTO) {
        return this.tripService.update(tripDTO);
    }

    @DeleteMapping
    public void deleteTrip(@RequestBody TripDTO tripDTO) {
        this.tripService.delete(tripDTO);
    }

    @PutMapping("/update-status")
    public TripDTO updateStatus(@RequestBody TripDTO tripDTO) {
        return this.tripService.updateStatus(tripDTO);
    }
}
