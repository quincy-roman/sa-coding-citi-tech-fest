import { Component, QueryList, TemplateRef, ViewChild, ViewContainerRef } from '@angular/core';
import { ElementRef } from 'react';

@Component({
  selector: 'app-facilitator-home',
  templateUrl: './facilitator-home.component.html',
  styleUrls: ['./facilitator-home.component.css']
})
export class FacilitatorHomeComponent {
  @ViewChild('classContent') content : ElementRef<any>
}
