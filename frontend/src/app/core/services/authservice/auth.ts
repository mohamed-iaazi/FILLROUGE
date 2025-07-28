import {Inject, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import { CreateUserDto } from '../../../model/create-user.dto';


@Injectable({
  providedIn: 'root'
})
export class Auth {

  url: string="http://localhost:8080/auth";

  constructor(private httpClient: HttpClient  ) {
  }

  public login(request:{email: string, password: string}) : Observable<any>  {
    return this.httpClient.post(this.url+"/login", request);

  }

  public register(data : CreateUserDto) : Observable<any>  {
    return this.httpClient.post(this.url+"/register", data);

  }

  saveToken(token: string,username : string)    {
    localStorage.setItem('authToken', token);
    localStorage.setItem('username', username);
  }

  getToken() {
    return localStorage.getItem('authToken');
  }
}
