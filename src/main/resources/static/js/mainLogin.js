async function iniciarSesion() {
    let data = {};
    data.id=document.getElementById('id-txt-login').value;
    data.password = document.getElementById('password-txt-login').value;
    const request = await fetch('/login', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });
        const respuesta = await request.json();
        if (respuesta.token !== 'FAIL') {
            const token = respuesta.token;
            localStorage.token = token;
            localStorage.id=respuesta.id;
            localStorage.role=respuesta.role;
            switch (respuesta.role) {
                case 'administrator':
                    go('admin');
                    break;
                case 'teacher':
                    go('teacher');
                    break;
                case 'student':
                    go("student");
                    break;
            }
        } else {
            alert("Las credenciales son incorrectas. Por favor intente nuevamente.");
        }
}

async function go(pag){
    const request = await fetch('/'+pag, {
        method: 'GET',
        headers: getHeaders()
    });
}
