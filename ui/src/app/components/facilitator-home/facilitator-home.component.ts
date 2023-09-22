import { Component, ElementRef, ViewChild } from '@angular/core';

@Component({
  selector: 'app-facilitator-home',
  templateUrl: './facilitator-home.component.html',
  styleUrls: ['./facilitator-home.component.css']
})
export class FacilitatorHomeComponent {
  @ViewChild('classContent') content! : ElementRef<any>;
}
