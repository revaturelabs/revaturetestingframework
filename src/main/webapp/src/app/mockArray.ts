import {testObject} from './testObject';
export const mockArray: testObject[] = [
  {
    id: 1,
    name: "Test for both VP and Trainer",
    groups: ["VP","Trainer"],
    status: "failure",
    belongsToClass: "exampleClass1",
    exceptionThrown: "sample exception"
  },
  {
    id: 2,
    name: "Unit test for VP",
    groups: ["VP","Unit"],
    status: "success",
    belongsToClass: "exampleClass1",
    exceptionThrown: "sample exception"
  },
  {
    id: 3,
    name: "Unit test for Trainer",
    groups: ["Trainer","Unit"],
    status: "skipped",
    belongsToClass: "exampleClass1",
    exceptionThrown: "sample exception"
  }
];
