function filter() {
    let element = document.getElementById('subjects-content');
    let input = document.getElementById('input-search');
    mergeFilter(element,input);
}

function filterRoom() {
    let element = document.getElementById('rooms-content');
    let input = document.getElementById('input-search-room');
    mergeFilter(element,input)
}

function filterTeacher(){
    let element = document.getElementById('teachers-content');
    let input = document.getElementById('input-search-teacher');
    mergeFilter(element,input)
}

function filterStudent(){
    let element = document.getElementById('students-content');
    let input = document.getElementById('input-search-student');
    mergeFilter(element,input)
}

function filterAdmin(){
    let element = document.getElementById('admins-content');
    let input = document.getElementById('input-search-admin');
    mergeFilter(element,input)
}

function mergeFilter(element,input){
    let colection = null;
    let tr;
    let textValue;
    if (element.innerHTML !== "" && input.value !== null){
        let value = input.value;
        colection = element.children;
        for (let i = 0; i<colection.length;i++){
            tr = colection[i].children;
            textValue = tr[0].innerHTML;
            if (textValue.toLowerCase().includes(value.toLowerCase())){
                colection[i].style.display = ""
            }else {
                colection[i].style.display = "none"
            }
        }
    }else {
        for (let i=0;i<colection.length;i++){
            colection[i].style.display = 'block';
        }
    }
}




