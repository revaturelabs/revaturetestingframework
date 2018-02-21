import {testObject} from './testObject';

export class jsonObject {
  totalNumTests: number;
  numSuccessfulTests: number;
  numFailedTests: number;

  allTests: Array<testObject>;
  successfulTests: Array<testObject>;
  failedTests: Array<testObject>;
  skippedTests: Array<testObject>;
}
