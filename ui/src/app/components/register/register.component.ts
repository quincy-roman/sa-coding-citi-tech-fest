import { Component, OnInit } from '@angular/core';
import { RegisterationInfo } from 'src/app/interfaces/types';
import { ApiService } from 'src/app/services/api.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent implements OnInit {
  userInfo: RegisterationInfo = {
    firstName: '',
    lastName: '',
    email: '',
    password: '',
  };
  confirmPass = '';
  errMsg: string = '';

  constructor(private api: ApiService) {}

  ngOnInit(): void {}

  register() {
    this.errMsg = '';
    if (this.userInfo.password !== this.confirmPass)
      this.errMsg = 'passwords do not match';
    else
      this.api
        .registerUser(this.userInfo)
        .subscribe({ next: (data) => console.log(data) });
  }
}
