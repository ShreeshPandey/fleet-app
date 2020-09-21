package com.shreeApp.fleetapp.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shreeApp.fleetapp.models.State;
import com.shreeApp.fleetapp.services.CountryService;
import com.shreeApp.fleetapp.services.StateService;

@Controller
public class StateController {

	@Autowired private StateService stateService;
	@Autowired private CountryService countryService;

	@GetMapping("/states")
	public String findAll(Model model) {
		model.addAttribute("countries", countryService.getCountriesList());
		model.addAttribute("states", stateService.getStatesList());
		return "state";
	}

	@PostMapping("/states/addNew")
	public String addState(State state) {
		stateService.save(state);
		return "redirect:/states";
	}

	@RequestMapping("states/findById")
	@ResponseBody
	public Optional<State> findById(int id) {
		return stateService.findById(id);
	}

	@RequestMapping(value = "/states/update", method = { RequestMethod.PUT, RequestMethod.GET })
	// @PutMapping("/states/update")
	public String updateStateDtls(State state) {
		stateService.save(state);
		return "redirect:/states";
	}

	@RequestMapping(value = "/states/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deleteState(Integer id) {
		stateService.delete(id);
		return "redirect:/states";
	}

}
