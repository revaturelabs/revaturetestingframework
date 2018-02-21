import { Component, OnInit } from '@angular/core';
import { jsonObject } from '../jsonObject';
import { TestService } from '../test.service';
import { Chart } from 'chart.js';

@Component({
  selector: 'app-metrics-view',
  templateUrl: './metrics-view.component.html',
  styleUrls: ['./metrics-view.component.css']
})
export class MetricsViewComponent implements OnInit {
  testData: any;

  initializeChart() {
    var ctx: any = document.getElementById("myChart");
    ctx.getContext('2d');
    var myChart: any = new Chart(ctx, {
        type: 'pie',
        data: {
            labels: ["Failed", "Skipped","Passed"],
            datasets: [{
                label: 'Test Analysis',
                data: [
                  this.testData.numFailedTests,
                  this.testData.numSkippedTests,
                  this.testData.numSuccessfulTests
                ],
                backgroundColor: [
                    'rgba(255, 99, 132, 0.2)',
                    'rgba(255, 206, 86, 0.2)',
                    'rgba(75, 192, 192, 0.2)',
                ],
                borderColor: [
                    'rgba(255,99,132,1)',
                    'rgba(255, 206, 86, 1)',
                    'rgba(75, 192, 192, 1)',
                ],
                borderWidth: 1
            }]
        },
        options: {
            cutoutPercentage: 0
        }
    });
  }

  constructor(public ts : TestService) { }

  ngOnInit() {
    console.log("initializing tests-overview");
    this.ts.getTestData().subscribe(data => {
      this.testData = data;
      this.initializeChart();
    });
  }

}
