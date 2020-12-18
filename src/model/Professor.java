package model;

import java.util.ArrayList;
import java.util.List;

// Tem acesos aos atributos e métodos da classe pessoa.
public class Professor extends Pessoa {

    private String RP;
    private int salarioAula;
    private int quantAulasSemana;
    private List<Disciplina> disciplinas = new ArrayList<Disciplina>();

    public String getRP() {
        return RP;
    }

    public void setRP(String rP) {
        RP = rP;
    }

    public int getSalarioAula() {
        return salarioAula;
    }

    public void setSalarioAula(int salarioAula) {
        this.salarioAula = salarioAula;
    }

    public int getQuantAulasSemana() {
        return quantAulasSemana;
    }

    public void setQuantAulasSemana(int quantAulasSemana) {
        this.quantAulasSemana = quantAulasSemana;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    // Método obrigatório sendo sobreescrito da classe Pessoa.
    @Override
    public double salario() {

        return (quantAulasSemana * salarioAula) * 4;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((RP == null) ? 0 : RP.hashCode());
        result = prime * result + ((disciplinas == null) ? 0 : disciplinas.hashCode());
        result = prime * result + quantAulasSemana;
        result = prime * result + salarioAula;
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
        Professor other = (Professor) obj;
        if (RP == null) {
            if (other.RP != null)
                return false;
        } else if (!RP.equals(other.RP))
            return false;
        if (disciplinas == null) {
            if (other.disciplinas != null)
                return false;
        } else if (!disciplinas.equals(other.disciplinas))
            return false;
        if (quantAulasSemana != other.quantAulasSemana)
            return false;
        if (salarioAula != other.salarioAula)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Professor [RP=" + RP + ", disciplinas=" + disciplinas + ", quantAulasSemana=" + quantAulasSemana
                + ", salarioAula=" + salarioAula + "dataNascimento=" + dataNascimento + ", nome=" + nome
                + ", numeroCpf=" + numeroCpf + ", registroGeral=" + registroGeral + "]";
    }

}