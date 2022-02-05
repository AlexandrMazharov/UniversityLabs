import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewUsedCarTableComponent } from './view-used-car-table.component';

describe('ViewUsedCarTableComponent', () => {
  let component: ViewUsedCarTableComponent;
  let fixture: ComponentFixture<ViewUsedCarTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewUsedCarTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewUsedCarTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
