
/*
scripts para realizar y enviar peticiones a una api
*/

async function crearUsuario() {

	let unombre     = document.getElementById("unombre");
	let uapellido   = document.getElementById("uapellido");
	let ucorreo     = document.getElementById("ucorreo");
	let utelefono   = document.getElementById("utelefono");
	let ucontrasena = document.getElementById("ucontrasena");

	let datosNewUser = {
	"nombre":     unombre.value,
	"apellido":   uapellido.value,
	"correo":     ucorreo.value,
	"telefono":   utelefono.value,
	"contrasena": ucontrasena.value
	};

	const urlApi = "http://localhost:8000/api/usuarios";

	const objetoInfo = {

	/*
	mode: 'cors',
	mode: 'no-cors',
	mode: 'same-origin',
	*/
	method: "POST",
	headers: {
	/*
	"Access-Control-Allow-Origin": "*",
	"Access-Control-Allow-Methods": "*",
	"Access-Control-Allow-Headers": "*",
	*/
	"Accept": "application/json",
	"Content-Type": "application/json"
	},
	body: JSON.stringify( datosNewUser )

	}; /* objetoInfo */
	let ans = await fetch( urlApi, objetoInfo )
	let res = await ans.json();
	/*
	console.log( res );
	window.location.assign("/login.html");
	*/

} /* crearUsuario */




















async function iniciarSesion() {

let ucorreo     = document.getElementById("ucorreo");
let ucontrasena = document.getElementById("ucontrasena");

let datosUser = {
"correo":    ucorreo.value,
"contrasena": ucontrasena.value
}; // datosUser

const urlApi = "http://localhost:8000/api/login";

const objetoInfo = {
/*
mode: 'cors', // no-cors, cors, same-origin
*/
method: "POST",
headers: {
"Accept": "application/json",
"Content-Type": "application/json",
/* por motivos del cors
"Access-Control-Allow-Origin": "*",
"Access-Control-Allow-Methods": "*",
"Access-Control-Allow-Headers": "*"
*/
},
body: JSON.stringify( datosUser )
}; /* objetoInfo */

/*
const request = await fetch( urlApi, objetoInfo );
const ansB = await request.text();
console.log( await request.json() );
console.log( await request.text() );
*/


/*
const request = await fetch( urlApi, objetoInfo )
.then(response => {
console.log("response: ")
console.log( JSON.stringify(response) )
})
*/


const request = await fetch( urlApi, objetoInfo );
const ansB = await request.text();
localStorage.token = ansB;
window.location.assign("/");


/*
JSON.stringify( mmm );

if( ansB !== "" ){
alert("Bienvenido");
window.location.assign("/");
}
window.location.assign("/login.html");
console.log( ansB );
*/

} /* function iniciarSesion */



















async function cargarUsuario() {

limpiar();
	let uid = document.getElementById("uid");
	uid = uid.value;
	const urlApi = "http://localhost:8000/api/usuarios/" + uid;

	const objetoInfo = {
	/*
	mode: 'cors',
	mode: 'no-cors',
	mode: 'same-origin',
	*/
	method: "GET",
	headers: {
	/*
	"Access-Control-Allow-Origin": "*",
	"Access-Control-Allow-Methods": "*",
	"Access-Control-Allow-Headers": "*",
	*/
	"Content-Type": "application/json",
	"Accept": "application/json",
	"Authorization": localStorage.token 
	}
	}; /* objetoInfo */

	let ans = await fetch( urlApi, objetoInfo );
	if( ans == null || ans == undefined ){
	    alert("no hay usuario con ese id");
	    return -1;
	}
	/* ans = await ans.json(); */
	/* ans = await ans.text(); */

	let x = document.querySelector("#tusuario tbody");
	x.innerHTML = "";

	try{
	ans = await ans.json();
	let uusuario = ans;

	
		let filaUsuario = `
		<tr>

		<td>
		${uusuario.id}
		</td>

		<td>
		${uusuario.nombre} ${uusuario.apellido}
		</td>

		<td>
		${uusuario.correo}
		</td>

		<td>
		${uusuario.telefono}
		</td>

		<td>
		<!--
		<a href="#" onclick="deleteUsuario( ${uusuario.id} )">DELETE</a>
		-->
		</td>
		</tr>
		`;
		x.innerHTML += filaUsuario;

		}catch( err ){
			alert("404 Not found");
			/*console.log( err );*/
		} /* catch */


} // function cargarUsuario

function limpiar(){
	let x = document.querySelector("#tusuario tbody");
	x.innerHTML = "";
}



























async function cargarUsuarios() {
	const urlApi = "http://localhost:8000/api/usuarios";
	const objetoInfo = {
	/*
	mode: 'cors', // no-cors, cors, same-origin
	*/
	method: "GET",
	headers: {
	/*
	"Access-Control-Allow-Origin": "*",
	"Access-Control-Allow-Methods": "*",
	"Access-Control-Allow-Headers": "*",
	*/
	"Content-Type": "application/json",
	"Accept": "application/json",
	"Authorization": localStorage.token 
	}
	}; /* objetoInfo */

	try{
	let ans = await fetch( urlApi, objetoInfo );
	let res = await ans.json();
	/*
	console.log("res: ");
	console.log(res);
	*/

	let x = document.querySelector("#tusuario tbody");
	x.innerHTML = "";

	for( let uusuario of res ) {

	let filaUsuario = `
	<tr>

	<td>
	${uusuario.id}
	</td>

	<td>
	${uusuario.nombre} ${uusuario.apellido}
	</td>

	<td>
	${uusuario.correo}
	</td>

	<td>
	${uusuario.telefono}
	</td>

	<td>
	<a href="#" onclick="deleteUsuario( ${uusuario.id} )">DELETE</a>
	</td>
	</tr>
	`;
	x.innerHTML += filaUsuario;
	} // for

	}catch(err){
		alert("acceso denegado");
	}

} // function cargarUsuarios

























async function deleteUsuario( id ) {

if(
confirm(
"Eliminar usuario con id: " + id
)
){
const urlApi = "http://localhost:8000/api/usuarios/" + id;

const objetoInfo = {
/*
mode: 'cors', // no-cors, cors, same-origin
*/
method: "DELETE",
headers: {
/*
"Access-Control-Allow-Origin": "*",
"Access-Control-Allow-Methods": "*",
"Access-Control-Allow-Headers": "*",
*/
"Content-Type": "application/json",
"Accept": "application/json",
"Authorization": localStorage.token 
}
/*
cache: 'no-cache',
*/

}; // objetoInfo

try{
let ans = await fetch( urlApi, objetoInfo );
let res = ans.json();
location.reload();
}catch(err){
alert("err: " + err);
}

} // if confirm eliminar usuario con ID

} // function deleteUsuario














