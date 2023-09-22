import { Component, OnInit } from '@angular/core';
import { Aside } from '../../services/aside.service';

@Component({
  selector: 'app-aside',
  templateUrl: './aside.component.html',
  styleUrls: ['./aside.component.css']
})
export class AsideComponent implements OnInit {
  isNavbarOpen = true
  constructor(public aside: Aside) {
    this.isNavbarOpen = aside.getToggleAside()
  }

  items = [{img: '../../../assets/Web_App_Icons/icons8-quiz-50.png', title: 'Quizzes', link: '/quizzes'},
          {img: '../../../assets/Web_App_Icons/icons8-assignment-50.png', title: 'Assignments', link:'/assignments'},
          {img: '../../../assets/Web_App_Icons/icons8-calendar-50.png', title: 'Calendar', link: '/calendar'},
          {img: '../../../assets/Web_App_Icons/icons8-teacher-50.png', title: 'SC CHAT', link: '/chat'},
          {img: '../../../assets/Web_App_Icons/icons8-materials-50.png', title: 'Materials', link: '/materials'}]

  ngOnInit(): void {}

  toggleAside() {
    this.aside.setToggleAside(false);
  }

}
