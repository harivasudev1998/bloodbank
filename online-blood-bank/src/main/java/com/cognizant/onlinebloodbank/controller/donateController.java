package com.cognizant.onlinebloodbank.controller;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.onlinebloodbank.model.Donate;
import com.cognizant.onlinebloodbank.model.Search;
import com.cognizant.onlinebloodbank.model.User;
import com.cognizant.onlinebloodbank.repository.DonateRepository;
import com.cognizant.onlinebloodbank.repository.UserRepository;
import com.cognizant.onlinebloodbank.service.DonateService;

@RestController
@RequestMapping("/donate")
public class donateController {

	@Autowired
	DonateService donateService;
	
	@PostMapping("/{id}")
	public void addDonor(@PathVariable String id,@RequestBody @Valid Donate donate)
	{
	donateService.addDonor(id, donate);
	}
	
	@GetMapping
	public List<Donate> getAll()
	{
		return donateService.getAll();
		
	}
	
	@PostMapping
	public List<Donate> searchForDonor(@RequestBody Search search)
	{
		return donateService.searchForDonor(search);
		  
	}

	
}
