//Escolha seu destino

const botaoBonito = document.getElementById("btnBonito");

const botaoRio = document.getElementById("btnRio");

const mensagemDestino = document.getElementById("mensagemDestino");

botaoBonito.addEventListener("click", function () {
    mensagemDestino.textContent = "Destino selecionado: Bonito - MS";
});


botaoRio.addEventListener("click", function () {
    mensagemDestino.textContent = "Destino selecionado: Rio - RJ";
});


//Quantidade de viajantes

let quantidadeViajantes = 1;
const textoQuantidade = document.getElementById("quantidade");
const btnDiminuir = document.getElementById("diminuir");
const btnAumentar = document.getElementById("aumentar");

btnDiminuir.addEventListener("click", function () {

    if (quantidadeViajantes > 1){
        quantidadeViajantes = quantidadeViajantes - 1;
    }

    textoQuantidade.textContent = quantidadeViajantes
});

btnAumentar.addEventListener("click", function () {
    
    quantidadeViajantes = quantidadeViajantes + 1;

    textoQuantidade.textContent = quantidadeViajantes;
});

//Cadastro

const formulario = document.getElementById("formCadastro");
const campoNome = document.getElementById("nome");
const campoIdade = document.getElementById("idade");
const campoEmail = document.getElementById("email");
const mensagemCadastro = document.getElementById("mensagemCadastro");


formulario.addEventListener("submit", function (evento) {
    
    evento.preventDefault();

    const nome = campoNome.value;
    const email = campoEmail.value;
    const idade = Number(campoIdade.value);

    mensagemCadastro.classList.remove("erro");
    mensagemCadastro.classList.remove("sucesso");

    if (nome == ""){
        mensagemCadastro.textContent = "Por favor, insira o nome."
        mensagemCadastro.classList.add("erro");

        return;
    }

    if (idade < 18){
        mensagemCadastro.textContent = "A idade deve ser maior que 18 anos."
        mensagemCadastro.classList.add("erro");

        return;
    }

    mensagemCadastro.textContent = "Viajante cadastrado com sucesso"
    mensagemCadastro.classList.add("sucesso");

   
});

//Preferências

const botaoPreferencias = document.getElementById("mostrarPreferencias");

const preferencias = document.getElementById("preferencias");

botaoPreferencias.addEventListener("click", function () {

    preferencias.classList.toggle("oculto");

});
  
const botaoVerSugestao = document.getElementById("verSugestao");
const tipoViagem = document.getElementById("tipoViagem");
const textoSugestao = document.getElementById("sugestao");

botaoVerSugestao.addEventListener("click", function () {

    const tipo = tipoViagem.value;

    if (tipo == "aventura"){
        textoSugestao.textContent = "Sugestao: Bonito - MS";
    }
    else if (tipo == "praia"){
        textoSugestao.textContent = "Sugestao: Florianopolis - SC";
    }
    else if (tipo == "cultura"){
        textoSugestao.textContent = "Sugestao: Ouro Preto - MG";
    }
    else {
        textoSugestao.textContent = "Selecione um tipo de viagem";
    }
    

});


//Lista de atividades

const campoAtividade = document.getElementById("novaAtividade");
const botaoAdicionar = document.getElementById("adicionarAtividade");
const listaAtividades = document.getElementById("listaAtividades");

botaoAdicionar.addEventListener("click", function () {

    const atividade = campoAtividade.value;

    if (atividade == ""){
        return;
    }

    const item = document.createElement("li");

    item.textContent = atividade;

    listaAtividades.appendChild(item);

    campoAtividade.value = "";
});
