document.getElementById("botao-adicionar").addEventListener("click", adicionar);

document.getElementById("campo-tarefa").addEventListener("keydown", function(e) {
    if (e.key === "Enter") adicionar();
});

function adicionar() {
    let campo = document.getElementById("campo-tarefa");
    let valor = campo.value.trim();

    if (valor === "") return;

    let lista = document.getElementById("lista");

    let li = document.createElement("li");

    let texto = document.createElement("span");
    texto.textContent = valor;

    let btnConcluir = document.createElement("button");
    btnConcluir.textContent = "Concluir";
    btnConcluir.addEventListener("click", function() {
        li.classList.toggle("concluida");
        li.classList.remove("excluida");
    });

    let btnExcluir = document.createElement("button");
    btnExcluir.textContent = "Excluir";
    btnExcluir.addEventListener("click", function() {
        if (li.classList.contains("excluida")) {
            li.remove();
        } else {
            li.classList.add("excluida");
            li.classList.remove("concluida");
        }
    });

    li.appendChild(texto);
    li.appendChild(btnConcluir);
    li.appendChild(btnExcluir);
    lista.appendChild(li);

    campo.value = "";
    campo.focus();
}