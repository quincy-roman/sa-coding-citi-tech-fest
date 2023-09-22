/**
 * Param Object for pushNotify
 */
export interface PushNote {
  /** Basic Requirements */
  title?: string;
  body?: string;
  data?: any;

  /** url to asset */
  icon?: string;
  badge?: string;

  /** unique ID, will replace previous */
  tag?: string;

  /** uncommonly supported? */

  image?: string;
  lang?: string;
  requireInteraction?: boolean;
  renotify?: boolean;
  vibrate?: number[]; //milliseconds
  silent?: boolean;
  actions?: NotificationAction[];
}

/**
 * Array of eventTypes and Callbacks associate with web push notification API
 */
export interface PushNoteCallback {
  eventType: string;
  callback: (event: Event) => void;
}

// for the registration endpoint
export interface RegisterationInfo {
  firstName: string;
  lastName: string;
  email: string;
  password: string;
}
