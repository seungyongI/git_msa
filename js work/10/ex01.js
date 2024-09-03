const arr = ['a','b','c'];
const brr = [1,2,3,4,5];

const str1 = arr.join();
const str2 = brr.join(', ');

console.log(str1);
console.log(str2);

const length = arr.push('zz');
console.log(arr);
console.log(length);

const value = arr.unshift('aa');
console.log(arr);
console.log(value);

const item = arr.pop();
console.log(arr);
console.log(item);

const fitem = arr.shift();
console.log(arr);
console.log(fitem);