import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { donate } from '../donate';
import { BloodbankServiceService } from 'src/bloodbank-service.service';
import { search } from 'src/search';
import { RequestlistComponent } from '../requestlist/requestlist.component';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  filteredDonor: donate;

  constructor(private formBuild:FormBuilder,private router:Router,private bloodService:BloodbankServiceService) { }
  loginSearchForm :FormGroup;

  ngOnInit() {
    this.loginSearchForm = this.formBuild.group({
      state: ['',[
        Validators.required
      ]],
      area: ['',[
        Validators.required
      ]],
      pincode:['',[Validators.required,Validators.min(100000),Validators.max(999999)]],
      bloodgroup:['',[Validators.required]],

      contactnumber:['',[Validators.required]],
    })
  }
get state()
{
  return this.loginSearchForm.get('state')
}
get area()
{
  return this.loginSearchForm.get('area');
}
get pincode()
{
  return this.loginSearchForm.get('pincode');
}
get bloodgroup()
{
  return this.loginSearchForm.get('bloodgroup');
}

get contactnumber(){
  return this.loginSearchForm.get('contactnumber');
}
requestblood()
{
  this.router.navigate(['request']);
}
donatelist:donate[];
result:boolean=false;

onSearch(){
  // let newDonor:donate={
  //   bloodgroup:this.loginSearchForm.value["bloodgroup"],
  //   state:this.loginSearchForm.value["state"],
  //   area:this.loginSearchForm.value["area"],
  //   pincode:this.loginSearchForm.value["pincode"],
  //   contactnumber:this.loginSearchForm.value["contactnumber"]

    
    
  // };
  // this.bloodService.search(newDonor).subscribe(
  //   (data)=>{
  //     this.filteredDonor=data;
  //   }
  // )
  let NewSearch:search={bloodgroup:this.loginSearchForm.value["bloodgroup"],
  state:this.loginSearchForm.value["state"],
  pincode:this.loginSearchForm.value["pincode"],
  area:this.loginSearchForm.value["area"],
  contactnumber:this.loginSearchForm.value["contactnumber"]
};
  console.log(NewSearch)
   this.bloodService.search(NewSearch).subscribe(data=>{this.donatelist=data
    console.log(data)
    // console.log(this.donatelist)
    this.bloodService.donor=this.donatelist
    this.result=true;
   this.router.navigate(['/search'])
   })

   


}

}
