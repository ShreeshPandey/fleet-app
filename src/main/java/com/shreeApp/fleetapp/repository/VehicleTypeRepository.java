package com.shreeApp.fleetapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shreeApp.fleetapp.models.VehicleType;
@Repository
public interface VehicleTypeRepository extends JpaRepository<VehicleType, Integer> {

}
