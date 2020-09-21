package com.shreeApp.fleetapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shreeApp.fleetapp.models.VehicleStatus;
@Repository
public interface VehicleStatusRepository extends JpaRepository<VehicleStatus, Integer> {

}
