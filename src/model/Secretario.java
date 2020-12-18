package model;

import interfaces.PermitirAcesso;

// Tem acesos aos atributos e métodos da classe pessoa.
public class Secretario extends Pessoa implements PermitirAcesso {

    private String RS;
    private String nivelCargo;
    private String experiencia;
    private String login;
    private String senha;

    public String getRS() {
        return RS;
    }

    public void setRS(String rS) {
        RS = rS;
    }

    public String getNivelCargo() {
        return nivelCargo;
    }

    public void setNivelCargo(String nivelCargo) {
        this.nivelCargo = nivelCargo;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    // Método obrigatório vindo do Pessoa.
    @Override
    public double salario() {

        return 1500;
    }

    
    @Override
    public boolean autenticar(String login, String senha) {
    	this.login = login;
    	this.senha = senha;
    	return autenticar();
    	
    }
    
    // Métodos obrigatório vinda da interface PermitirAcesso.
	@Override
    public boolean autenticar() {

        // Se o login e senha forem igual a 'admin' retorna true.
        return login.equals("admin") && senha.equals("admin");
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((RS == null) ? 0 : RS.hashCode());
        result = prime * result + ((experiencia == null) ? 0 : experiencia.hashCode());
        result = prime * result + ((nivelCargo == null) ? 0 : nivelCargo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Secretario other = (Secretario) obj;
        if (RS == null) {
            if (other.RS != null)
                return false;
        } else if (!RS.equals(other.RS))
            return false;
        if (experiencia == null) {
            if (other.experiencia != null)
                return false;
        } else if (!experiencia.equals(other.experiencia))
            return false;
        if (nivelCargo == null) {
            if (other.nivelCargo != null)
                return false;
        } else if (!nivelCargo.equals(other.nivelCargo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Secretario [RS=" + RS + ", experiencia=" + experiencia + ", nivelCargo=" + nivelCargo
                + " dataNascimento=" + dataNascimento + ", nome=" + nome + ", numeroCpf=" + numeroCpf
                + ", registroGeral=" + registroGeral + "]";
    }

}