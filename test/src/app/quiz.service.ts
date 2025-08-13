import { Injectable } from '@angular/core';

export interface Question {
  question: string;
  options: string[];
  answer: number;
}

@Injectable({ providedIn: 'root' })
export class QuizService {
  private questions: Question[] = [
    {
      question: 'What is the capital of France?',
      options: ['Berlin', 'London', 'Paris', 'Madrid'],
      answer: 2
    },
    {
      question: 'Which planet is known as the Red Planet?',
      options: ['Earth', 'Mars', 'Jupiter', 'Saturn'],
      answer: 1
    },
    {
      question: 'Who wrote "Hamlet"?',
      options: ['Charles Dickens', 'William Shakespeare', 'Mark Twain', 'Jane Austen'],
      answer: 1
    }
  ];

  getQuestions(): Question[] {
    return this.questions;
  }
}
