import {Inject, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class Auth {

  url: string="http://localhost:8080/auth/login";

  constructor(private httpClient: HttpClient  ) {
  }

  public login(request:{email: string, password: string}) : Observable<any>  {
    return this.httpClient.post(this.url, request);

  }
}
