class dom{
    constructor(td){
        this.td = td;
    }

    getTd(){
        return this.td;
    }
}

const btnClose = document.getElementById('cerrarPopup');
var overlay = document.getElementById('overlay');
var dataCourse = document.getElementById('dataCourse');
var dataTeachers = document.getElementById('dataTeachers');
const btnEdit = document.getElementById('btn-edit');
var domV = null;

const edit = ()=>{
    let textDataCourse = dataCourse.value;
    let textDataTeacher = dataTeachers.value;
    let message = textDataCourse + " "+ textDataTeacher;
    let td = domV.getTd();
    td.innerHTML = message;
}

document.querySelectorAll('.tr-body td').
forEach(td=>{
    td.addEventListener('click',(e)=>{
        e.preventDefault()
        td = e.target;
        domV = new dom(td);
        overlay.classList.add('active');
    })
})

btnClose.addEventListener('click',e=>{
    overlay.classList.remove('active');
})

btnEdit.addEventListener('click',edit);

function getTd(td){
    console.log(td);
}