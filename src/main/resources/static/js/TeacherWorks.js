async function changePasswordTeacher(){
    let data = {};
    data.id=localStorage.id
    data.actualPassword = document.getElementById('actual-password-txt-teacher').value;
    data.newPassword=document.getElementById('confirm-password-txt-teacher').value;
    const request = await fetch('teacher_ad/update', {
        method: 'PUT',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });
    navigate("teacher-profile")
}