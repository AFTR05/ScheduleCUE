
var data;
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
    let td;
    let id;
    switch (element){
        case 'teacher':
            td = event.target.parentNode.parentNode.children
            id = td[0].innerHTML;
            deleteTeacher(id);
            break;
        case 'student':
            td = event.target.parentNode.parentNode.children
            id = td[0].innerHTML;
             deleteStudent(id);
            break;
        case 'room':
            td = event.target.parentNode.parentNode.children
            id = td[0].innerHTML;
            deleteRoom(id,td);
            break;
        case 'admin':
            td = event.target.parentNode.parentNode.children
            id = td[0].innerHTML;
            deleteAdmin(id);
            break;
        default:
            break;
    }
}

function updateF(element,event) {
    let td;
    let id;
    switch (element) {
        case 'teacher':
            td = event.target.parentNode.parentNode.children
            id = td[0].innerHTML;
            updateTeacher(td);
            break;
        case 'student':
            td = event.target.parentNode.parentNode.children
            id = td[0].innerHTML;
            updateStudent(td);
            break;
        case 'room':
            td = event.target.parentNode.parentNode.children
            id = td[0].innerHTML;
            updateRoom(td);
            break;
        case 'admin':
            let tdd = event.target.parentNode.parentNode.children
            id = tdd[0].innerHTML;
            updateAdmin(tdd);
            break;
        default:
            break;
    }
}

async function deleteTeacher(id){
 const request = await fetch('/teacher_ad/deactivate/'+id,{
     method : 'PUT',
     headers : getHeaderCrud()
 })
}

async function updateTeacher(td){
  data = getDataTeacher(td);
  const request = await fetch('/teacher_ad/update-data-teacher',{
      method : 'PUT',
      headers : getHeaderCrud(),
      body: JSON.stringify(data)
  })
}

async function deleteStudent(id){
    const request = await fetch('/student_ad/delete-student/'+id,{
        method : 'PUT',
        headers : getHeaderCrud()
    })
}

async function  updateStudent(td){
    data = getDataStudent(td);
    const request = await fetch('/student_ad/update-data-student',{
        method : 'PUT',
        headers : getHeaderCrud(),
        body: JSON.stringify(data)
    })
}


async function updateRoom(td){
    let data = getDataRoom(td);
    let name = data.name;
    let object = {};
    let room = await findByName('/room_ad/get-by-name/',name);
    object.id = room.name+room.campus;
    room.campus = data.campus;
    room.capacity = data.capacity;
    room.equitmentRoom.id = data.idEquiment;
    object.roomRequestDTO = room;
    const request = await fetch('/room_ad/update',{
        method : 'PUT',
        headers : getHeaderCrud(),
        body:JSON.stringify(object)
    })
}

async function deleteRoom(id,td){
  let data = getDataRoom(td);
  let name = data.name;
  let room = await findByName('/room_ad/get-by-name/',name);
  let object = {};
  object.id = room.name+room.campus;
  object.roomRequestDTO = room;
  const request = await fetch('/room_ad/changeActive',{
      method:'PUT',
      headers:getHeaderCrud(),
      body:JSON.stringify(object)
  })
}

async function updateAdmin(td){
    data = getDataAdmin(td);
    const request = await fetch('/admin_ad/update-data-admin',{
            method : 'PUT',
            headers : getHeaderCrud(),
            body: JSON.stringify(data)
        })
}

async function deleteAdmin(id){
    const request = await fetch('/admin_ad/delete-admin/'+id,{
        method : 'PUT',
        headers : getHeaderCrud()
    })
}

function getHeaderCrud(){
    return {
        'Accept':'application/json',
        'Content-Type': 'application/json'
    }
}

function getDataTeacher(td){
    return {
        id:td[0].innerHTML,
        name: td[1].querySelector('input').value,
        email:td[2].querySelector('input').value
    }
}

function getDataStudent(td){
    return {
        id:td[0].innerHTML,
        name: td[1].querySelector('input').value,
        email:td[2].querySelector('input').value
    }
}

function getDataAdmin(td){
    console.log(td);
    console.log(td[0].innerHTML);
    return {
        id:td[0].innerHTML,
        name:td[1].querySelector('input').value,
        email:td[2].querySelector('input').value
    }
}

function getDataRoom(td){
    return {
            name:td[0].innerHTML,
            campus:td[1].querySelector('input').value,
            capacity:parseInt(td[2].querySelector('input').value),
            idEquiment:td[3].querySelector('input').value
        }

}

async function findByName(url,name){
    const request = await fetch(url+name,{
        method : 'GET',
        headers : getHeaderCrud()
    })
    return await request.json();
}