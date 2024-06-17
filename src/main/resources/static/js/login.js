// Call the dataTables jQuery plugin
$(document).ready(function() {
    // on ready
});

async function iniciarSesion(){

    let datos = {};

    datos.email = document.getElementById('txtEmail').value;
    datos.password = document.getElementById('txtPassword').value;

    const request = await fetch('api/formularioLogin', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });

    const respuesta = await request.json();

    if (respuesta.OK) {  // == 'OK'
        window.location.href = '/dashboard' //'usuarios.html'
    } else {
        alert("los datos proporcionados son incorrectos. Intente de nuevo, por favor.");
    }
}
