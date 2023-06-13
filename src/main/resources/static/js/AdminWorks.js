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

async function registerCourse() {
    let data = {};
    data.begin=document.getElementById('begin-txt-course').value;
    data.end = document.getElementById('end-txt-course').value;
    data.teacher = document.getElementById('teacher-txt-course').value;
    data.subject=document.getElementById('subject-txt-course').value;
    data.equitment=document.getElementById('equitment-txt-course').value;
    data.program=document.getElementById('program-txt-course').value;
    const request = await fetch('course_ad/create', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });
    navigate("admin-courses")
}
async function changePasswordAdmin(){
    let data = {};
    data.id=localStorage.id
    data.actualPassword = document.getElementById('actual-password-txt-admin').value;
    data.newPassword=document.getElementById('confirm-password-txt-admin').value;
    const request = await fetch('admin_ad/update', {
        method: 'PUT',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });
    navigate("admin-profile")
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

function getHeaders() {
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Authorization': localStorage.token
    };
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
async function generateHours(){
    const request = await fetch('schedule_ad/create-schedule', {
        method: 'PUT',
        headers:getHeaders()
    });
    const response=await request.json();
    Swal.fire({
        icon: 'success',
        title: 'Generación exitosa',
        text: 'Generación exitosa de los horarios!',
    })
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