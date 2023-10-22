import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SensorsOnlineComponent } from './sensors-online.component';

describe('SensorsOnlineComponent', () => {
  let component: SensorsOnlineComponent;
  let fixture: ComponentFixture<SensorsOnlineComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SensorsOnlineComponent]
    });
    fixture = TestBed.createComponent(SensorsOnlineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
