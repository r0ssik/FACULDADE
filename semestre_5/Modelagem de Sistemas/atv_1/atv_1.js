const readline = require("readline");

const prompt = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

function calculadora() {
    console.log("Bem vindo a cálculadura, primeiro selecione 2 números e te darei as opções depois.\n")
    prompt.question("Primeiro número: \n", answer1 => {
        const num1 = parseInt(answer1);

        prompt.question("Segundo número: \n", answer2 => {
            const num2 = parseInt(answer2);

            prompt.question(
                "Digite:\n1 para Soma\n2 para Divisão\n3 para Multiplicação\n4 para Subtração\n5 para Sair\n",
                answer3 => {
                    const opcao = parseInt(answer3);
                    let result;

                    if (opcao === 1) {
                        result = num1 + num2;
                    } else if (opcao === 2) {
                        if(num2 === 0){
                            console.log("Impossível dividir por zero\n");
                            calculadora();
                            return;
                        }
                        result = num1 / num2;
                    } else if (opcao === 3) {
                        result = num1 * num2;
                    } else if (opcao === 4) {
                        result = num1 - num2;
                    } else if (opcao === 5) {
                        console.log("Saindo...\n");
                        prompt.close();
                        return;
                    } else {
                        console.log("Digite uma opção válida.\n");
                        calculadora(); 
                        return;
                    }

                    console.log("O seu resultado é:", result, "\n");
                    calculadora(); 
                    return;
                }
            );
        });
    });
}

calculadora();
