import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators, AbstractControl, ReactiveFormsModule, FormArray} from '@angular/forms';
import {MatFormField, MatInput, MatInputModule, MatLabel} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {NgForOf, NgIf} from '@angular/common';
import {MatButton, MatIconButton} from '@angular/material/button';
import {RouterLink} from '@angular/router';
import {MatStep, MatStepper} from '@angular/material/stepper';
import {MatIcon} from '@angular/material/icon';
import {Auth} from '../../core/services/authservice/auth';

@Component({
  selector: 'app-register',
  templateUrl: './register.html',
  imports: [
    ReactiveFormsModule,
    MatFormField,
    MatFormFieldModule,
    MatInputModule,
    MatLabel,
    NgIf,
    MatInput,
    MatButton,
    NgForOf,
    MatStepper,
    MatStep,
    MatIcon,
    MatIconButton,
  ],
  styleUrls: ['./register.css']
})
export class RegisterComponent {

  registerForm: FormGroup;
  step = 0;

  constructor(private fb: FormBuilder ,private  auth : Auth) {
    this.registerForm = this.fb.group({
      step1: this.fb.group({
        name: ['', Validators.required],
        email: ['', [Validators.required, Validators.email]],
        password: ['', [Validators.required, Validators.minLength(6)]],
      }),
      step2: this.fb.group({
        bio: [''],
        avatarUrl: ['']
      }),
      step3: this.fb.group({
        competences: this.fb.array([])
      })
    });
  }

  // Getters for convenience
  get step1(): FormGroup {
    return this.registerForm.get('step1') as FormGroup;
  }

  get step2(): FormGroup {
    return this.registerForm.get('step2') as FormGroup;
  }

  get step3(): FormGroup {
    return this.registerForm.get('step3') as FormGroup;
  }

  get competences(): FormArray {
    return this.step3.get('competences') as FormArray;
  }

  addCompetence() {
    const competenceGroup = this.fb.group({
      competenceId: [null],
      name: ['', Validators.required]
    });
    this.competences.push(competenceGroup);
  }

  removeCompetence(index: number) {
    this.competences.removeAt(index);
  }

  nextStep() {
    if (this.step < 2) {
      this.step++;
    }
  }

  prevStep() {
    if (this.step > 0) {
      this.step--;
    }
  }

  onSubmit() {
    if (this.registerForm.valid) {
      console.log('Form Value:', this.registerForm.value);
        if (this.registerForm.valid) {
      const formValue = {
      ...this.registerForm.value.step1,
      ...this.registerForm.value.step2,
      ...this.registerForm.value.step3
  
    };
    this.auth.register(formValue).subscribe({
      next: (res) => {
          console.log('Register success:', res);
        },
        error: (err) => {
          console.error('Register failed:', err);
        }

      
      }) };



    } else {
      this.registerForm.markAllAsTouched();
    }
  }


}
