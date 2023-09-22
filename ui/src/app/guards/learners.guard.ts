import { CanActivateFn } from '@angular/router';

export const learnersGuard: CanActivateFn = (route, state) => {
  try {
    let role = sessionStorage.getItem('role');
    if (role == 'LEARNER') return true
    else return false
  } catch {
    return false
  }
};
