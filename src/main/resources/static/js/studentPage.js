$(document).ready(function() {
    $('#student-schedule').addClass('active');
    navigate('student-schedule');
});
function navigate(page) {
    $('.nav-link').removeClass('active');
    $('#' + page).addClass('active');

    $.ajax({
        url:'student/'+ page + '.html',
        method: 'GET',
        success: function(response) {
            $('#content').html(response);
            switch (page) {
                case 'student-profile':
                    justStudent(localStorage.id);
                    break;
            }
        },
        error: function() {
            $('#content').html('Error al cargar la página.');
        }
    });
}

document.getElementById("student-profile").onclick = function() {
    navigate('student-profile');
};

document.getElementById("student-schedule").onclick = function() {
    navigate('student-schedule');
};

async function justStudent(id) {
    const url = `student_ad/get-by-id/${id}`;
    const response = await fetch(url, {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
    const student = await response.json();
    document.querySelector('#email-txt-profile-student').value=student.email;
    document.querySelector('#username-txt-profile-student').value=student.name;
    console.log(student);
}