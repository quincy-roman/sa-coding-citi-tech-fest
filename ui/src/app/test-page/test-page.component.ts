import { Component } from '@angular/core';
import { PushNotifyService } from '../services/push-notify.service';
import { AppStatusService } from '../services/app-status.service';

@Component({
  selector: 'app-test-page',
  templateUrl: './test-page.component.html',
  styleUrls: ['./test-page.component.css'],
})
export class TestPageComponent {
  constructor(
    public notify: PushNotifyService,
    public appStatus: AppStatusService
  ) {}
}
