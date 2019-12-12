package com.cognizant.onlinebloodbank;


import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.onlinebloodbank.exception.AlreadyslotException;
import com.cognizant.onlinebloodbank.exception.SlotsbookedException;
import com.cognizant.onlinebloodbank.model.Donate;
import com.cognizant.onlinebloodbank.model.Request;
import com.cognizant.onlinebloodbank.model.Slot;
import com.cognizant.onlinebloodbank.model.User;
import com.cognizant.onlinebloodbank.repository.UserRepository;
import com.cognizant.onlinebloodbank.service.AppUserDetailsService;
import com.cognizant.onlinebloodbank.service.DonateService;
import com.cognizant.onlinebloodbank.service.RequestService;
import com.cognizant.onlinebloodbank.service.RequirementService;
import com.cognizant.onlinebloodbank.service.SlotService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=OnlineBloodBankApplication.class)
public class OnlineBloodBankApplicationTests {


	
	@Autowired
	DonateService donateService;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RequestService requestService;
	
	
	@Autowired
	SlotService slotService;

    
    @Test
    public void testaddreq(){
    	
    	Request rq=new Request();
    	rq.setArea("Karnataka");
    	rq.setBloodgroup("A+ve");
    	rq.setContactnumber("8072923416");
    	rq.setPincode(560022);
    	rq.setState("Karnataka");
    	User u=userRepository.findByUsername("hari123");
    	System.out.println(rq);
    	requestService.addRequest(u.getUsername(), rq);
//    	assertEquals(u.getRequests().contains(rq), true);
    	System.out.println(u.getUsername());
        requestService.addRequest(u.getUsername(), rq);
        boolean st = false;
        for(int i=0;i<u.getRequests().size();i++){
                        if(u.getRequests().get(i).getContactnumber().equalsIgnoreCase("8072923416"))
                                        st=true;
        }
        assertEquals(st,true);
        }
    
//    @Test
//    public void testaddreq1(){
//    	
//    	Request rq=new Request();
//    	rq.setArea("Karnataka");
//    	rq.setBloodgroup("A+ve");
//    	rq.setContactnumber("8072923416");
//    	rq.setPincode(560022);
//    	rq.setState("Karnataka");
//    	User u=userRepository.findByUsername("hari123");
//    	System.out.println(rq);
//    	requestService.addRequest(u.getUsername(), rq);
////    	assertEquals(u.getRequests().contains(rq), true);
//    	System.out.println(u.getUsername());
//        requestService.addRequest(u.getUsername(), rq);
//        boolean st = false;
//        for(int i=0;i<u.getRequests().size();i++){
//                        if(u.getRequests().get(i).getContactnumber().equalsIgnoreCase("111111111"))
//                                        st=true;
//        }
//        assertEquals(st,true);
//        }

    @Test
    public void testdonor(){
                    Donate dt= new Donate();
                    dt.setArea("Karnataka");
                    dt.setBloodgroup("A+ve");
                    dt.setContactnumber("9449041966");
                    dt.setState("Karnataka");
                    dt.setPincode(560022);
                    donateService.addDonor("harry100", dt);
                    User u=userRepository.findByUsername("harry100");
                    assertEquals(u.getDonate().getBloodgroup(),"A+ve");
    }
    
//    @Test
//    public void testdonor1(){
//                    Donate dt= new Donate();
//                    dt.setArea("Karnataka");
//                    dt.setBloodgroup("A+ve");
//                    dt.setContactnumber("9449041966");
//                    dt.setState("Karnataka");
//                    dt.setPincode(560022);
//                    donateService.addDonor("harry100", dt);
//                    User u=userRepository.findByUsername("hari101");
//                    assertEquals(u.getDonate().getBloodgroup(),"A+ve");
//    }
    
//    @Test
//    public void testslot() throws SlotsbookedException{
//         Slot s=new Slot();
//         s.setCity("Blr");
//         s.setHospital("CA");
//         s.setTime("10-11AM");
//         String str="2019-12-02";
//         Date d= Date.valueOf(str);
//         s.setDate(d);
////       User u=urepository.findByUsername("harry100");
//             
////       boolean st=false;
////       if(u.getDonor().getSlot()!=null)
////           st=true;
//         try {
//             slotService.slotbooking("harry100", s);
//             fail();
//         } catch (SlotsbookedException e) {
//             // TODO Auto-generated catch block
//             String expected="Slot already booked";
//             assertEquals(expected,e.getMessage());
//         }
//    }


    }




