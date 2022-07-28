import { TestBed } from '@angular/core/testing';

import { AddCartServiceService } from './add-cart-service.service';

describe('AddCartServiceService', () => {
  let service: AddCartServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AddCartServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
