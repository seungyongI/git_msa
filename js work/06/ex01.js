import { doFunction, doFunction2 } from "./myfunction.js";

const doA = function (a, b) {
  console.log("a = " + a);
  console.log("b = " + b);
};

doA(10, 20);

doFunction(10);
doFunction2();