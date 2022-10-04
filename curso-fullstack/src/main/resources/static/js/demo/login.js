
async function iniciarSesion() {
let uuemail     = document.getElementById("uemail");
let uupassword  = document.getElementById("upassword");
let datosUser = {
"email":    uuemail.value,
"password": uupassword.value
}; // datosUser
const urlApi = "http://localhost:8080/api/login";
const objetoInfo = {
/* mode: 'cors', // no-cors, cors, same-origin */
method: "POST",
headers: { /* "Access-Control-Allow-Origin": "*", "Access-Control-Allow-Methods": "*", "Access-Control-Allow-Headers": "*", */
"Content-Type": "application/json",
"Accept": "application/json"
},
body: JSON.stringify( datosUser )
}; // objetoInfo
const request = await fetch( urlApi, objetoInfo );
const ansB = await request.text(); // var ansA = await request.json();
localStorage.token = await ansB; // 4:05:00 //window.location.href = "http://localhost:8080/hice/usuarios.html";
} // function iniciarSesion

