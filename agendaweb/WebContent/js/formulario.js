var btnAdicionar = document.querySelector("#btn-adicionar");

btnAdicionar.addEventListener("click", () =>{
    var form = document.querySelector("#form-usuario");
    var usuario = obterUsuario(form);
    
    var erros = getErros(usuario);
    
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
        tituloAviso.textContent = "Não foi possivel cadastrar o usuário, verifique os erros abaixo.";
    }
});

function obterUsuario(form){
    var usuario =
        {
            nome: form.querySelector("#txt-nome").value, 
            dtNascimento: form.querySelector("#txt-nascimento").value,
            sexo: form.querySelector("#combo-sexo").value,
            email: form.querySelector("#txt-email").value,
            senha1: form.querySelector("#txt-senha").value,
            senha2: form.querySelector("#txt-repetirSenha").value
        };
    return usuario;
};

const getErros = (usuario) =>{
    
    var erros = [];
    
    if(usuario.nome.length < 5){
        erros.push("O nome deve conter pelo menos 5 caracters.");
    }
    
    if(usuario.dtNascimento.length === 0){
        erros.push("A data de nascimento é obrigatória.");
    }
    
    if(usuario.sexo == "Selecione"){
        erros.push("O sexo não foi selecionado.");
    }
    
    if(usuario.email.length == 0){
        erros.push("O e-mail é obrigatório.");
    }
    
    if(usuario.senha1 != usuario.senha2){
        erros.push("A confirmação da senha não confere");
    }
    
	if((usuario.senha1.length < 4 || usuario.senha1.length > 8) || (usuario.senha2.length < 4 || usuario.senha2.length > 8)){
        erros.push("As senhas deve conter entre 4 e 8 caracteres.");
    }
    
    return erros;
}