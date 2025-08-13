
import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { QuizComponent } from './quiz.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, QuizComponent],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('quiz-app');
}
