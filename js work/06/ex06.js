let input = document.getElementById('input');
let print = document.getElementById('print');

document.getElementById('btn').onclick = () => {
  let n = input.value;
  let sum = 0;
  print.innerHTML = "";
  for(let i = 1; i <= n; i++) {
    sum+=i;
  }
  console.log(sum);
  print.innerHTML = sum;
}