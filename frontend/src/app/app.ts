import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {LoginComponent} from './auth/login/login';
import {RegisterComponent} from './auth/register/register';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, LoginComponent, RegisterComponent],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected title = 'frontend';
}
