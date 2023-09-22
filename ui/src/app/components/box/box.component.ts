import { Component, Input, OnInit, TemplateRef } from '@angular/core';

@Component({
  selector: 'app-box',
  templateUrl: './box.component.html',
  styleUrls: ['./box.component.css']
})
export class BoxComponent implements OnInit {
  constructor(){}
 @Input() title : string = '';
 @Input() content!: TemplateRef<any>;

 ngOnInit(): void {
   
 }
 ngAfterViewInit(){
  console.log(this.content)
 }
}
