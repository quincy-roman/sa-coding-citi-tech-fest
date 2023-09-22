import { CanActivateFn } from '@angular/router';

export const facilitatorsGuard: CanActivateFn = (route, state) => {
  try {
    let role = sessionStorage.getItem('role');
    if (role == 'FACILITATOR') return true
    else return false
  } catch {
    return false
  }
};
