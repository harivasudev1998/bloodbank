import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthServiceService } from './app/auth-service.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { user } from './app/user';
import { environment } from './environments/environment';
import { request } from './app/request';
import { donate } from './app/donate';
import { Hospital } from './app/hospital';
import { search } from './search';


@Injectable({
  providedIn: 'root'
})
export class BloodbankServiceService {
userdata:user;
isLoggedIn=false;
donor:donate[];
  constructor(private router:Router,private httpClient: HttpClient,private authservice:AuthServiceService)
   {



    }
    /*getdonor():Observable<any>
    {
      if(this.authservice.loggedIn)
    {
      this.isLoggedIn=true;
      const headers = new HttpHeaders({Authorization: 'Bearer ' +this.authservice.accessToken});
      return this.httpClient.get<user>(environment.baseUrl+"/donate",{headers})
    }
    }*/
    requestForBlood(req:request):Observable<request>
  {
    const headers = new HttpHeaders({Authorization: 'Bearer ' +this.authservice.accessToken});
   return this.httpClient.post<request>(environment.baseUrl+'/online-blood-bank/request'+'/'+this.authservice.loggedInUser,req,{headers});
  }

  addDonor(newDonor:donate):Observable<any>{
    let headers=new HttpHeaders();
    headers = new HttpHeaders({Authorization: 'Bearer ' +this.authservice.accessToken});
    return this.httpClient.post<donate>(environment.baseUrl+'/online-blood-bank/donate'+'/'+this.authservice.loggedInUser,newDonor,{headers});

  }

  addHospital(newHospital:Hospital):Observable<Hospital>{
    let headers=new HttpHeaders();
    headers = new HttpHeaders({Authorization: 'Bearer ' +this.authservice.accessToken});
    return this.httpClient.post<Hospital>(environment.baseUrl+'/online-blood-bank/hospital'+'/'+this.authservice.loggedInUser,newHospital,{headers});

  }

  search(newDonor:search):Observable<any>{
    let headers=new HttpHeaders();
    headers = new HttpHeaders({Authorization: 'Bearer ' +this.authservice.accessToken});
    return this.httpClient.post<donate[]>("http://localhost:8092/online-blood-bank/donate",newDonor,{headers});

  }

  requirementList():Observable<any>
  {
    
   return this.httpClient.get<request[]>(environment.baseUrl+'/online-blood-bank/home');
  }


  // searchBlood(se:search1):Observable<any>
  // {
  //   const headers = new HttpHeaders({Authorization: 'Bearer ' +this.authservice.accessToken});
  //   return this.httpClient.post<donate[]>("http://localhost:8022/donate",se,{headers});
  // }


}
