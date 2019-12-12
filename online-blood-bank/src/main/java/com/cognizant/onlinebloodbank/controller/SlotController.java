package com.cognizant.onlinebloodbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.onlinebloodbank.exception.SlotsbookedException;
import com.cognizant.onlinebloodbank.model.Donate;
import com.cognizant.onlinebloodbank.model.Slot;
import com.cognizant.onlinebloodbank.repository.DonateRepository;
import com.cognizant.onlinebloodbank.repository.SlotRepository;
import com.cognizant.onlinebloodbank.repository.UserRepository;
import com.cognizant.onlinebloodbank.service.SlotService;

@RestController
@RequestMapping("/hospital")
public class SlotController {

//	@Autowired
//	SlotRepository slotRepository;
	@Autowired
	SlotService slotService;
//@Autowired 
//DonateRepository donateRepository;
//@Autowired
//UserRepository userRepository;
@GetMapping
public List<Slot> getAll()
{
	return slotService.getAll();
}
	@PostMapping("/{id}")
	public void slotbooking(@PathVariable String id,@RequestBody Slot slot) throws SlotsbookedException
	{
		 slotService.slotbooking(id, slot);
		
	}
}
