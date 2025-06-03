package com.example.app_renta_autos.repository;

import com.example.app_renta_autos.model.Car;
import com.example.app_renta_autos.model.Driver;
import com.example.app_renta_autos.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TripRepository extends JpaRepository<Trip, Integer> {
}
