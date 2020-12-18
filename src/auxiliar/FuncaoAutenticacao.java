package auxiliar;

import interfaces.PermitirAcesso;

/* Realmente e somente receber alguém que tenha o contrato da interface de PermitirAcesso e chamar o autenticar*/
public class FuncaoAutenticacao {
    

    PermitirAcesso permitirAcesso;

    public FuncaoAutenticacao(PermitirAcesso acesso){
        this.permitirAcesso = acesso;
    }

    public boolean autenticacao(String login, String senha){

        return permitirAcesso.autenticar(login, senha);
    }

}
