import { Component } from '@angular/core';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})


export class FooterComponent {

  icons = [['../../../assets/Web_App_Icons/icons8-quiz-50-light.png', 'Quizzes'], 
    ['../../../assets/Web_App_Icons/icons8-assignment-50-light.png', 'Assigments'], 
    ['../../../assets/Web_App_Icons/icons8-teacher-50-light.png', 'SC Chat'],
    ['../../../assets/Web_App_Icons/icons8-calendar-50-light.png', 'Calendar'],
    ['../../../assets/Web_App_Icons/icons8-assignment-50-light.png', 'Register']
  ]


}
