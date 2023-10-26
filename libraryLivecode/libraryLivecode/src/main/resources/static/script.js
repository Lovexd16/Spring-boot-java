console.log("test");

let admin = true //Spara i localStorage

if (admin) {
let link = document.createElement("a");
link.innerText = "Admin"
link.href="/admin"

document.body.appendChild(link)
}
