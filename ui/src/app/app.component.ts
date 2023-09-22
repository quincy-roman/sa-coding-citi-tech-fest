import { Component } from '@angular/core';
import { SwUpdate } from '@angular/service-worker';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'ui';
  constructor(private swUpdate: SwUpdate) {
    if (this.swUpdate.isEnabled) {
      this.swUpdate.activated.subscribe((upd) => {
        window.location.reload();
      });
      this.swUpdate.available.subscribe(
        (upd) => {
          this.swUpdate.activateUpdate();
        },
        (error) => {
          console.error(error);
        }
      );
      this.swUpdate
        .checkForUpdate()
        .then(() => {})
        .catch((error) => {
          console.error('Could not check for app updates', error);
        });
    }
  }
}
