import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FootingComponent } from './footing.component';

describe('FootingComponent', () => {
  let component: FootingComponent;
  let fixture: ComponentFixture<FootingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FootingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FootingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
