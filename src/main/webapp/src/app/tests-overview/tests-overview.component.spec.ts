import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TestsOverviewComponent } from './tests-overview.component';

describe('TestsOverviewComponent', () => {
  let component: TestsOverviewComponent;
  let fixture: ComponentFixture<TestsOverviewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TestsOverviewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TestsOverviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
