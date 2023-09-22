import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FacilitatorEventsComponent } from './facilitator-events.component';

describe('FacilitatorEventsComponent', () => {
  let component: FacilitatorEventsComponent;
  let fixture: ComponentFixture<FacilitatorEventsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FacilitatorEventsComponent]
    });
    fixture = TestBed.createComponent(FacilitatorEventsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
