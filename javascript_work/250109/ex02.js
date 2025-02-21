const arr1 = [
  { name: "홍길동", age: 20 },
  { name: "김길동", age: 15 },
  { name: "이길동", age: 30 },
];

arr1.forEach((obj) => {
  console.log(obj);
});

console.log("--------------------------------------------------------");

const arr2 = [...arr1, { name: "박길동", age: 40 }];
console.log(arr2);

console.log("--------------------------------------------------------");

const findObj = arr1.find((obj) => {
  if (obj.name == "홍길동" && obj.age === 20) {
    return obj;
  }
});

console.log(findObj);

console.log("--------------------------------------------------------");

const arr3 = [1,2,3,4];
const findIndex1 = arr3.findIndex( index => {
  return index === 2;
});
console.log(findIndex1);

const findIndex2 = arr3.findIndex( index => {
  return index === 4;
});
console.log(findIndex2);