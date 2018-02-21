import { Component, OnInit, OnChanges } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { TestService } from '../test.service';

import { testObject } from '../testObject';
import { mockArray } from '../mockArray';
import { jsonObject } from '../jsonObject';

@Component({
  selector: 'app-test-detail',
  templateUrl: './test-detail.component.html',
  styleUrls: ['./test-detail.component.css']
})
export class TestDetailComponent implements OnInit {
  public allTests: any;
  public test: testObject;

  constructor(
    private route: ActivatedRoute,
    private location: Location,
    private ts: TestService
  ) { }

  ngOnInit(): void {
    this.ts.getTestData().subscribe(data => {
      this.allTests = data.allTests;
    });
  }

  ngDoCheck(): void {
    console.log("test-detail do check...");
    this.showTest();
  }

  showTest(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.test = this.allTests[id-1];
  }
}
