import { TestBed } from '@angular/core/testing';
import { CanActivateFn } from '@angular/router';

import { facilitatorsGuard } from './facilitators.guard';

describe('facilitatorsGuard', () => {
  const executeGuard: CanActivateFn = (...guardParameters) => 
      TestBed.runInInjectionContext(() => facilitatorsGuard(...guardParameters));

  beforeEach(() => {
    TestBed.configureTestingModule({});
  });

  it('should be created', () => {
    expect(executeGuard).toBeTruthy();
  });
});
