let arr = [1, 2, 3, 4, 5, 6, 7];
let numArr = arr.splice(2);

console.log(`arr = ${arr}`);
console.log(`numArr = ${numArr}`);

console.log();

arr = [1, 2, 3, 4, 5, 6, 7];
numArr = arr.splice(2, 2);

console.log(`arr = ${arr}`);
console.log(`numArr = ${numArr}`);

console.log();

arr = [1, 2, 3, 4, 5, 6, 7];
numArr = arr.splice(2, 2, [98, 99]);

console.log(`arr = ${arr}`);
console.log(`numArr = ${numArr}`);
