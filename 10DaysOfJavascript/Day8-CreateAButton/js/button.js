let count = 0;  
function myFunction() {
  count = count + 1;  
  document.getElementById("btn").innerHTML = count;
}


var btn = document.createElement("Button");

btn.innerHTML = "0";
btn.id = "btn";
btn.className = "btnClass";

document.body.appendChild(btn);

btn.onclick = function() {
    btn.innerHTML = parseInt(btn.innerHTML ) + 1;
}