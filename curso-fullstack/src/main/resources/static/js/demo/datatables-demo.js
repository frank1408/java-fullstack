
// Call the dataTables jQuery plugin
$(document).ready(function() {
cargarUsuarios();
$('#dataTable').DataTable();
});


// error CORS
// https://stackoverflow.com/questions/43871637/no-access-control-allow-origin-header-is-present-on-the-requested-resource-whe



async function cargarUsuarios() {

const urlApi = "http://localhost:8080/usuariofijo/1";

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
console.log( ans );

//const resultadoUsuarios = await getRequest.json();
//console.log( resultadoUsuarios );

} // function cargarUsuarios
