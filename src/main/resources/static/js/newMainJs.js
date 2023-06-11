/*class dom{
    constructor(td){
        this.td = td;
    }

    getTd(){
        return this.td;
    }
}

const btnClose = document.getElementById('cerrarPopup');
const overlay = document.getElementById('overlay');
const dataCourse = document.getElementById('dataCourse');
const dataTeachers = document.getElementById('dataTeachers');
const btnEdit = document.getElementById('btn-edit');
var domV = null;
const a = 10;

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
        console.log("entro")
        overlay.classList.add('active');
    })
})

console.log(btnClose)
/*
btnClose.addEventListener('click',e=>{
    overlay.classList.remove('active');
})

btnEdit.addEventListener('click',edit);

function getTd(td){
    console.log(td);
}

 */
$(document).ready(function (){
    loadData();
})
class dom{
    constructor(td){
        this.td = td;
    }

    getTd(){
        return this.td;
    }
}

function loadData() {
    const btnClose = document.getElementById('cerrarPopup');
    const overlay = document.getElementById('overlay');
    const dataCourse = document.getElementById('dataCourse');
    const dataTeachers = document.getElementById('dataTeachers');
    const btnEdit = document.getElementById('btn-edit');
    var domV = null;
    const a = 10;

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
            console.log("entro")
            overlay.classList.add('active');
        })
    })

    console.log(btnClose)
}


/*
btnClose.addEventListener('click',e=>{
    overlay.classList.remove('active');
})

btnEdit.addEventListener('click',edit);

function getTd(td){
    console.log(td);
}
}
 */
