// Call the dataTables jQuery plugin
$(document).ready(function() {

  cargarUsuarios();

  $('#usuarios').DataTable();});

async function cargarUsuarios(){

    const request = await fetch('api/usuarios', {
      method: 'GET',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
    });
    const usuarios = await request.json();

    let listadoHtml = "";

    for (let usuario of usuarios){

      let botonEliminar = '<a href=\"#\" onclick = "eliminarUsuario('+ usuario.id +')" class=\"btn btn-danger btn-circle btn-sm\">\n' +
            '<i class=\"fas fa-trash\"></i>\n' +
            '</a>\n';
      let telefonoTexto = usuario.telefono == null ? '-': usuario.telefono;
      let usuarioHtml = '<tr>\n' +
          '<td>'+ usuario.id +'</td>\n' +
          '<td>'+ usuario.nombre +' '+ usuario.apellido +'</td>\n' +
          '<td>'+ usuario.email +'</td>\n' +
          '<td>'+ telefonoTexto +'</td>\n' +
          '<td>'+ botonEliminar +'</td>\n' +
          '</tr>';
      listadoHtml += usuarioHtml;
    }
    console.log(usuarios);

    document.querySelector('#usuarios tbody').outerHTML = listadoHtml;
}
async function eliminarUsuario(id){

    if (!confirm('¿Desea eliminar este usuario?')){
        return;
    }
    const request = await fetch('api/usuarios/' + id, {
        method: 'DELETE',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
    location.reload();
}
