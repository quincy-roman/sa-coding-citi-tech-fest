import { Component, OnInit } from '@angular/core';
import { Aside } from '../../services/aside.service';
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  isNavbarOpen = true
  constructor(public aside: Aside) {
    this.isNavbarOpen = aside.getToggleAside()
  }

  ngOnInit(): void {}
  
  toggleAside() {
    this.aside.setToggleAside(true);
  }

}
