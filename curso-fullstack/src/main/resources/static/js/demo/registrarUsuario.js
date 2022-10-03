//"use strict"
//debugger;
//console.log("hola");
//alert("Hola mundo");
//prompt("dame info");
//confirm("dime si o no");

async function crearUsuario() {
debugger;

let uunombre    = document.getElementById("unombre");
let uuapellido  = document.getElementById("uapellido");
let uuemail     = document.getElementById("uemail");
let uutelefono  = document.getElementById("utelefono");
let uupassword  = document.getElementById("upassword");
let uupassword2 = document.getElementById("upassword2");

/*
let nombreCampos = [
uunombre,
uuapellido,
uuemail,
uutelefono,
uupassword,
uupassword2
];

for( let campoN of nombreCampos ) {
if( campoN.value == null || campoN.value.length > 2 ){

alert("Completa todos los campos !");
alert("Longitud minima de 2 caracteres !");
return;

} // if
} // validacion de campos
*/



/*
uunombre.value = String(uunombre.value);
uuapellido.value = String(uuapellido.value);
uuemail.value = String(uuemail.value);
uutelefono.value = Math.abs(Number.parseInt(uutelefono.value,10));
uupassword.value = String(uupassword.value);
uupassword2.value = String(uupassword2.value);
*/

if(
uunombre.value == null || uunombre.value == undefined
|| 
uuapellido.value == null || uuapellido.value == undefined
|| 
uuemail.value == null || uuemail.value == undefined
|| 
uutelefono.value == null || uutelefono.value == undefined
|| 
uupassword.value == null || uupassword.value == undefined
|| 
uupassword2.value == null || uupassword2.value == undefined
){
await alert("Completa todos los campos, deben llenarse !");
return;
}

if( uupassword.value !== uupassword2.value ) {
await alert("Los password no coinciden, deben ser iguales");
return;
} // validar password match



let datosNewUser = {
"nombre": uunombre.value,
"apellido": uuapellido.value,
"email": uuemail.value,
"telefono": uutelefono.value,
"password": uupassword.value
};
console.log( datosNewUser );






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

//let ans = await fetch( urlApi, objetoInfo );
//ans = await ans.json();

} // function crearUsuario

