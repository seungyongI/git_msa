import myfunction, { doA, doB } from "./myfunction.js";

console.log("test");
doA();
doB();

console.log(`myfunction.a = ${myfunction.a}`);
console.log(`myfunction.b = ${myfunction.b}`);
