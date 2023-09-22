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

  items = [{img: 'https://img.icons8.com/ios/50/quiz.png', title: 'Quizzes', link: '/quizzes'},
          {img: 'https://img.icons8.com/ios/50/quiz.png', title: 'Assignments', link:'/assignments'},
          {img: 'https://img.icons8.com/ios/50/quiz.png', title: 'Calendar', link: '/calendar'},
          {img: 'https://img.icons8.com/ios/50/quiz.png', title: 'Material', link: '/materials'},
          {img: 'https://img.icons8.com/ios/50/quiz.png', title: 'SC CHAT', link: '/chat'}]

  ngOnInit(): void {}

  toggleAside() {
    this.aside.setToggleAside(false);
  }

}
