async function registrarProfesores() {
    let datos = {};
    datos.id=document.getElementById('id-txt-teachers').value;
    datos.name = document.getElementById('username-txt-teachers').value;
    datos.email = document.getElementById('email-txt-teachers').value;
    datos.availability=[];
    datos.courses=[];
    datos.active=true;
    const request = await fetch('teacher_ad/create', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });
    navigate("admin-teachers")
}

async function registrarAdministrador() {
    let data = {};
    data.id=document.getElementById('id-txt-admins').value;
    data.name = document.getElementById('username-txt-admins').value;
    data.email = document.getElementById('email-txt-admins').value;
    data.typeAdmin=document.getElementById('type-txt-admins').value;
    data.active=true;
    const request = await fetch('admin_ad/create', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });
    navigate("admin-admins")
}
async function registrarStudent() {
    let data = {};
    data.id=document.getElementById('id-txt-students').value;
    data.name = document.getElementById('username-txt-students').value;
    data.email = document.getElementById('email-txt-students').value;
    data.modality=document.getElementById('modal-txt-students').value;
    data.semester=document.getElementById('semester-txt-students').value;
    data.program=document.getElementById('program-txt-students').value
    data.active=true;
    const request = await fetch('student_ad/create', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });
    navigate("admin-students")
}

async function registrarRoom() {
    let data = {};
    data.name = document.getElementById('name-txt-rooms').value;
    data.capacity = document.getElementById('capacity-txt-rooms').value;
    data.campus=document.getElementById('campus-txt-rooms').value;
    data.equitmentRoom=document.getElementById('equitment-txt-rooms').value;
    data.active=true;
    const request = await fetch('room_ad/create', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });
    navigate("admin-rooms")
}

async function registrarSubject() {
    let data = {};
    data.name = document.getElementById('name-txt-subjects').value;
    data.typeSubject = document.getElementById('type-txt-subjects').value;
    data.durationType=document.getElementById('duration-txt-subjects').value;
    data.countSemanalHours=document.getElementById('hours-txt-subjects').value;
    const request = await fetch('subject_ad/create', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });
    navigate("admin-subjects")
}

function deleleF(element,event){
    let id;
    switch (element){
        case 'teacher':
             id = event.target.parentNode.parentNode.children[0].innerHTML;
             deleteTeacher(id);
            break
        case 'student':
             id = event.target.parentNode.parentNode.children[0].innerHTML;
             deleteStudent(id);
            break
        default:
            break;
    }
}

function updateF(element,event) {
    let id;
    switch (element) {
        case 'teacher':
            id = event.target.parentNode.parentNode.children[0].innerHTML;
            updateTeacher(id);
            break
        case 'student':
            id = event.target.parentNode.parentNode.children[0].innerHTML;
            updateStudent(id);
            break
        default:
            break;
    }
}

function deleteTeacher(id){

}

function updateTeacher(id){
    console.log(id)
}

function deleteStudent(id){

}

function  updateStudent(id){

}