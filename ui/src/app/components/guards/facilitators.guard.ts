import { CanActivateFn } from '@angular/router';

export const facilitatorsGuard: CanActivateFn = (route, state) => {
  try {
    // this line is for testing purposes. Remove after api integration
    sessionStorage.setItem('role', 'FACILITATOR');
    
    let role = sessionStorage.getItem('role');
    if (role == 'FACILITATOR') return true
    else return false
  } catch {
    return false
  }
};
