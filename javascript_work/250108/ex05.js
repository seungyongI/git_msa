// spread 펼치다 전개연산자

const arr1 = [1,2,3];
const arr2 = [4, ...arr1, 5, 6];
const arr3 = [4, arr2, 5, 6];
const arr4 = arr1;

console.log(arr1);
console.log(arr2);
console.log(arr3);
console.log(arr4);
console.log("================================");

arr4[0] = 10;

console.log(arr1);
console.log(arr2);
console.log(arr3);
console.log(arr4);
console.log("================================");

const obj1 = {
    a: 10,
    b: 20,
};

const obj2 = {
    ...obj1,
    b: 30,
    c: 40,
};

console.log(obj1);
console.log(obj2);
