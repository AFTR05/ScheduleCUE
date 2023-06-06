const contain = document.getElementById('contain');
const inputSearch = document.getElementById('input-search-contain');

document.querySelector('.menu-contain').
addEventListener('click',e=>{
    contain.classList.toggle('active')
})

inputSearch.addEventListener('keyup',e=>{
    searchContent();
});

function searchContent(){
    contain.classList.add('active');
    let lista = contain.children;
    let value;
    let content = "";
    if(value!=""){
        value = inputSearch.value;
        for(let i=0;i<lista.length; i++){
            content = lista[i].getElementsByTagName('p')[0].innerText;
            if(content.toUpperCase().includes(value.toUpperCase())){
                lista[i].style.display = "";
            }else{
                lista[i].style.display = "none";
            }
        }
    }else{
        contain.classList.remove('active');
        value.array.forEach(element => {
            element.style.display = "block";
        });
    }
}