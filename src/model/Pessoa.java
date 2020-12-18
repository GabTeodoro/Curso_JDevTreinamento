package model;

// Criando uma classe genenerica, onde outras classes vão exteder seus atributos e métodos.
public abstract class Pessoa {

    protected String nome;
    protected int idade;
    protected String dataNascimento;
    protected String numeroCpf;
    protected String registroGeral;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNumeroCpf() {
        return numeroCpf;
    }

    public void setNumeroCpf(String numeroCpf) {
        this.numeroCpf = numeroCpf;
    }

    public String getRegistroGeral() {
        return registroGeral;
    }

    public void setRegistroGeral(String registroGeral) {
        this.registroGeral = registroGeral;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    // Método que é usado para suas classes filhas de uma única vez, assim não é
    // necessário copiar o mesmo método para várias classes.
    public boolean verificaMarioridade() {
        return idade >= 18;
    }

    @Override
    public String toString() {
        return "Pessoa [dataNascimento=" + dataNascimento + ", nome=" + nome + ", numeroCpf=" + numeroCpf
                + ", registroGeral=" + registroGeral + "]";
    }

    // O método abstrato é obrigatório para as classes filhas e é necessário ser
    // sobreescrito nas classes filhas.
    public abstract double salario();

}