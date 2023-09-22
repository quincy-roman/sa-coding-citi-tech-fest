import { CanActivateFn } from '@angular/router';

export const adminGuard: CanActivateFn = (route, state) => {
  try {
    // assuming we will be setting the role in session storage after login and redirecting from there. 
    // Can also switch to an observable if we want a separate api call for the role
    let role = sessionStorage.getItem('role');
    if (role == 'ADMIN') return true
    else return false
  } catch {
    return false
  }
};
