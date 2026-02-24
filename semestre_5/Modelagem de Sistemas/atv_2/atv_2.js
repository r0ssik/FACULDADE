const readline = require("readline");

const prompt = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});


let tempo = 10;
let tentativas = 0;
let maxTentativas = 3;
let bombaAtiva = true;
const codigoCorreto = "1234";
let intervalo;


function iniciarContagem(callback) {
    console.log("Bomba ativada!");

    intervalo = setInterval(() => {
        if (!bombaAtiva) {
            clearInterval(intervalo);
            return;
        }

        console.log("Tempo restante:", tempo);

        callback(tempo);

        tempo--;

        if (tempo < 0) {
            clearInterval(intervalo);
            console.log("BOOOOM! A bomba explodiu!");
            prompt.close();
        }

    }, 1000);
}


function tentarDesarmar(codigo) {
    switch (codigo) {
        case codigoCorreto:
            bombaAtiva = false;
            clearInterval(intervalo);
            console.log("Código correto! Bomba desarmada com sucesso!");
            prompt.close();
            break;

        default:
            console.log("Código incorreto!");
            break;
    }
}


function pedirCodigo() {

    while (tentativas < maxTentativas && bombaAtiva) {

        prompt.question("Digite um código para desarmar: ", (codigo) => {
            tentativas++;

            tentarDesarmar(codigo);

            if (tentativas >= maxTentativas && bombaAtiva) {
                console.log("Número máximo de tentativas atingido!");
            }
        });

        break; 
    }
}

function statusTempo(t) {
    if (t > 5) {
        console.log("Tudo normal...");
    } else if (t > 0) {
        console.log("URGENTE!");
    }
}

iniciarContagem(statusTempo);

setInterval(() => {
    if (bombaAtiva && tentativas < maxTentativas) {
        pedirCodigo();
    }
}, 3000);
