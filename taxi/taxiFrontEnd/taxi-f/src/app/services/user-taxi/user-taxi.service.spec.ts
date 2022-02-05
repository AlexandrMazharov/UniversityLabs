import { TestBed } from '@angular/core/testing';

import { UserTaxiService } from './user-taxi.service';

describe('UserTaxiService', () => {
  let service: UserTaxiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UserTaxiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
