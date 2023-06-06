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
document.getElementById("teacher-reserve").onclick = function() {
    navigate('teacher-reserve');
};
