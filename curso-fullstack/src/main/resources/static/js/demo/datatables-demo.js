

$(document).ready(function() {

cargarUsuarios();

// $('#dataTable').DataTable();

});





async function cargarUsuarios() {

const urlApi = "http://localhost:8080/usuarios";

const objetoInfo = {

mode: 'no-cors', // no-cors, cors, same-origin
method: "GET", // GET, POST, PUT, DELETE
headers: {
"Access-Control-Allow-Origin": "*",
"Access-Control-Allow-Methods": "*", //"GET, POST, PUT, DELETE, OPTIONS",
"Access-Control-Allow-Headers": "*",
"Content-Type": "application/json", // text/plain, application/x-www-form-urlencoded, multipart/form-data
"Accept": "application/json"
},
cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
//credentials: 'same-origin', // include, *same-origin, omit
//referrerPolicy: 'no-referrer', // no-referrer, *no-referrer-when-downgrade, origin, origin-when-cross-origin, same-origin, strict-origin, strict-origin-when-cross-origin, unsafe-url
//body: JSON.stringify(  {a: 1, b: "hola"}  ) // body data type must match "Content-Type" header

}; // objetoInfo

//debugger;

let ans = await fetch( urlApi, objetoInfo );
ans = await ans.json();

//console.log( ans ); // hide-this

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

<td><a href="#" class="btn btn-danger btn-circle"><i class="fas fa-trash"></i></a></td>
</tr>
`;

x.innerHTML += filaUsuario;

} // for

} // function cargarUsuarios


