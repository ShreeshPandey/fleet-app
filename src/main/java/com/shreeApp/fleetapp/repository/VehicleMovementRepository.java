package com.shreeApp.fleetapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shreeApp.fleetapp.models.VehicleMovement;
@Repository
public interface VehicleMovementRepository extends JpaRepository<VehicleMovement, Integer> {

}
