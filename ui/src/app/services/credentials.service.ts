import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HttpXhrBackend } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CredentialsService implements HttpInterceptor { 
    
  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    if(!request.url.includes('login') && !request.url.includes('register') && !request.url.includes('verify')){
      request = request.clone({
        withCredentials: true
      });
    }
    return next.handle(request);
  }
}
