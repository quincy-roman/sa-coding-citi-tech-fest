import { TestBed } from '@angular/core/testing';

import { PushNotifyService } from './push-notify.service';

describe('PushNotifyService', () => {
  let service: PushNotifyService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PushNotifyService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
