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
