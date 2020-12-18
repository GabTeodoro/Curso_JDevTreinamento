package model;

import java.util.ArrayList;
import java.util.List;

import constantes.StatusAluno;

// Tem acesos aos atributos e métodos da classe pessoa.
public class Aluno extends Pessoa {

    private String RA;
    private String curso;
    private String dataMatricula;

    // Chamando o objeto Disciplina com seus atributos para relacionar com o objeto
    // Aluno
    private List<Disciplina> disciplinas = new ArrayList<Disciplina>();

    // Construtor padrão (Vamos settar na hora da instânciação, por isso padrão)
    public Aluno() {

    }

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

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public String getRA() {
        return RA;
    }

    public void setRA(String RA) {
        this.RA = RA;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(String dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    // Calcula a nota do aluno
    public double resultadoFinal() {

        // Iniciei com um valor padrão a média
        double valorFinal = 0.0;
        // O "for" vai rodar a lista inteira de disciplinas e vai somando todas
        for (Disciplina disciplina : disciplinas) {
        
        	valorFinal += disciplina.mediaDisciplina();

        }
        return valorFinal / disciplinas.size();
    }

    // Verifica se o aluno foi aprovado ou não
    public String alunoAprovado() {
        double resultadoFinal = this.resultadoFinal();
        if (resultadoFinal >= 50) {

            if (resultadoFinal >= 70)
                return StatusAluno.APROVADO;
            else {
                return StatusAluno.RECUPERACAO;
            }

        } else {
            return StatusAluno.REPROVADO;
        }
    }

    // Método sendo sobreescrito da classe Pessoa. Não é obrigatório sobreescrever,
    // mas a regra de negócio nesse caso é diferente da padrão da classe Pessoa.
    @Override
    public boolean verificaMarioridade() {

        return idade >= 17 && idade <= 23;
    }

    // Método obrigatório da classe Pessoa, mas como o aluno não usa ele, retorna 0.
    @Override
    public double salario() {

        return 0;
    }

    // Compara as váriaves de duas instâncias diferentes
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((RA == null) ? 0 : RA.hashCode());
        result = prime * result + ((curso == null) ? 0 : curso.hashCode());
        result = prime * result + ((dataMatricula == null) ? 0 : dataMatricula.hashCode());
        result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
        result = prime * result + ((disciplinas == null) ? 0 : disciplinas.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((numeroCpf == null) ? 0 : numeroCpf.hashCode());
        result = prime * result + ((registroGeral == null) ? 0 : registroGeral.hashCode());
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
        Aluno other = (Aluno) obj;
        if (RA == null) {
            if (other.RA != null)
                return false;
        } else if (!RA.equals(other.RA))
            return false;
        if (curso == null) {
            if (other.curso != null)
                return false;
        } else if (!curso.equals(other.curso))
            return false;
        if (dataMatricula == null) {
            if (other.dataMatricula != null)
                return false;
        } else if (!dataMatricula.equals(other.dataMatricula))
            return false;
        if (dataNascimento == null) {
            if (other.dataNascimento != null)
                return false;
        } else if (!dataNascimento.equals(other.dataNascimento))
            return false;
        if (disciplinas == null) {
            if (other.disciplinas != null)
                return false;
        } else if (!disciplinas.equals(other.disciplinas))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (numeroCpf == null) {
            if (other.numeroCpf != null)
                return false;
        } else if (!numeroCpf.equals(other.numeroCpf))
            return false;
        if (registroGeral == null) {
            if (other.registroGeral != null)
                return false;
        } else if (!registroGeral.equals(other.registroGeral))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Aluno [RA=" + RA + ", curso=" + curso + ", dataMatricula=" + dataMatricula + ", dataNascimento="
                + dataNascimento + ", disciplinas=" + disciplinas + ", nome=" + nome + ", numeroCpf=" + numeroCpf
                + ", registroGeral=" + registroGeral + "]";
    }

}
