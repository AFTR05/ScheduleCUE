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
                case 'admin-students':
                     getStudents();
                    break;
                case 'admin-admins':
                     getAdministrator();
                    break;
                case 'admin-teachers':
                    getTeacher();
                    break;
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
    console.log(teachers);
    let listadoHtml = '';
    for (let teacher of teachers){
        let teacherHtml = '<tr><td>'+teacher.id+'</td><td>'+teacher.name+'</td><td>'
            + teacher.email + '</td><td>'+teacher.active+'</td></tr>';
        console.log(teacherHtml);
        listadoHtml += teacherHtml;
    }
    console.log(listadoHtml);
    document.querySelector('#teachers-content').innerHTML = listadoHtml;
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

function getHeaders() {
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Authorization': localStorage.token
    };
}