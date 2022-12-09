const btnAddCell = document.querySelector("#btn-cellsOpen")
const btnclose = document.querySelector("#closemodal")
const modalAdd = document.querySelector("#modalCell")
btnAddCell.addEventListener("click",()=>{
    modalAdd.showModal()
})
btnclose.addEventListener("click",()=>{
    modalAdd.remove()
})