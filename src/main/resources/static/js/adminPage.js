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

document.getElementById("admin-reserve").onclick = function() {
    navigate('admin-reserve');
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

document.getElementById("admin-subjects").onclick = function() {
    navigate('admin-subjects');
};

document.getElementById("admin-teachers").onclick = function() {
    navigate('admin-teachers');
};
