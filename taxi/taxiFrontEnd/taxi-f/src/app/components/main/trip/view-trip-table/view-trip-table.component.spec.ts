import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewTripTableComponent } from './view-trip-table.component';

describe('ViewTripComponent', () => {
  let component: ViewTripTableComponent;
  let fixture: ComponentFixture<ViewTripTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewTripTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewTripTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
