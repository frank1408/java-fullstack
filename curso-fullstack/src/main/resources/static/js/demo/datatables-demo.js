
// Call the dataTables jQuery plugin
$(document).ready(function() {
cargarUsuarios();
$('#dataTable').DataTable();
});


// error CORS
// https://stackoverflow.com/questions/43871637/no-access-control-allow-origin-header-is-present-on-the-requested-resource-whe



async function cargarUsuarios() {

const urlApi = "http://127.0.0.1:8080/usuariofijo";

const objetoInfo = {

method: "GET",

headers: {
"Accept": "application/json",
"Content-Type": "application/json",
"Access-Control-Allow-Origin": "*",
"Access-Control-Allow-Methods": "GET",
"Access-Control-Allow-Headers": "Content-Type, Authorization"
}

};

const getRequest = await fetch( urlApi, objetoInfo );

const resultadoUsuarios = await getRequest.json();

//debugger;
console.log( resultadoUsuarios );


} // function cargarUsuarios
