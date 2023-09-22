import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RegisterationInfo } from '../interfaces/types';

declare var API_URL: string;
@Injectable({
  providedIn: 'root'
})
export class ApiService {
  url = API_URL;
  constructor(private client : HttpClient) { }

  login(userInfo : {username: string, password: string}){
    return this.client.post(`${this.url}/login`, userInfo);
  }

  register(registerInfo : RegisterationInfo){
    return this.client.post(`${this.url}/register`, registerInfo)
  }
}
