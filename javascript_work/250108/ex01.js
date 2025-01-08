// 1 falsy 값
const f1 = undefined; // 선언만 되어 있고 값이 할당 되지 않았을 때
const f2 = null; // 선언되어져있고 값이 null로 선언 되어 있을 때
const f3 = 0;
const f4 = -0;
const f5 = NaN; // 숫자로 표기할 수 없음 Not a Number
const f6 = "";

const result1 = f1 && "result1111";
console.log(result1);

class A {
  a;
  constructor(a) {
    this.a = a;
  }
}

// 2 truthy 값
const t1 = "result";
const t2 = 123;
const t3 = [];
const t4 = { a: 10, b: 20 }; // json -> javascript object
const t5 = () => {
  console.log("Function");
};
const t6 = new A(20);

const result2 = t4.a && "result2222";
console.log(result2);

function printName(test) {
  if (test) {
    // console.log(test + " 출력된다.");
    console.log(`${test} 출력된다.`);
  } else {
    // console.log(test + " 출력 안 된다.");
    console.log(`${test} 출력 안 된다.`);
  }
}

printName(f5);
printName(t5);

function aa(a) {
  console.log(a);
}

aa({ a: 10, b: 20 });
