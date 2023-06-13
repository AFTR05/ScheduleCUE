var domV;
var overlay;
var weekContent
var tablaContenido;
const formatoCabecera = "MMMM D"
const formatoBD = "YYYY-MM-DD"
var fechaComodin;
var inicioSemana;
var finalSemana;

class dom{
    constructor(td){
        this.td = td;
    }

    getTd(){
        return this.td;
    }
}
function showCard(e){
    overlay = document.getElementById('overlay');
    let td;
    td = e.target;
    domV = new dom(td);
    overlay.classList.add('active');
}
function closePopUp(){
    overlay.classList.remove('active');
}

function setWeek(){
    weekContent =document.getElementById('nameWeek');
    fechaComodin = moment();
    inicioSemana = getInicioSemana(fechaComodin);
    finalSemana = getFinalSemana(fechaComodin);
    weekContent.innerText =  content(inicioSemana,finalSemana,formatoCabecera);
}

function getInicioSemana(fechaComodin){
    let fechaActualClone = fechaComodin.clone();
    return fechaActualClone.startOf('week');
}

function getFinalSemana(fechaComodin){
    let fechaActualClone = fechaComodin.clone();
    return fechaActualClone.endOf('week');
}

function content(inicioSemana,finalSemana,formatoCabecera){
    let semanaInicio = inicioSemana.clone().format(formatoCabecera)
    let semanaFinal = finalSemana.clone().format(formatoCabecera)
    return semanaInicio+" - "+semanaFinal
}

function backArrow(){
    LessWeek();
    generateValues();
}

function nextArrow(){
    addWeek();
    generateValues();
}

function addWeek(){
    fechaComodin.add(1,'weeks');
    inicioSemana = getInicioSemana(fechaComodin);
    finalSemana = getFinalSemana(fechaComodin);
    weekContent.innerText =  content(inicioSemana,finalSemana,formatoCabecera);
}

function LessWeek(){
    fechaComodin.subtract(1,'weeks');
    inicioSemana = getInicioSemana(fechaComodin);
    finalSemana = getFinalSemana(fechaComodin)
    weekContent.innerText =  content(inicioSemana,finalSemana,formatoCabecera);
}

function generateValues(){
    insertHourAndDays();
}