import {Component, Inject} from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import {NgIf, NgOptimizedImage} from '@angular/common';
import {MatFormField, MatInput, MatInputModule, MatLabel} from '@angular/material/input';
import {MatButton} from '@angular/material/button';
import {RouterLink} from '@angular/router';
import {MatIcon} from '@angular/material/icon';
import {MatFormFieldModule} from '@angular/material/form-field';
import {Auth} from '../../core/services/authservice/auth';
import {MatSnackBar} from '@angular/material/snack-bar';

@Component({
  selector: 'app-login',
  templateUrl: './login.html',
  imports: [
    ReactiveFormsModule,
    MatFormField,
    MatFormFieldModule,
    MatInputModule,
    MatLabel,
    NgIf,
    MatInput,
    MatButton,
    RouterLink,
  ],
  styleUrls: ['./login.css']
})
export class LoginComponent {
  loginForm: FormGroup;


constructor(private fb: FormBuilder ,private  auth : Auth ,    private snackBar: MatSnackBar) {
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]]
    });
 }




  onSubmit() {
    if (this.loginForm.valid) {
      const  { email, password } = this.loginForm.value;
      // call auth service

      console.log('Logging in with', email, password);
    this.auth.login( { email, password }).subscribe({
      next: (res) => {
        const token = res.token;
        const username = res.username;
        this.auth.saveToken(token,username);
        this.snackBar.open(res.message, "close", {

          panelClass: ['success-snackbar'],
          duration:2000
        });

        console.log('Login success:', res, "for user", username, token);
        // Handle login success, maybe store token or navigate
      },
      error: (err) => {
        this.snackBar.open("Login failed", "close", {
          panelClass: ['error-snackbar'],
          duration:2000




        })
        console.error('Login failed:', err);
      }
    });


    }
  }
}

