
async function crearUsuario() {

let uunombre    = document.getElementById("unombre");
let uuapellido  = document.getElementById("uapellido");
let uuemail     = document.getElementById("uemail");
let uutelefono  = document.getElementById("utelefono");
let uupassword  = document.getElementById("upassword");
let uupassword2 = document.getElementById("upassword2");

if( uupassword.value !== uupassword2.value ) {
alert("Los password no coinciden, deben ser iguales");
return;
} // validar password

let datosNewUser = {
"nombre": uunombre.value,
"apellido": uuapellido.value,
"email": uuemail.value,
"telefono": uutelefono.value,
"password": uupassword.value
};

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
body: JSON.stringify( datosNewUser )

}; // objetoInfo

await fetch( urlApi, objetoInfo );

} // function crearUsuario

