
const form = document.getElementById("formPais");


form.addEventListener("submit", buscar_capital);


function buscar_capital(event) {

    event.preventDefault();


    const pais = document.getElementById("pais").value;

    const capital = document.getElementById("capital");


    const url =
        "https://countriesnow.space/api/v0.1/countries/capital/q?country="
        + encodeURIComponent(pais);


    fetch(url)

        .then(function (response) {

            return response.json();

        })

        .then(function (data) {

            console.log(data);

            if (data.error) {

                capital.textContent = "País não encontrado";

                return;

            }

            capital.textContent = data.data.capital;

        })

        .catch(function (error) {

            console.error(error);

            capital.textContent = "Erro ao consultar a API";

        });

}
    