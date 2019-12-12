import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Hospital } from '../hospital';
import { BloodbankServiceService } from 'src/bloodbank-service.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-hospital',
  templateUrl: './hospital.component.html',
  styleUrls: ['./hospital.component.css']
})
export class HospitalComponent implements OnInit {

  hospitalForm:FormGroup;

  constructor(private formBuilder:FormBuilder,private bloodService:BloodbankServiceService,private router:Router) { }

  ngOnInit() {

    this.hospitalForm = this.formBuilder.group({
     
      hospital:['',[
        Validators.required
      ]],
      city:['',[
        Validators.required
      ]],
      date:['',[
        Validators.required
      ]],
      time:['',[
        Validators.required
      ]]
    })
    
  }
 
  get hospital() {
    return this.hospitalForm.get('hospital');
  }
  get city() {
    return this.hospitalForm.get('city');
  }
  get date() {
    return this.hospitalForm.get('date');
  }
  get time() {
    return this.hospitalForm.get('time');
  }

  hospitalSelect(){

   let NewSlot:Hospital={hospital:this.hospitalForm.value["hospital"],
   city:this.hospitalForm.value["city"],
   date:this.hospitalForm.value["date"],
   time:this.hospitalForm.value["time"]};
    this.bloodService.addHospital(NewSlot).subscribe(data=>{this.router.navigate(['search'])})

  }
  }


