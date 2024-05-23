//Colocar esse DOMContentLoaded, porque primeiro vai carregar o script e depois a pagina html e da B.O, com esse DOM não acontece isso...
document.addEventListener("DOMContentLoaded", function() {
    const emailBorder = document.getElementById("email");
    //const divMail = document.getElementById("invalidMail");

    emailBorder.addEventListener("focus", function() {
        emailBorder.style.borderColor = "blue";
        //divMail.style.display="none";
    });

    emailBorder.addEventListener("blur", function(){
        emailBorder.style.borderColor="#ccc";
        //console.log("entrou")
    });
});


function validarCampos()
{
    event.preventDefault();
    //console.log("teste");
    const email = document.getElementById("email");
    const senha = document.getElementById("pass");
    const divMail = document.getElementById("invalidMail");

    if(validarEmail(email.value))
    {
        //fazer a fetch com o backend para ver se a senha está correta
    }
    else
        {
            email.style.borderColor = "red";

            divMail.style.display="block";

            setTimeout(()=>{
                divMail.style.display="none";
            },2200);//esconde a div apos 2segundos e pouco
        }
}


function validarEmail(email)
{
    return /^[\w+.]+@\w+\.\w{2,}(?:\.\w{2})?$/.test(email);
}



function verificaParametrizacao(){
    const URL = "http://localhost:8080/apis/adm/get-parametrizacao";

    fetch(URL, {
        method: 'GET', 
        headers: {
        'Content-Type': 'application/json' 
        }
    })
    .then(response => {

        return response.json(); // Processar os dados recebidos (assumindo que seja JSON)
    })
    .then(json => {

        /*
        if(json.id==0)
            window.location.href="parametrizacao.html"
        else
            window.location.href="index.html"*/

        console.log(json.id);
      
    })
    .catch(error => {
        console.error('Erro:', error);
    });
     
}