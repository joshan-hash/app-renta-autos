package com.example.app_renta_autos.controller;

import com.example.app_renta_autos.dto.DriverDTO;
import com.example.app_renta_autos.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverRESTController {

    @Autowired
    DriverService driverService;

    @GetMapping
    public List<DriverDTO> getAllDrivers() {
        return this.driverService.getAll();
    }

    @GetMapping("/{id}")
    public DriverDTO getDriverById(@PathVariable Integer id) {
        return this.driverService.findById(id);
    }

    @PostMapping
    public DriverDTO addDriver(@RequestBody DriverDTO driverDTO) {
        return this.driverService.add(driverDTO);
    }

    @PutMapping
    public DriverDTO updateDriver(@RequestBody DriverDTO driverDTO) {
        return this.driverService.update(driverDTO);
    }

    @DeleteMapping
    public DriverDTO deleteDriver(@RequestBody DriverDTO driverDTO) {
        return this.driverService.delete(driverDTO);
    }

}
