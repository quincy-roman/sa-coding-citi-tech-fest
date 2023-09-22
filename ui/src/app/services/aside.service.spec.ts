import { TestBed } from '@angular/core/testing';

import { Aside } from './aside.service';

describe('AsideService', () => {
  let service: Aside;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Aside);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
