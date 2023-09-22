import { Component } from '@angular/core';

@Component({
  selector: 'app-quizzes',
  templateUrl: './quizzes.component.html',
  styleUrls: ['./quizzes.component.css']
})
export class QuizzesComponent {
  tableHeaders: string[] = ['Column 1', 'Column 2', 'Column 3'];
  tableRows: string[][] = [
    ['Row 1, Cell 1', 'Row 1, Cell 2', 'Row 1, Cell 3'],
    ['Row 2, Cell 1', 'Row 2, Cell 2', 'Row 2, Cell 3'],
    // Add more rows as needed
  ];
}
