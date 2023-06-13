/*async function cargarStudents() {
    const request = await fetch('student_ad/get-all', {
        method: 'GET',
        headers: getHeaders()
    });
    const students = await request.json();
    console.log(students);
    let listadoHtml = '';
    for (let student of students){
        let studentHtml = '<tr><td>'+student.name+'</td><td>' + student.email +'</td><td>'
            + student.ownSemester.program.name+'</td><td>'+student.ownSemester.semester
            + '</td><td>'+student.active+'</td></tr>';
        console.log(studentHtml);
        listadoHtml += studentHtml;
    }
    console.log(listadoHtml);
    document.querySelector('#students-content').innerHTML = listadoHtml;
}*/
$(document).ready(function() {
    $('#admin-schedules').addClass('active');
    navigate('admin-schedules');
});

function navigate(page) {
    $('.nav-link').removeClass('active');
    $('#' + page).addClass('active');

    $.ajax({
        url:'../admin/'+ page + '.html',
        method: 'GET',
        success: function(response) {
            $('#content').html(response);
            switch (page) {
                case 'admin-schedules':
                    insertHourAndDays();
                    setWeek();
                    break;
                case 'admin-students':
                     getStudents();
                    break;
                case 'admin-admins':
                     getAdministrator();
                    break;
                case 'admin-teachers':
                    getTeacher();
                    break;
                case 'admin-rooms':
                    getRoom();
                    break;
                case 'admin-subjects':
                    getSubject();
                    break;
                case 'admin-profile':
                    justAdmin(localStorage.id);
                    break
            }
/*            if (page === 'admin-students') {
                cargarStudents();
            }*/
        },
        error: function() {
            $('#content').html('Error al cargar la página.');
        }
    });
}

document.getElementById("admin-courses").onclick = function() {
    navigate('admin-courses');
};

document.getElementById("admin-profile").onclick = function() {
    navigate('admin-profile');
};

document.getElementById("admin-rooms").onclick = function() {
    navigate('admin-rooms');
};

document.getElementById("admin-schedules").onclick = function() {
    navigate('admin-schedules');
};

document.getElementById("admin-students").onclick = function() {
    navigate('admin-students');
};

document.getElementById("admin-admins").onclick = function() {
    navigate('admin-admins');
};

document.getElementById("admin-subjects").onclick = function() {
    navigate('admin-subjects');
};

document.getElementById("admin-teachers").onclick = function() {
    navigate('admin-teachers');
};

function getHeaders() {
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Authorization': localStorage.token
    };
}
async function justAdmin(id) {
    const url = `admin_ad/get-by-id/${id}`;
    const response = await fetch(url, {
        method: 'GET',
        headers: getHeaders()
    });
        const admin = await response.json();
        document.querySelector('#email-txt-admin-profile').value=admin.email;
        document.querySelector('#username-txt-admin-profile').value=admin.name;
        document.querySelector('#type-txt-admin-profile').value=admin.typeAdmin.typeAdmin;
}
async function getStudents() {
    const request = await fetch('student_ad/get-all', {
        method: 'GET',
        headers: getHeaders()
    });
    const students = await request.json();
    console.log(students)
    let listadoHtml = '';
    for (let student of students){
        let studentHtml = `<tr>
            <td>`+student.id+`</td>
            <td><input type="text" value="${student.name}"></td>
            <td><input type="text" value="${student.email}"></td>
            <td><input type="text" value="${student.ownSemester.program.name}"></td>
            <td><input type="text" value="${student.ownSemester.semester}"></td>
            <td><input type="text" value="${student.ownSemester.modality.modality}"></td>
            <td><input type="text" value="${student.active}"></td>
            <td>
            <span class="material-symbols-outlined" onclick="deleleF('student',event)">delete</span>
            <span class="material-symbols-outlined" onclick="updateF('student',event)">save</span>
            </td>
            </tr>`;
        listadoHtml += studentHtml;
    }
    document.querySelector('#students-content').innerHTML = listadoHtml;
}

async function getTeacher(){
    const request = await fetch('teacher_ad/get-all', {
        method: 'GET',
        headers: getHeaders()
    });
    const teachers = await request.json();
    console.log(teachers);
    let listadoHtml = '';
    for (let teacher of teachers){
        let teacherHtml = `<tr>
             <td>`+teacher.id+`</td>
             <td><input type="text" value="${teacher.name}"></td>
             <td><input type="text" value="${teacher.email}"></td>
             <td><input type="text" value="${teacher.active}"></td>
             <td>
             <span class="material-symbols-outlined" onclick="deleleF('teacher',event)">delete</span>
             <span class="material-symbols-outlined" onclick="updateF('teacher',event)">save</span>
             </td>
             </tr>`
        listadoHtml += teacherHtml;
    }
    document.querySelector('#teachers-content').innerHTML = listadoHtml;
}

async function getRoom(){
    const request = await fetch('room_ad/get-all', {
        method: 'GET',
        headers: getHeaders()
    });
    const rooms = await request.json();
    console.log(rooms)
    let listadoHtml = '';
    for (let room of rooms){
        let roomHtml = `<tr>
                  <td>`+room.name+`</td>
                  <td><input type="text" value="${room.campus}"></td>
                  <td><input type="text" value="${room.capacity}"></td>
                  <td><input type="text" value="${room.equitmentRoom.id}"></td>
                  <td><input type="text" value="${room.active}"></td>
                  <td>
                   <span class="material-symbols-outlined" onclick="deleleF('room',event)">change_circle</span>
                   <span class="material-symbols-outlined" onclick="updateF('room',event)">save</span>
                  </td>
                  </tr>`
        listadoHtml += roomHtml;
    }
    document.querySelector('#rooms-content').innerHTML = listadoHtml;
}

async function getSubject(){
    const request = await fetch('subject_ad/get-all', {
        method: 'GET',
        headers: getHeaders()
    });
    const subjects = await request.json();
    console.log(subjects)
    let listadoHtml = '';
    for (let subject of subjects){
        let subjectHtml = `<tr> 
            <td>`+subject.name+`</td>
            <td>`+subject.typeSubject.typeSubject+`</td>
            <td>` + subject.durationType.type + `</td>
            <td>`+subject.countSemanalHours+`</td>
            </tr>`;
        listadoHtml += subjectHtml;
    }
    document.querySelector('#subjects-content').innerHTML = listadoHtml;
}

async function getAdministrator(){
    const request = await fetch('admin_ad/get-all', {
        method: 'GET',
        headers: getHeaders()
    });
    const admins = await request.json();
    console.log(admins);
    let listadoHtml = '';
    for (let admin of admins){
        let adminHtml = `<tr>
            <td>`+admin.id+`</td>
            <td><input type="text" value="${admin.name}"></td>
            <td><input type="text" value="${admin.email}"></td>
            <td><input type="text" value="${admin.typeAdmin.typeAdmin}"></td>
            <td><input type="text" value="${admin.active}"></td>
            <td>
                <span class="material-symbols-outlined" onclick="deleleF('admin',event)">delete</span>
                <span class="material-symbols-outlined" onclick="updateF('admin',event)">save</span>
            </td>
            </tr>
            `
        listadoHtml += adminHtml;
    }
    document.querySelector('#admins-content').innerHTML = listadoHtml;
}


function insertHourAndDays(){
    const contenidoPila = ()=>{
        let content = "";
        let arrayHoras = ["6:00","7:00","8:00" ,"9:00",
            "10:00","11:00","12:00","13:00"," 14:00"," 15:00",
            "16:00"," 17:00"," 18:00"," 19:00"," 20:00",
            "21:00"," 22:00","23:00"]
        for(let i=0;i<arrayHoras.length;i++){
            content += `<tr class="tr-body">
                 <th>`+arrayHoras[i]+`</th>
                 <td id="Lun-${arrayHoras[i]}-${arrayHoras[i+1]}" onclick="showCard(event)">Mat</td>
                 <td id="Mar-${arrayHoras[i]}-${arrayHoras[i+1]}"  onclick="showCard(event)">Mat</td>
                 <td id="Mie-${arrayHoras[i]}-${arrayHoras[i+1]}"  onclick="showCard(event)">Mat</td>
                 <td id="Jue-${arrayHoras[i]}-${arrayHoras[i+1]}"  onclick="showCard(event)">Mat</td>
                 <td id="Vie-${arrayHoras[i]}-${arrayHoras[i+1]}"  onclick="showCard(event)">Mat</td>
                 <td id="Sab-${arrayHoras[i]}-${arrayHoras[i+1]}"  onclick="showCard(event)">Mat</td>
                 <td id="Dom-${arrayHoras[i]}-${arrayHoras[i+1]}"  onclick="showCard(event)">Mat</td>
               </tr>
   `
        }
        return content;
    }
    document.querySelector('#table-body').innerHTML = contenidoPila();
}

function getHeaders() {
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Authorization': localStorage.token
    };
}

