const form = document.getElementById("formPais");

form.addEventListener("submit", buscarPais);

function buscarPais(event) {

    event.preventDefault();

    const pais = document.getElementById("pais").value;
    const urls = [`https://countriesnow.space/api/v0.1/countries/capital/q?country=${pais}`,
    `https://countriesnow.space/api/v0.1/countries/population/q?country=${pais}`,
    `https://countriesnow.space/api/v0.1/countries/currency/q?country=${pais}`,
    `https://countriesnow.space/api/v0.1/countries/flag/images/q?country=${pais}`];


    Promise.all(urls.map(url => fetch(url).then(response => response.json()))).then(data => {

        document.getElementById("capital").textContent = data[0].data.capital;

        const populacao = data[1].data.populationCounts;

        document.getElementById("populacao").textContent = Number(populacao[populacao.length - 1].value).toLocaleString("pt-BR");
        
        document.getElementById("moeda").textContent = data[2].data.currency; document.getElementById("bandeira").src = data[3].data.flag;
    }).catch(error => {

        console.log(error); document.getElementById("capital").textContent = "Não encontrado";

        document.getElementById("populacao").textContent = "-"; document.getElementById("moeda").textContent = "-";
        
        document.getElementById("bandeira").src = "";
    });
}