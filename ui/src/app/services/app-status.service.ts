import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class AppStatusService {
  public isOnline: boolean = false;
  constructor() {
    /** Initial Status Call */
    this.updateOnlineStatus();

    /** Adding EventListeners to Status */
    window.addEventListener('online', this.updateOnlineStatus);
    window.addEventListener('offline', this.updateOnlineStatus);
  }

  private updateOnlineStatus = () => {
    this.isOnline = window.navigator.onLine;
  };
}
