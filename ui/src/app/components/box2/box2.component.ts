import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-box2',
  templateUrl: './box2.component.html',
  styleUrls: ['./box2.component.css']
})
export class Box2Component {
  @Input() title : string = '';
}
 