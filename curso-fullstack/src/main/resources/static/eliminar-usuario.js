
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
"Accept": "application/json",
"Authorization": localStorage.token 
}
//cache: 'no-cache',

}; // objetoInfo

await fetch( urlApi, objetoInfo );
location.reload();

} // if confirm eliminar usuario con ID

} // function deleteUsuario


