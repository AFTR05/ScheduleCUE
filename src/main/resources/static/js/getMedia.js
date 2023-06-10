export async function getStudents() {
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
}

export async function getTeacher(){
    const request = await fetch('teacher_ad/get-all', {
        method: 'GET',
        headers: getHeaders()
    });
    const teachers = await request.json();
    console.log(teachers);
    let listadoHtml = '';
    for (let teacher of teachers){
        let teacherHtml = '<tr><td>'+teacher.name+'</td><td>' + teacher.email + '</td><td>'+teacher.active+'</td></tr>';
        console.log(teacherHtml);
        listadoHtml += teacherHtml;
    }
    console.log(listadoHtml);
    document.querySelector('#teachers-content').innerHTML = listadoHtml;
}

export async function getAdministrator(){
    const request = await fetch('admin_ad/get-all', {
        method: 'GET',
        headers: getHeaders()
    });
    const admins = await request.json();
    console.log(admins);
    let listadoHtml = '';
    for (let admin of admins){
        let adminHtml = '<tr><td>'+admin.name+'</td><td>' + admin.email +'</td><td>'
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