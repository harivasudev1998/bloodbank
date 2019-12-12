import { Component, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { AuthServiceService } from 'src/app/auth-service.service';




@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  

  constructor(private router: Router,private authService:AuthServiceService) { }

    isAuthenticated() {
      // console.log(this.authService.loggedInUser)
      return this.authService.loggedInUser;
      
    }
  
    // isAdmin() {
    //   return this.authService.isAdmin;
    // }
  
    // getUser() {
    //   return this.authService.userAuthenticated;
    // }
  
    onLogOut() {
      // this.cartService.clearCart();
      this.authService.logout();

      // this.router.navigate([this.authService.redirectUrl]);
    }

  ngOnInit() {
  }

}
