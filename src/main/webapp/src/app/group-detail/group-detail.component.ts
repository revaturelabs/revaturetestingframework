import { Component, OnInit, OnChanges } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { TestService } from '../test.service';

import { testObject } from '../testObject';
import { groupObject } from '../groupObject';
import { mockArray } from '../mockArray';

@Component({
  selector: 'app-group-detail',
  templateUrl: './group-detail.component.html',
  styleUrls: ['./group-detail.component.css']
})
export class GroupDetailComponent implements OnInit {
  public tests: Array<testObject>;
  public group: groupObject = new groupObject();
  public groups: string[] = ["VP","Trainer"];
  public btnIsDisabled: boolean = false;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private location: Location,
    private ts : TestService
  ) { }

  runGroup() {
    console.log("disabling button...");
    this.btnIsDisabled = true;
    console.log("running tests and fetching all test data:");
    this.ts.runGroup(this.group.name).subscribe(data => {
      console.log("enabling button...");
      this.btnIsDisabled = false;
      this.router.navigateByUrl('/overview');
    });
  }

  ngOnInit(): void {
  }

  ngDoCheck(): void {
    this.showGroup();
    console.log(this.group.name);
  }

  showGroup(): void {
    const name = this.route.snapshot.paramMap.get('groupname');
    this.group.name = name;
    if (name == 'VP') {
      this.group.description = "This group includes all the tests needed for the VP user"
    }
    else if (name == 'Trainer') {
      this.group.description = "This group includes all the tests needed for the Trainer user"
    }
  }

}
