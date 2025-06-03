package com.example.app_renta_autos.service;

import com.example.app_renta_autos.dto.DriverDTO;
import com.example.app_renta_autos.model.Driver;
import com.example.app_renta_autos.repository.DriverRepository;
import com.example.app_renta_autos.utils.ICrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DriverService implements ICrud<DriverDTO> {

    @Autowired
    private DriverRepository driverRepository;

    @Override
    public DriverDTO add(DriverDTO driverDTO) {
        Driver driver = new Driver();
        driver.setData(driverDTO);
        return this.driverRepository.save(driver).getDto();
    }

    @Override
    public DriverDTO update(DriverDTO driverDTO) {
        Optional<Driver> driver = driverRepository.findById(driverDTO.getId());
        if (driver.isEmpty()) {
            return DriverDTO.builder().build();
        }
        driver.get().setData(driverDTO);
        return this.driverRepository.save(driver.get()).getDto();
    }

    @Override
    public DriverDTO delete(DriverDTO driverDTO) {
        Optional<Driver> driver = driverRepository.findById(driverDTO.getId());
        if (driver.isEmpty()) {
            return DriverDTO.builder().build();
        }
        driverRepository.deleteById(driverDTO.getId());
        return driver.get().getDto();
    }

    @Override
    public List<DriverDTO> getAll() {
        return this.driverRepository.findAll().stream().map(Driver::getDto).toList();
    }

    @Override
    public DriverDTO findById(Integer id) {
        Optional<Driver> driver = driverRepository.findById(id);
        if (driver.isEmpty()) {
            return DriverDTO.builder().id(id).build();
        }
        return driver.get().getDto();
    }
}
