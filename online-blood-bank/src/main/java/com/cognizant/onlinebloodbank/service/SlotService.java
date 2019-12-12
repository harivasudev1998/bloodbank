package com.cognizant.onlinebloodbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cognizant.onlinebloodbank.exception.SlotsbookedException;
import com.cognizant.onlinebloodbank.model.Donate;
import com.cognizant.onlinebloodbank.model.Slot;
import com.cognizant.onlinebloodbank.repository.DonateRepository;
import com.cognizant.onlinebloodbank.repository.SlotRepository;
import com.cognizant.onlinebloodbank.repository.UserRepository;

@Service
public class SlotService {
	

	@Autowired
	SlotRepository slotRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired 
	DonateRepository donateRepository;
	
	
	public List<Slot> getAll()
	{
		return slotRepository.findAll();
	}
	
	public void slotbooking(@PathVariable String id,@RequestBody Slot slot) throws SlotsbookedException
	{
		List<Slot> slots=slotRepository.findAll();
		
		for(Slot s:slots)
		{
			if(slot.getDate().compareTo(s.getDate())==0 && slot.getCity().equalsIgnoreCase(s.getCity())
					&& slot.getHospital().equalsIgnoreCase(s.getHospital())
					&& slot.getTime().equalsIgnoreCase(s.getTime()))
					{
				    throw new SlotsbookedException();
					}
			
		}
		Donate d=userRepository.findByUsername(id).getDonate();
	    slot.setSo_id(d.getDo_id());
		d.setSlotid(slot);
	   donateRepository.save(d);
	    //slotRepository.save(slot);
	}

}
