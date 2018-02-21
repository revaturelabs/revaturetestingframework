import { Component, OnInit } from '@angular/core';
import { testObject } from '../testObject';
import { mockArray } from '../mockArray';
import { TestService } from '../test.service';
import { Subscription } from 'rxjs/Subscription';

@Component({
  selector: 'app-sidenav',
  templateUrl: './sidenav.component.html',
  styleUrls: ['./sidenav.component.css']
})
export class SidenavComponent implements OnInit {
  allTests: testObject[];

  groups: string[] = ["1","2","3","4","5","6","7"];

  constructor(public ts: TestService) {
  }

  ngOnInit() {
    this.ts.getTestData().subscribe(data => {
      this.allTests = data.allTests;
    })
  }

}
