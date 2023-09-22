import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FacilitatorHomeComponent } from './facilitator-home.component';

describe('FacilitatorHomeComponent', () => {
  let component: FacilitatorHomeComponent;
  let fixture: ComponentFixture<FacilitatorHomeComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FacilitatorHomeComponent]
    });
    fixture = TestBed.createComponent(FacilitatorHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
