import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BloodbankServiceService } from 'src/bloodbank-service.service';
import { request } from '../request';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private router:Router,private bloodservice:BloodbankServiceService) { }

  requirementList:request[];
  ngOnInit() {
    this.bloodservice.requirementList().subscribe(
      (data)=>{
        this.requirementList=data;
        console.log(data)
        console.log("hari")
      }
    )
  }
  register()
  {
    this.router.navigate(['signup'])
  }
}
