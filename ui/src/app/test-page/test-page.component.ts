import { Component } from '@angular/core';
import { PushNotifyService } from '../services/push-notify.service';

@Component({
  selector: 'app-test-page',
  templateUrl: './test-page.component.html',
  styleUrls: ['./test-page.component.css'],
})
export class TestPageComponent {
  constructor(public notify: PushNotifyService) {}
}
