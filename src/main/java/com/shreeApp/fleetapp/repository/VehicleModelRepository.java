package com.shreeApp.fleetapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shreeApp.fleetapp.models.VehicleModel;
@Repository
public interface VehicleModelRepository extends JpaRepository<VehicleModel, Integer> {

}
