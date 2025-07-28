import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {LoginComponent} from './auth/login/login';
import {RegisterComponent} from './auth/register/register';
import {Home} from './home/home';
import {Navbar} from './shared/navbar/navbar';
import {FooterComponent} from './shared/footer/footer';
import {QuestionDetail} from './questions/question-detail/question-detail';
import {ProjectList} from './projects/project-list/project-list';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, LoginComponent, RegisterComponent, Home, Navbar, FooterComponent, QuestionDetail, ProjectList],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected title = 'frontend';
}
