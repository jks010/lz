import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfileOperationsComponent } from './profile-operations.component';

describe('ProfileOperationsComponent', () => {
  let component: ProfileOperationsComponent;
  let fixture: ComponentFixture<ProfileOperationsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ProfileOperationsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ProfileOperationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
