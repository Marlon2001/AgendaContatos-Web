var btnAdicionar = document.querySelector("#btn-adicionar");

btnAdicionar.addEventListener("click", () =>{
    var form = document.querySelector("#form-contato");
    var contato = obterContato(form);
    
    var erros = getErros(contato);
    
    if(erros.length > 0){
        event.preventDefault();
        var ul = document.querySelector("#erros");
        ul.textContent = "";
        var painelErros = document.querySelector("#painelErros");
        painelErros.className = "list-group list-group-item list-group-item-warning .h5 pl-3";
        
        for(let i=0; i<erros.length; i++){
            var li = document.createElement("li");
            li.textContent = erros[i];
            ul.appendChild(li);
        }
        
        var tituloAviso = document.querySelector("#avisoErro");
        tituloAviso.textContent = "Não foi possivel atualizar o contato, verifique os erros abaixo.";
    }
});

function obterContato(form){
    var contato =
        {
            nome: form.querySelector("#txt-nome").value, 
            telefone: form.querySelector("#txt-telefone").value,
            email: form.querySelector("#txt-email").value
        };
    return contato;
};

const getErros = (contato) =>{
    
    var erros = [];
    
    if(contato.nome.length < 5){
        erros.push("O nome deve conter pelo menos 5 caracters.");
    }
    
    if(contato.telefone.length === 0){
        erros.push("O telefone é obrigatório.");
    }
    
    if(contato.email.length == 0){
        erros.push("O e-mail é obrigatório.");
    }
    return erros;
}