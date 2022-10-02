

$(document).ready(function() {

cargarUsuarios();

// $('#dataTable').DataTable();

});





async function cargarUsuarios() {

const urlApi = "http://localhost:8080/api/usuarios";

const objetoInfo = {

mode: 'no-cors', // no-cors, cors, same-origin
method: "GET",
headers: {
"Access-Control-Allow-Origin": "*",
"Access-Control-Allow-Methods": "*",
"Access-Control-Allow-Headers": "*",
"Content-Type": "application/json",
"Accept": "application/json"
},
cache: 'no-cache',

}; // objetoInfo

let ans = await fetch( urlApi, objetoInfo );
ans = await ans.json();

let x = document.querySelector("#dataTable tbody");
x.innerHTML = "";

for( let uusuario of ans ) {

let filaUsuario = `
<tr>
<td>
${uusuario.id}
</td>
<td>
${uusuario.nombre} ${uusuario.apellido}
</td>
<td>
${uusuario.email}
</td>
<td>
${uusuario.telefono}
</td>

<td><a href="#" onclick="deleteUsuario(${uusuario.id})" class="btn btn-danger btn-circle"><i class="fas fa-trash"></i></a></td>
</tr>
`;

x.innerHTML += filaUsuario;

} // for

} // function cargarUsuarios











async function deleteUsuario( id ) {


if(
confirm(
"Eliminar usuario con id: " + id
)
){
	const urlApi = "http://localhost:8080/api/usuarios/" + id;

	const objetoInfo = {
	mode: 'cors', // no-cors, cors, same-origin
	method: "DELETE",
	headers: {
		"Access-Control-Allow-Origin": "*",
		"Access-Control-Allow-Methods": "*",
		"Access-Control-Allow-Headers": "*",
		"Content-Type": "application/json",
		"Accept": "application/json"
	},
	cache: 'no-cache',
	
	}; // objetoInfo
	
	await fetch( urlApi, objetoInfo );
	location.reload();

} // if confirm eliminar usuario con ID

} // function deleteUsuario


