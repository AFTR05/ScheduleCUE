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
        console.log(admin);
}
async function getStudents() {
    const request = await fetch('student_ad/get-all', {
        method: 'GET',
        headers: getHeaders()
    });
    const students = await request.json();
    console.log(students);
    let listadoHtml = '';
    for (let student of students){
        let studentHtml = '<tr><td>'+student.id+'</td><td>'+student.name+'</td><td>' + student.email +'</td><td>'
            + student.ownSemester.program.name+'</td><td>'+student.ownSemester.semester
            + '</td><td>'+student.ownSemester.modality.modality+'</td><td>'+student.active+'</td></tr>';
        console.log(studentHtml);
        listadoHtml += studentHtml;
    }
    console.log(listadoHtml);
    document.querySelector('#students-content').innerHTML = listadoHtml;
}

async function getTeacher(){
    const request = await fetch('teacher_ad/get-all', {
        method: 'GET',
        headers: getHeaders()
    });
    const teachers = await request.json();
    let listadoHtml = '';
    for (let teacher of teachers){
        /*
        let teacherHtml = '<tr>' +
            '<td>'+teacher.id+'</td>' +
            '<td>'+teacher.name+'</td>' +
            '<td>' + teacher.email + '</td>' +
            '<td>'+teacher.active+'</td>' +
            '</tr>';

         */

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
    console.log(rooms);
    let listadoHtml = '';
    for (let room of rooms){
        let roomHtml = '<tr><td>'+room.name+'</td><td>'+room.campus+'</td><td>'
            + room.capacity + '</td><td>'+room.equitmentRoom.id+'</td><td>'+room.active+'</td></tr>';
        console.log(roomHtml);
        listadoHtml += roomHtml;
    }
    console.log(listadoHtml);
    document.querySelector('#rooms-content').innerHTML = listadoHtml;
}

async function getSubject(){
    const request = await fetch('subject_ad/get-all', {
        method: 'GET',
        headers: getHeaders()
    });
    const subjects = await request.json();
    console.log(subjects);
    let listadoHtml = '';
    for (let subject of subjects){
        let subjectHtml = '<tr><td>'+subject.name+'</td><td>'+subject.typeSubject.typeSubject+'</td><td>'
            + subject.durationType.type + '</td><td>'+subject.countSemanalHours+'</td></tr>';
        console.log(subjectHtml);
        listadoHtml += subjectHtml;
    }
    console.log(listadoHtml);
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
        let adminHtml = '<tr><td>'+admin.id+'</td><td>'+admin.name+'</td><td>' + admin.email +'</td><td>'
            + admin.typeAdmin.typeAdmin+'</td><td>'+admin.active+'</td></tr>';
        console.log(adminHtml);
        listadoHtml += adminHtml;
    }
    console.log(listadoHtml);
    document.querySelector('#admins-content').innerHTML = listadoHtml;
}


function insertHourAndDays(){
    var contenidoPila = ()=>{
        let content = "";
        let arrayHoras = ["6 am","7 am","8 am" ,"9 am ",
            "10 am","11 am","12 pm","1 pm "," 2pm "," 3 pm ",
            "4 pm "," 5 pm "," 6 pm "," 7 pm "," 8 pm ",
            "9 pm"," 10 pm ","11 pm"]
        for(let i=0;i<arrayHoras.length;i++){
            content += `<tr class="tr-body">
                 <th>`+arrayHoras[i]+`</th>
                 <td onclick="showCard(event)">Mat</td>
                 <td onclick="showCard(event)">Mat</td>
                 <td onclick="showCard(event)">Mat</td>
                 <td onclick="showCard(event)">Mat</td>
                 <td onclick="showCard(event)">Mat</td>
                 <td onclick="showCard(event)">Mat</td>
                 <td onclick="showCard(event)">Mat</td>
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

