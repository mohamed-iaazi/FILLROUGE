import { Component } from '@angular/core';
import { QuizService, Question } from './quiz.service';

@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.css']
})
export class QuizComponent {
  questions: Question[] = [];
  currentIndex = 0;
  selectedOption: number | null = null;
  score = 0;
  showResult = false;

  constructor(private quizService: QuizService) {
    this.questions = this.quizService.getQuestions();
  }

  selectOption(index: number) {
    this.selectedOption = index;
  }

  nextQuestion() {
    if (this.selectedOption === this.questions[this.currentIndex].answer) {
      this.score++;
    }
    this.selectedOption = null;
    this.currentIndex++;
    if (this.currentIndex >= this.questions.length) {
      this.showResult = true;
    }
  }

  restart() {
    this.currentIndex = 0;
    this.selectedOption = null;
    this.score = 0;
    this.showResult = false;
  }
}
