$(document).ready(function() {
    $('#teacher-schedule').addClass('active');
    navigate('teacher-schedule');
});
function navigate(page) {
    $('.nav-link').removeClass('active');
    $('#' + page).addClass('active');

    $.ajax({
        url:'teacher/'+ page + '.html',
        method: 'GET',
        success: function(response) {
            $('#content').html(response);
            switch (page) {
                case 'teacher-profile':
                    justTeacher(localStorage.id);
                    getDisponibility(localStorage.id)
                    break;
            }
        },
        error: function() {
            $('#content').html('Error al cargar la página.');
        }
    });
}

document.getElementById("teacher-profile").onclick = function() {
    navigate('teacher-profile');
};

document.getElementById("teacher-schedule").onclick = function() {
    navigate('teacher-schedule');
};

async function justTeacher(id) {
    const url = `teacher_ad/get-by-id/${id}`;
    const response = await fetch(url, {
        method: 'GET',
        headers: getHeaders()
    });
    const teacher = await response.json();
    document.querySelector('#email-txt-profile-teacher').value=teacher.email;
    document.querySelector('#username-txt-profile-teacher').value=teacher.name;
    console.log(teacher);
}

async function getDisponibility(id) {
    const request = await fetch(`teacher_ad/disponibility/${id}`, {
        method: 'GET',
        headers: getHeaders()
    });
    const disponibilities = await request.json();
    console.log(disponibilities);
    let listadoHtml = '';
    for (let disponibility of disponibilities){
        let disponibilityHtml = '<tr><td>'+disponibility.day+'</td><td>'+disponibility.begin+'</td><td>' + disponibility.end+'</td></tr>';
        console.log(disponibilityHtml);
        listadoHtml += disponibilityHtml;
    }
    console.log(listadoHtml);
    document.querySelector('#disponibility-content').innerHTML = listadoHtml;
}

function getHeaders() {
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Authorization': localStorage.token
    };
}