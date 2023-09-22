import { Component } from '@angular/core';
import { DatastoreService } from '../services/datastore.service';

@Component({
  selector: 'app-quizzes',
  templateUrl: './quizzes.component.html',
  styleUrls: ['./quizzes.component.css']
})
export class QuizzesComponent {

constructor(public datastore: DatastoreService){
  this.datastore.myAssignments
} 



  tableHeaders: string[] = ['Quiz', 'Column 2'];
  tableRows: string[][] = [
    ['Row 1, Cell 1', 'Row 1, Cell 2'],
    ['Row 2, Cell 1', 'Row 2, Cell 2'],
    // Add more rows as needed
  ];
}
