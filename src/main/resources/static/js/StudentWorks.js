async function changePasswordStudent(){
    let data = {};
    data.id=localStorage.id
    data.actualPassword = document.getElementById('actual-password-txt-student').value;
    data.newPassword=document.getElementById('confirm-password-txt-student').value;
    const request = await fetch('student_ad/update', {
        method: 'PUT',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });
    navigate("student-profile")
}