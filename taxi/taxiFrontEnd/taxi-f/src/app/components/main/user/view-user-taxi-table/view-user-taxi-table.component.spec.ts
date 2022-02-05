import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewUserTaxiTableComponent } from './view-user-taxi-table.component';

describe('ViewUserTaxiTableComponent', () => {
  let component: ViewUserTaxiTableComponent;
  let fixture: ComponentFixture<ViewUserTaxiTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewUserTaxiTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewUserTaxiTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
