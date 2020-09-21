package com.shreeApp.fleetapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shreeApp.fleetapp.models.Country;
@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

}
