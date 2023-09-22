import { Injectable } from '@angular/core';
import { PushNote, PushNoteCallback } from '../interfaces/types';

@Injectable({
  providedIn: 'root',
})
export class PushNotifyService {
  constructor() {
    this.reqNotifyPerm();
  }

  private canPushNotify = false;
  private defaultNote: PushNote = {
    title: 'Social Coding - SA',
    body: '',
    icon: '/assets/logo_shadow.png',
  };

  /**
   * Asks for user permission to enable push notifications.
   */
  private reqNotifyPerm = async () => {
    const perm = await Notification.requestPermission();
    if (perm === 'granted') {
      this.canPushNotify = true;
    } else {
      this.canPushNotify = false;
    }
  };

  /**
   * Adds a Notification through the browser.
   * @param options
   * @param eventCallbacks
   * @returns
   */
  public pushNotify(options: PushNote = {}, eventCallbacks?: PushNoteCallback[]) {
    if (!this.canPushNotify) {
      console.warn('Do not have permission to push notifications.');
      return;
    }
    options = Object.assign({}, this.defaultNote, options);
    const notification = new Notification(String(options.title), options);

    if (eventCallbacks) {
      eventCallbacks.forEach(({ eventType, callback }) => {
        notification.addEventListener(eventType, callback);
      });
    }
  }
}
