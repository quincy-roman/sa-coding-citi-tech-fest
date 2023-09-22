import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AssigmentsComponent } from './assigments.component';

describe('AssigmentsComponent', () => {
  let component: AssigmentsComponent;
  let fixture: ComponentFixture<AssigmentsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AssigmentsComponent]
    });
    fixture = TestBed.createComponent(AssigmentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
