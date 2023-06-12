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
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
    const teacher = await response.json();
    document.querySelector('#email-txt-profile-teacher').value=teacher.email;
    document.querySelector('#username-txt-profile-teacher').value=teacher.name;
    console.log(teacher);
}