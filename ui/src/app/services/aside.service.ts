import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class Aside {
  public isToggledAside: boolean = false;

  setToggleAside = (value: boolean) => {
    this.isToggledAside = value;
  };
  getToggleAside = () => {
    return this.isToggledAside;
  };
}
