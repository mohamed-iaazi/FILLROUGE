import { Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login';
import { RegisterComponent } from './auth/register/register';
import { QuestionListComponent } from './questions/question-list/question-list';
import { QuestionFormComponent } from './questions/question-form/question-form';
import { QuestionDetailComponent } from './questions/question-detail/question-detail';
import { ProjectListComponent } from './projects/project-list/project-list';
import { ProjectFormComponent } from './projects/project-form/project-form';

export const routes: Routes = [
  { path: '', redirectTo: 'questions', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'questions', component: QuestionListComponent },
  { path: 'questions/ask', component: QuestionFormComponent },
  { path: 'questions/:id', component: QuestionDetailComponent },
  { path: 'projects', component: ProjectListComponent },
  { path: 'projects/new', component: ProjectFormComponent },
  // Add more routes as needed
]; 