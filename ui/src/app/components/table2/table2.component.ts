import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-table2',
  templateUrl: './table2.component.html',
  styleUrls: ['./table2.component.css']
})
export class Table2Component {
@Input() headers : string[] = [];
@Input() rows : string[][] = [];
}
