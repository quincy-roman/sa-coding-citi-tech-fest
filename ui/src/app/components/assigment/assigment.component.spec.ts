import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AssigmentComponent } from './assigment.component';

describe('AssigmentComponent', () => {
  let component: AssigmentComponent;
  let fixture: ComponentFixture<AssigmentComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AssigmentComponent]
    });
    fixture = TestBed.createComponent(AssigmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
