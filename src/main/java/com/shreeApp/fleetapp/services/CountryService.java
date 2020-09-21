package com.shreeApp.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shreeApp.fleetapp.models.Country;
import com.shreeApp.fleetapp.repository.CountryRepository;

@Service
public class CountryService {
	
	@Autowired
	private CountryRepository countryRepository;
	
	public List<Country> getCountriesList(){
		return countryRepository.findAll();
	}
	
	public void save(Country country) {
		 countryRepository.save(country);
	}
	
	public Optional<Country> findById(Integer id) {
		return countryRepository.findById(id);
	}
	
	public void delete(Integer id) {
		countryRepository.deleteById(id);
	}

}
