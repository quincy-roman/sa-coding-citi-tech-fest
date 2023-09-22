import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ScChatComponent } from './sc-chat.component';

describe('ScChatComponent', () => {
  let component: ScChatComponent;
  let fixture: ComponentFixture<ScChatComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ScChatComponent]
    });
    fixture = TestBed.createComponent(ScChatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
