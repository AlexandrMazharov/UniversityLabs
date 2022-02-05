import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewCarTableComponent } from './view-car-table.component';

describe('ViewCarTableComponent', () => {
  let component: ViewCarTableComponent;
  let fixture: ComponentFixture<ViewCarTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewCarTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewCarTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
