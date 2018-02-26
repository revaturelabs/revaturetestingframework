import { Component, Input, Output } from '@angular/core';
import { jsonObject } from './jsonObject';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  appTitle: String = 'TrackForce Test Automation Framework';
  //@Input() @Output() testData: jsonObject;
}
