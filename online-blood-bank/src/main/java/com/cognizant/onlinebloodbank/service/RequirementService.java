package com.cognizant.onlinebloodbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.onlinebloodbank.model.Request;
import com.cognizant.onlinebloodbank.repository.RequestRepository;

@Service
public class RequirementService {

	@Autowired
	 RequestRepository requestRepository;
	
	public List<Request> getRequirement(){
		return requestRepository.findAll();
		
	} 
}
