package com.shreeApp.fleetapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shreeApp.fleetapp.models.Vehicle;
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

}
