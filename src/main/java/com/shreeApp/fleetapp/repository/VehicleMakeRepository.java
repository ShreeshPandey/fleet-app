package com.shreeApp.fleetapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shreeApp.fleetapp.models.VehicleMake;
@Repository
public interface VehicleMakeRepository extends JpaRepository<VehicleMake, Integer> {

}
