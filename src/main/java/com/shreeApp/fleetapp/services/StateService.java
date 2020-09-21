package com.shreeApp.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shreeApp.fleetapp.models.State;
import com.shreeApp.fleetapp.repository.StateRepository;

@Service
public class StateService {
	
	@Autowired
	private StateRepository stateRepository;
	
	public List<State> getStatesList(){
		return stateRepository.findAll();
	}
	
	public void save(State state) {
		 stateRepository.save(state);
	}
	
	public Optional<State> findById(Integer id) {
		return stateRepository.findById(id);
	}
	
	public void delete(Integer id) {
		stateRepository.deleteById(id);
	}

}
