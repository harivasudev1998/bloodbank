package com.cognizant.onlinebloodbank.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cognizant.onlinebloodbank.model.Donate;
import com.cognizant.onlinebloodbank.model.Search;
import com.cognizant.onlinebloodbank.model.User;
import com.cognizant.onlinebloodbank.repository.DonateRepository;
import com.cognizant.onlinebloodbank.repository.UserRepository;

@Service
public class DonateService {

	@Autowired
	DonateRepository donateRepository;
	@Autowired
	UserRepository userRepository;
	
	public void addDonor(@PathVariable String id,@RequestBody @Valid Donate donate)
	{
		User u=userRepository.findByUsername(id);
        u.setDonate(donate);	
		donate.setUserId(u);
		userRepository.save(u);
		
	}
	
	
	public List<Donate> getAll()
	{
		return donateRepository.getAll();
		
	}
	
	public List<Donate> searchForDonor(@RequestBody Search search)
	{
		  List<Donate> dl= new ArrayList<Donate>();
		  donateRepository.findAll().forEach(dl::add);
		  List<Donate> newdl=new ArrayList<Donate>();
		  List<Donate> edl=new ArrayList<Donate>();
//		  for(Donate d:dl)
//		  {
//			  Date date=new Date();
//			  long duration=date.getTime()-d.getSlotid().getDate().getTime();
//			    long days=TimeUnit.MILLISECONDS.toDays(duration);
//			    if(days>95){}
//		  }
		  for(int j=0;j<dl.size();j++){
		         if(dl.get(j).getBloodgroup().equalsIgnoreCase(search.getBloodgroup())&&
		                       dl.get(j).getState().equalsIgnoreCase(search.getState())&&
		                       dl.get(j).getArea().equalsIgnoreCase(search.getArea())&&
		                       dl.get(j).getPincode()==search.getPincode()){
		                  newdl.add(dl.get(j));
		             }
		         }
		         return newdl;
		  
	}
	
}
