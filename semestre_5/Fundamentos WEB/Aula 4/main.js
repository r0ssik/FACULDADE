// let botao = document.getElementById("botao_gato")

// let itemId = "tecla_gato"

// botao.onclick = function(){
//     play_sound(itemId)
// }

 function play_sound(itemId){
    document.getElementById(itemId).play()
}

let listaDeTeclas = document.querySelectorAll(".tecla")


console.log(listaDeTeclas)
console.log(listaDeTeclas[0])

for (let contador =0; contador < listaDeTeclas.length; contador ++){
    let botao = listaDeTeclas[contador]
    let itemId = botao.classList[1]

    botao.onclick = function(){
    play_sound(itemId)
 }
}

