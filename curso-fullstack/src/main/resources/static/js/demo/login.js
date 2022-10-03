

async function iniciarSesion() {
//debugger;
let uuemail     = document.getElementById("uemail");
let uupassword  = document.getElementById("upassword");

let datosUser = {
"email":    uuemail.value,
"password": uupassword.value
};

//console.log( datosUser );

const urlApi = "http://localhost:8080/api/usuarios";

const objetoInfo = {

mode: 'cors', // no-cors, cors, same-origin
method: "POST",
headers: {
"Access-Control-Allow-Origin": "*",
"Access-Control-Allow-Methods": "*",
"Access-Control-Allow-Headers": "*",
"Content-Type": "application/json",
"Accept": "application/json"
},
cache: 'no-cache',
body: JSON.stringify( datosUser )

}; // objetoInfo

let request = await fetch( urlApi, objetoInfo );
//let response = await request.json();
let response = await request.text();
if( response == true ){
alert("Bienvenido");
window.location.href = "/hice/index.html";
}else{
alert("Credenciales invalidas");
}


} // function iniciarSesion

