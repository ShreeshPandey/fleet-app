package com.shreeApp.fleetapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shreeApp.fleetapp.models.VehicleHire;
@Repository
public interface VehicleHireRepository extends JpaRepository<VehicleHire, Integer> {

}
