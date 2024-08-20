function doA() {
  alert('누름');
}

var heading = document.querySelector("#heading");
var btn = document.querySelector("#btn");

// heading.onclick = doA;

heading.onclick = function () {
  heading.style.color = "red";
  heading.innerHTML = "글자 변경";
  heading.style.backgroundColor = "yellow";
  heading.style.textAlign = "center";
  heading.style.fontSize = "100px";
};

btn.onclick = function(){
  var name = prompt('당신의 이름은?', '이름');
  alert(name);
}