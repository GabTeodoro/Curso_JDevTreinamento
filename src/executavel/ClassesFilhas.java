package executavel;

import model.Aluno;
import model.Pessoa;
import model.Professor;
import model.Secretario;

public class ClassesFilhas {

    public static void main(String[] args) {

        Aluno aluno = new Aluno();
        aluno.setNome("Gabriel Teodoro");
        aluno.setIdade(17);

        Professor professor = new Professor();
        professor.setNome("Joseth Arnaldo");
        professor.setIdade(42);
        professor.setQuantAulasSemana(12);
        professor.setSalarioAula(75);

        Secretario secretario = new Secretario();
        secretario.setNome("Emília Mendes");
        secretario.setIdade(22);

        System.out.println(aluno);
        System.err.println(professor);
        System.out.println(secretario);

        System.out.println(aluno.verificaMarioridade());
        System.out.println(professor.verificaMarioridade());
        System.out.println(secretario.verificaMarioridade());

        System.out.println("Salário Professor: " + professor.salario());
        System.out.println("Salário Secretário: " + secretario.salario());

        teste(aluno);
        teste(professor);
        teste(secretario);
    }

    // Como todo mundo é pessoa, posso apenas receber como parâmetro "pessoa" inves
    // de fazer o mesmo método para cada extensão.
    public static void teste(Pessoa pessoa) {

        System.out.println("Nome da pessoa: " + pessoa.getNome() + " e salário da pessoa: " + pessoa.salario());
    }
}