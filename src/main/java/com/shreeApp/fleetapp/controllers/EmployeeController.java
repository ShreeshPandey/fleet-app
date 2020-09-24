package com.shreeApp.fleetapp.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.shreeApp.fleetapp.models.Employee;
import com.shreeApp.fleetapp.services.CountryService;
import com.shreeApp.fleetapp.services.EmployeeService;
import com.shreeApp.fleetapp.services.EmployeeTypeService;
import com.shreeApp.fleetapp.services.JobTitleService;
import com.shreeApp.fleetapp.services.StateService;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@Controller
public class EmployeeController {

	private static final String FILE_UPLOADED_SUCCESSFULLY = "File uploaded successfully";
	@Autowired private EmployeeService employeeService;
	@Autowired private StateService stateService;	
	@Autowired private JobTitleService jobTitleService;	
	@Autowired private EmployeeTypeService employeeTypeService;
	@Autowired private CountryService countryService;
	
	//Get All Employees
	@GetMapping("employees")
	public String findAll(Model model){
		model.addAttribute("countries", countryService.getCountriesList());
		model.addAttribute("states", stateService.getStatesList());
		model.addAttribute("employees", employeeService.findAll());
		model.addAttribute("jobTitles", jobTitleService.findAll());
		model.addAttribute("employeeTypes", employeeTypeService.findAll());
		
		return "employee";
	}	
	
	@RequestMapping("employees/findById") 
	@ResponseBody
	public Optional<Employee> findById(Integer id)
	{
		return employeeService.findById(id);
	}
	
	//Add Employee
	@PostMapping(value="employees/addNew")
	public String addNew(Employee employee) {
		employeeService.save(employee);
		return "redirect:/employees";
	}	
	
	@RequestMapping(value="employees/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Employee employee) {
		employeeService.save(employee);	
		return "redirect:/employees";
	}
	
	@RequestMapping(value="employees/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(Integer id) {
		employeeService.delete(id);
		return "redirect:/employees";
	}	
	
	
	@RequestMapping(value="/employees/uploadPhoto", method=RequestMethod.POST, consumes=MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
		File newFile = new File("D:\\SOLUTIONS\\fleetms\\uploads" + file.getOriginalFilename());
		newFile.createNewFile();
		FileOutputStream fout = new FileOutputStream(newFile);
		fout.write(file.getBytes());
		fout.close();
		return new ResponseEntity<>(FILE_UPLOADED_SUCCESSFULLY, HttpStatus.OK);
	}	
	
	
	@PostMapping("/employees/uploadPhoto2")
	public String uploadFile2(@RequestParam("file") MultipartFile file, Principal principal) 
			throws IllegalStateException, IOException {
			String baseDirectory = "D:\\SOLUTIONS\\fleetms\\src\\main\\resources\\static\\img\\photos\\" ;
			file.transferTo(new File(baseDirectory + principal.getName() + ".jpg"));
			return "redirect:/employees";
	}
	
	
	@RequestMapping(value="/employees/profile")
	public String profile(Model model, Principal principal) {
		String un = principal.getName();
		model.addAttribute("employee", employeeService.findByUsername(un));
		return "profile";
	}

}
