console.log("Hej från JS");

let colorPicker = document.getElementById("colorPicker");
let colorBtn = document.getElementById("colorBtn");

colorBtn.addEventListener("click", () => {
    document.body.style.backgroundColor = colorPicker.value;
})