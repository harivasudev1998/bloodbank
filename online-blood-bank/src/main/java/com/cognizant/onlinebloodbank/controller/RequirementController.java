package com.cognizant.onlinebloodbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.onlinebloodbank.model.Request;
import com.cognizant.onlinebloodbank.repository.RequestRepository;
import com.cognizant.onlinebloodbank.service.RequirementService;



@RestController
@RequestMapping("/home")
public class RequirementController {

	@Autowired
RequirementService requirementService;
	
	@GetMapping
	public List<Request> getRequirement(){
		return requirementService.getRequirement();
		
	} 
}
