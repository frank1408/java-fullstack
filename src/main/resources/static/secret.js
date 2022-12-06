
/*
Franklin Rodriguez
frank14082013@gmail.com
*/

const URL_API = "http://localhost:8000";

async function crearUsuario() {

	let unombre     = document.getElementById("unombre");
	let uapellido   = document.getElementById("uapellido");
	let ucorreo     = document.getElementById("ucorreo");
	let utelefono   = document.getElementById("utelefono");
	let ucontrasena = document.getElementById("ucontrasena");

	const datosNewUser = {
	"nombre":     unombre.value,
	"apellido":   uapellido.value,
	"correo":     ucorreo.value,
	"telefono":   utelefono.value,
	"contrasena": ucontrasena.value
	};
	const dataSend = JSON.stringify( datosNewUser );

	const urlApi = URL_API + "/api/usuarios";

	const objetoInfo = {

    mode: 'same-origin',/* no-cors same-origin */
	method: "POST",
	headers: {
		"Access-Control-Allow-Origin": "*",
    	"Access-Control-Allow-Methods": "*",
    	"Access-Control-Allow-Headers": "*",
	    "Accept": "application/json",
	    "Content-Type": "application/json"
	},
	body: dataSend

	}; /* objetoInfo */
	const ans = await fetch( urlApi, objetoInfo )
	const res = await ans.json();

	window.location.assign("/crear2");

} /* crearUsuario */

async function iniciarSesion() {

let datosUser = {
"id": -1,
"nombre": "",
"apellido": "",
"correo": document.getElementById("ucorreo").value,
"telefono": "",
"contrasena": document.getElementById("ucontrasena").value,
"eliminado": "0"
}; // datosUser

let urlApi = URL_API + "/api/login";

let dataSend = JSON.stringify( datosUser );

let objetoInfo = {
mode: 'same-origin',/* same-origin no-cors */
    method: "POST",
    headers: {
        "Access-Control-Allow-Methods": "*",
        "Access-Control-Allow-Headers": "*",
        "Access-Control-Allow-Origin": "*",
        "Accept": "application/json",
        "Content-Type": "application/json"
    },
    body: dataSend
}; /* objetoInfo */

fetch( urlApi, objetoInfo ).then( (response) => {
    response.text().then( (ttoken) => {
        if( ttoken != "" ){
            localStorage.token = ttoken;
            location.assign("/"); location.href = "/";
        }
    });
}).catch( (err) => {
    alert("erroooooor !\n" + err )
});

} /* function iniciarSesion */

async function cargarUsuario() {

    limpiar();
	let uid = document.getElementById("uid");
	uid = uid.value;
	const urlApi = URL_API + "/api/usuarios/" + uid;

	let objetoInfo = {
    mode: 'same-origin', /* no-cors same-origin */
	method: "GET",
	headers: {
	"Access-Control-Allow-Origin": "*",
    "Access-Control-Allow-Methods": "*",
    "Access-Control-Allow-Headers": "*",
	"Content-Type": "application/json",
	"Accept": "application/json",
	"Authorization": localStorage.token 
	}
	}; /* objetoInfo */

    let ans = {};
	fetch( urlApi, objetoInfo )
	    .then( (response) => response.json() )
	    .then( (response2) => {
	        let uusuario = response2;
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
                    let x = document.querySelector("#tusuario tbody");
                    x.innerHTML = filaUsuario;
	    })
	    .catch( (err) => {
        	    alert( err );
        	});
} // function cargarUsuario

function limpiar(){
	let x = document.querySelector("#tusuario tbody");
	x.innerHTML = "";
}

async function cargarUsuarios() {
	const urlApi = URL_API + "/api/usuarios";
	const objetoInfo = {
    mode: "cors",/* no-cors same-origin */
	method: "GET",
	headers: {
        "Access-Control-Allow-Origin": "*",
        "Access-Control-Allow-Methods": "*",
        "Access-Control-Allow-Headers": "*",
	    "Accept": "application/json",
        "Content-Type": "application/json",
	    "Authorization": localStorage.token
	}
	}; /* objetoInfo */

	try{
	const ans = await fetch( urlApi, objetoInfo );
	const res = await ans.json();
    limpiar();

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
    let x = document.querySelector("#tusuario tbody");
	x.innerHTML += filaUsuario;
	} // for

	}catch(err){
		alert("acceso denegado, debes iniciar sesion y tener permiso !");
	}

} // function cargarUsuarios

async function deleteUsuario( id ) {

if(
confirm(
"Eliminar usuario con id: " + id
)
){
const urlApi = URL_API + "/api/usuarios/" + id;

const objetoInfo = {
mode: 'cors',/* no-cors same-origin*/
method: "DELETE",
headers: {
"Access-Control-Allow-Origin": "*",
"Access-Control-Allow-Methods": "*",
"Access-Control-Allow-Headers": "*",
"Content-Type": "application/json",
"Accept": "application/json",
"Authorization": localStorage.token 
}}; // objetoInfo

try{
const ans = await fetch( urlApi, objetoInfo );
const res = ans.json();
location.reload();
}catch(err){ alert("err: " + err); }

} // if confirm eliminar usuario con ID

} // function deleteUsuario
