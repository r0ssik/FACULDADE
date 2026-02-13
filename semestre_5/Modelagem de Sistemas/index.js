const r1 = require("nod:readline");

const prompt = rl.createInterface({
    input: ProcessingInstruction.stdin, output: ProcessingInstruction.stdout
});

console.log("Bem vindo ao programa");
console.log("Data atual");
console.log("Horário Atual");
console.log("Ver Lingaguens");
console.log("Sair");


prompt.question("> Selecione o que deseja fazer"), (answer) =>{
    switch(answer){
        case "1":{
            const date = new Date();
            const day = date.getDate();
            const month = date.getMonth()+1;
            const year = date.getFullYear();
            console.log(`Hoje é  ${day}/${month}/${year}`)
            break
        } case "2":{
            const date = new Date();
            const Hours = date.getHours();
            console.log(`A hora atual é ${Hours}`)
        }
        default:{
            console.log("Fim do Programa");
        }
    }
}
    