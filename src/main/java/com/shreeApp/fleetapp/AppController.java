package com.shreeApp.fleetapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

	@GetMapping("/index")
	public String goHome() {
		return "index";
	}
	
	@GetMapping("/blank")
	public String getBlank() {
		return "blank";
	}
}
