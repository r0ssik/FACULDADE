let botao = document.getElementById("botao-adicionar")

botao.onclick = function(){
    adicionar();
}

function adicionar(){
    let valor = document.getElementById("campo-tarefa").value;

    const lista = document.querySelector('#lista');

    const novoItem = document.createElement('li');

    novoItem.textContent = valor;

    const btnConcluir = document.createElement('button');
    btnConcluir.textContent = "Concluir";
    btnConcluir.onclick = function(){
        novoItem.classList.toggle('concluida');
    }

    const btnExcluir = document.createElement('button');
    btnExcluir.textContent = "Excluir";
    btnExcluir.onclick = function(){
        novoItem.remove();
    }

    novoItem.appendChild(btnConcluir);
    novoItem.appendChild(btnExcluir);
    lista.appendChild(novoItem);
}
