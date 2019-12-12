import { Component, OnInit, Input } from '@angular/core';
import { donate } from '../donate';
import { BloodbankServiceService } from 'src/bloodbank-service.service';

@Component({
  selector: 'app-requestlist',
  templateUrl: './requestlist.component.html',
  styleUrls: ['./requestlist.component.css']
})
export class RequestlistComponent implements OnInit {

  constructor(private bloodservice:BloodbankServiceService) { }
donatelist:donate[];
  ngOnInit() {
    this.donatelist=this.bloodservice.donor;
    console.log(this.donatelist);
  }

  
}
