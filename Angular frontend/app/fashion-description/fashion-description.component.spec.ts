import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FashionDescriptionComponent } from './fashion-description.component';

describe('FashionDescriptionComponent', () => {
  let component: FashionDescriptionComponent;
  let fixture: ComponentFixture<FashionDescriptionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FashionDescriptionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FashionDescriptionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
