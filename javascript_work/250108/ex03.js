const aa = {
  a: "a 변수",
  b: "b 변수",
  c: "c 변수",
};

const { a, b, c } = aa;

console.log(`a = ${a}`);
console.log(`b = ${b}`);
console.log(`c = ${c}`);

const aaa = JSON.stringify(aa);
console.log(JSON.parse(aaa));


