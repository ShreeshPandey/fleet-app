package com.shreeApp.fleetapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shreeApp.fleetapp.models.JobTitle;
@Repository
public interface JobTitleRepository extends JpaRepository<JobTitle, Integer> {

}
