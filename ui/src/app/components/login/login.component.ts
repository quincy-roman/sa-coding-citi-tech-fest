import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/services/api.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  userInfo : any = {
    username: '',
    password: ''
  }
  constructor(private api: ApiService){}

  ngOnInit(): void {
    sessionStorage.setItem('role', 'admin');
  }

  login(){
    this.api.login(this.userInfo).pipe().subscribe({next: data =>{
      console.log(data)
    }})
  }
}
