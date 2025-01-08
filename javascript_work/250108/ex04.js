// 호이스팅 : 변수든 함수든 한 번에 모든 코드를 읽고 메모리 상의 저장 시킨 후 실행
// 변수 호이스팅
// 함수 호이스팅

const person = {
  name: "John",
  age: 20,
  gender: "Male",
};

// fuc(person);

// function fuc({ name, age, gender }) {
//   console.log(`이름 : ${name}`);
//   console.log(`나이 : ${age}`);
//   console.log(`성별 : ${gender}`);
// }

const fuc = ({ name, age, gender }) => {
  console.log(`이름 : ${name}`);
  console.log(`나이 : ${age}`);
  console.log(`성별 : ${gender}`);
};

fuc(person);

console.log(a);

var a = 10;

console.log(a);