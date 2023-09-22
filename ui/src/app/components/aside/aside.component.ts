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

  items = [['https://img.icons8.com/ios/50/quiz.png', 'Quizzes'], ['https://img.icons8.com/ios/50/quiz.png', 'Assigments'], ['https://img.icons8.com/ios/50/quiz.png', 'Calendar'], ['https://img.icons8.com/ios/50/quiz.png', 'Material'], ['https://img.icons8.com/ios/50/quiz.png', 'SC CHAT']]

  ngOnInit(): void {}
  
  toggleAside() {
    this.aside.setToggleAside(false);
  }

}
