package interfaces;

//Criando uma interface. Apenas que vai ver é a classe Secretário.
public interface PermitirAcesso {

    // Apenas declaração do método.
    public boolean autenticar(String login, String senha);

	boolean autenticar();

}