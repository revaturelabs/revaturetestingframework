import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { testObject } from './testObject';
import { jsonObject } from './jsonObject';
import { catchError, map, tap} from 'rxjs/operators';
import { of } from 'rxjs/observable/of';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import { mockArray } from './mockArray';

@Injectable()
export class TestService {
  private testData = new BehaviorSubject<any>({
    totalNumTests: 0,
    numSuccessfulTests: 0,
    numFailedTests: 0,
    numSkippedTests: 0,
    allTests: [],
    successfulTests: [],
    failedTests: [],
    skippedTests: []
  });

  currentTestData = this.testData.asObservable();

  getTestData() {
    return this.currentTestData;
  }

  runGroup(groupName: string): Observable<any> {
    //const url : string = "http://ec2-54-210-36-233.compute-1.amazonaws.com:8080/AssignForce/tests/test?group=";
	const url : string = "http://localhost:8080/AssignForce/tests/test?group=";
    return this.http.get<any>(url+groupName)
      .pipe(tap(data => {
        console.log(data);
        this.testData.next(data);
      }))
      .pipe(catchError(this.handleError('runAllTests',[])))
  }

  runAllTests(): Observable<any> {
    //const url : string = "http://ec2-54-210-36-233.compute-1.amazonaws.com:8080/TestingF/tests/test?group=all";
	const url : string = "http://localhost:8080/AssignForce/tests/test?group=all";
    return this.http.get<any>(url)
      .pipe(tap(data => {
        console.log(data);
        this.testData.next(data);
      }))
      .pipe(catchError(this.handleError('runAllTests',[])))
  }

  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(`${operation} failed: ${error.message}`);
      if (error instanceof Error) {
        console.error("Client-side error occured.");
      } else {
        console.error("Server-side error occured.");
      }
      console.error(error);
      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

  constructor(public http: HttpClient) { }

}
