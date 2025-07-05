import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {LoginComponent} from './auth/login/login';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, LoginComponent],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected title = 'frontend';
}
