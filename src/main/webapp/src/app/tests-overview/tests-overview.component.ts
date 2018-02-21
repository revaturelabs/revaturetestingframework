import { Component, OnInit } from '@angular/core';
import { jsonObject } from '../jsonObject';
import { TestService } from '../test.service';

@Component({
  selector: 'app-tests-overview',
  templateUrl: './tests-overview.component.html',
  styleUrls: ['./tests-overview.component.css']
})
export class TestsOverviewComponent implements OnInit {
  allTestsPassed: boolean = false;
  btnIsDisabled: boolean = false;
  testStatus: string;
  errMsg: string;

  testData: any;

  runAllTests() {
    console.log("disabling button...");
    this.btnIsDisabled = true;
    console.log("running tests and fetching all test data:");
    this.ts.runAllTests().subscribe(data => {
      this.testData = data;
      console.log("enabling button...");
      this.btnIsDisabled = false;
      this.setStateFromData();
    });
  }

  setStateFromData() {
    var d = this.testData;
    if (d.totalNumTests==0 || d.totalNumTests == undefined) {
      this.allTestsPassed = false;
      this.testStatus = 'No tests have been run';
    }
    else if (d.totalNumTests == d.numSuccessfulTests) {
      this.allTestsPassed = true;
      this.testStatus = "All tests passed!";
    }
    else {
      this.allTestsPassed = false;
      this.testStatus = "Some tests failed";
    }
  }

  constructor(private ts: TestService) {
  }

  ngOnInit() {
    console.log("initializing tests-overview");
    this.ts.getTestData().subscribe(data => {
      this.testData = data;
    })
    this.setStateFromData();
  }

  ngOnChanges() {
    console.log("tests-overview onchanges data:");
  }

  ngOnDestroy() {
    console.log("Destroying test-overview");
  }

}
