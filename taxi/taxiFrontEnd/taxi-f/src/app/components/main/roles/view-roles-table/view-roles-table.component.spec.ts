import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewRolesTableComponent } from './view-roles-table.component';

describe('ViewRolesTableComponent', () => {
  let component: ViewRolesTableComponent;
  let fixture: ComponentFixture<ViewRolesTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewRolesTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewRolesTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
