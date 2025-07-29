import { Routes } from '@angular/router';
import {LoginComponent} from './auth/login/login';
import {Home} from './home/home';
import {RegisterComponent} from './auth/register/register';

export const routes: Routes = [


  { path: 'home', component: Home },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },

];
