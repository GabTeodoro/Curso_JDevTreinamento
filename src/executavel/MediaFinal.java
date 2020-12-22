package executavel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import auxiliar.FuncaoAutenticacao;
import constantes.StatusAluno;
import excecao.TratarExcecao;
import model.Aluno;
import model.Disciplina;
import model.Secretario;

public class MediaFinal {

	public static void main(final String[] args) {

		try {

			// lerArquivo();

			String login = JOptionPane.showInputDialog("Informe o login");
			String senha = JOptionPane.showInputDialog("Informe a senha");

			/*
			 * Chamando o método construtor da classe FuncaoAutenticacao que rebece como
			 * parâmetro um objeto Secretário do tipo PermitirAcesso, ela é do tipo permitir
			 * acesso pois a classe Secretário impleta a classe PermitirAcesso. Isso serve
			 * para validar que o usuário é do tipo Secretário apenas. Ao mesmo tempo que
			 * chama o método construtor, também chama o método 'autenticacao', que rebece
			 * como parâmetro o login e senha. Esse método chama o método autenticar na
			 * interface PermitirAcesso, que é então sobreescrito dentro da classe
			 * Secretário. Lá é passada a palavra usada como login e senha.
			 */
			if (new FuncaoAutenticacao(new Secretario()).autenticacao(login, senha)) {

				// Instânciando uma Lista de Alunos, em seguida usando um FOR para ir
				// adicionando os dados do aluno a lista
				List<Aluno> alunos = new ArrayList<Aluno>();

				/*
				 * List<Aluno> alunosAprovados = new ArrayList<>(); List<Aluno>
				 * alunosRecuperacao = new ArrayList<>(); List<Aluno> alunosReprovados = new
				 * ArrayList<>();
				 */

				// Lista que dentro dela temos uma chave que indetifica uma sequência de valores
				// de uma outra lista
				HashMap<String, List<Aluno>> maps = new HashMap<String, List<Aluno>>();

				for (int quantAluno = 1; quantAluno <= 1; quantAluno++) {

					String nome = JOptionPane.showInputDialog("Nome do Aluno " + quantAluno + ":");
					String idade = JOptionPane.showInputDialog("Idade do aluno" + quantAluno + ":");
					/*
					 * String curso = JOptionPane.showInputDialog("Curso: "); String CPF =
					 * JOptionPane.showInputDialog("Número do CPF: "); String RG =
					 * JOptionPane.showInputDialog("Número do RG: "); String RA =
					 * JOptionPane.showInputDialog("Registro do Aluno: "); String datanasc =
					 * JOptionPane.showInputDialog("Data de nascimento: ");
					 */

					// Instânciando o objeto aluno
					Aluno aluno = new Aluno();
					aluno.setNome(nome);
					aluno.setIdade(Integer.valueOf(idade));
					/*
					 * aluno.setCurso(curso); aluno.setDataNascimento(datanasc); aluno.setRA(RA);
					 * aluno.setNumeroCpf(CPF); aluno.setRegistroGeral(RG);
					 * aluno.setDataMatricula("22/02/2019");
					 */

					// Rodando um for para adicionar os dados da disciplina a lista de Diciplinas
					for (int pos = 1; pos <= 2; pos++) {
						String nomeDisciplina = JOptionPane.showInputDialog("Qual o nome da disciplina " + pos + "?");
						// String notaDisciplina = JOptionPane.showInputDialog("Qual a nota da
						// disciplina " + pos + "?");

						Disciplina disciplina = new Disciplina();
						disciplina.setDisciplina(nomeDisciplina);
						double[] notasDisciplinas = new double[4];

						for (int posNotas = 0; posNotas < notasDisciplinas.length; posNotas++) {
							String notaDisciplina = JOptionPane
									.showInputDialog("Qual a " + (posNotas + 1) + "° nota da disciplina " + pos + "?");
							notasDisciplinas[posNotas] = Double.parseDouble(notaDisciplina);
						}

						// Instânciando a disciplina
						// Disciplina disciplina = new Disciplina();
						// disciplina.setDisciplina(nomeDisciplina);
						disciplina.setNotas(notasDisciplinas);

						// Adicionando o objeto disciplina a lista de Disciplinas que for instânciando
						// dentro do objeto Aluno na classe Aluno
						aluno.getDisciplinas().add(disciplina);
					}

					// Perguntando caso queira remover alguma disciplina da lista
					int remover = JOptionPane.showConfirmDialog(null, "Deseja remover alguma disciplina?");

					// Método para remover uma disciplina por posição. 0 positivo e 1 negativo!
					if (remover == 0) {

						int posicao = 1;

						// Enquanto a variável remover por 0, ou seja, enquanto o usuário ainda quiser
						// remover outros disciplinas, o loop irá continuar
						while (remover == 0) {
							String removerDisciplina = JOptionPane
									.showInputDialog("Qual disciplina deseja remover? 1, 2, 3 ou 4?");

							// Chamando a lista de disciplinas dentro do aluno, e então removendo o valor
							// passado
							aluno.getDisciplinas().remove(Integer.valueOf(removerDisciplina) - posicao);
							posicao++;
							remover = JOptionPane.showConfirmDialog(null, "Deseja remover mais alguma disciplina?");
						}
					}

					// Adicionando finalmente o aluno com suas disciplinas a lista de Alunos
					alunos.add(aluno);

				}

				// Questionando se precisa encontrar algum aluno
				int procurar = JOptionPane.showConfirmDialog(null, "Deseja procurar alguma aluno?");

				// 0 positivo e 1 negativo!
				if (procurar == 0) {

					// Um FOR para rodar a lista de Alunos
					for (Aluno aluno : alunos) {
						String nomeAluno = JOptionPane.showInputDialog("Qual o nome do aluno?");

						// Método que pega o nome dos objetos alunos da lista de Alunos e então compara
						// com o nome passado pelo usuário
						if (aluno.getNome().equalsIgnoreCase(nomeAluno)) {

							// Caso encontre o nome, mostra todos os dados do Aluno procurado, e então o
							// break interrompe a busca
							System.out.println("Nome: " + aluno.getNome());
							System.out.println("Curso: " + aluno.getCurso());
							System.out.println("RA: " + aluno.getRA());
							System.out.println("Média Final: " + aluno.resultadoFinal());
							System.out.println("Estado: " + aluno.alunoAprovado());
							System.out.println(aluno.toString());
							System.out.println(
									"----------------------------------------------------------------------------------------------------------");
							break;

						}
					}
				}

				/*
				 * Imprimindo em uma caixa de texto para o usuário um FOR para rodar a lista de
				 * Alunos
				 */
				for (Aluno aluno : alunos) {

					/*
					 * Criando uma variável do tipo String para receber os nome de todas as
					 * disciplinas de uma única vez cursadas pelo alunos
					 */
					// String nomeDisc = "";
					StringBuilder saida = new StringBuilder();

					/* Um FOR para rodar a lista de Discplinas que fica dentro do aluno */
					for (Disciplina disciplina : aluno.getDisciplinas()) {

						/*
						 * Pegando o nome de cada disciplina cursada e adicionando a variável nomeDisc
						 * uma em baixo da outra
						 */
						// nomeDisc += disciplina.getDisciplina() + "\n";

						saida.append("\n----------------------------" + "\nDisciplina: " + disciplina.getDisciplina()
								+ disciplina.imprimindoNotas() + disciplina.maiorNota() + disciplina.menorNota());

					}

					// Imprimindo em uma caixa de texto para cada aluno
					/*
					 * JOptionPane.showMessageDialog(null, "Alunos cadastrados:" +
					 * "\nNome do Aluno: " + aluno.getNome() + "\nDisciplinas: " + "\n" + nomeDisc);
					 */

					JOptionPane.showMessageDialog(null, "--------- Dados do aluno ---------" + "\nNome do Aluno: "
							+ aluno.getNome() + "\nIdade do Aluno: " + aluno.getIdade() + saida.toString());

				}
				// incializando a lista com valores vazios
				maps.put(StatusAluno.APROVADO, new ArrayList<Aluno>());
				maps.put(StatusAluno.RECUPERACAO, new ArrayList<Aluno>());
				maps.put(StatusAluno.REPROVADO, new ArrayList<Aluno>());
				// Método para separar a lista de alunos em uma subLista de aprovado ou não.
				for (Aluno aluno : alunos) {

					// Buscando o retorno do método que calcula a média dentro da classe Aluno e
					// comparando com o valor da constante.
					if (aluno.alunoAprovado().equals(StatusAluno.APROVADO)) {

						// Adicionando o objeto aluno dentro da lista de Aprovados
						maps.get(StatusAluno.APROVADO).add(aluno);

					} else if (aluno.alunoAprovado().equals(StatusAluno.RECUPERACAO)) {

						// Adicionando o objeto aluno dentro da lista de Recuperação
						maps.get(StatusAluno.RECUPERACAO).add(aluno);

					} else if (aluno.alunoAprovado().equals(StatusAluno.REPROVADO)) {

						// Adicionando o objeto aluno dentro da lista de Reprovados
						maps.get(StatusAluno.REPROVADO).add(aluno);
					}
				}

				StringBuilder saida = new StringBuilder();

				for (Aluno alunoAprovado : maps.get(StatusAluno.APROVADO)) {

					saida.append("\nAlunos aprovados: " + alunoAprovado.getNome());
				}

				for (Aluno aluno : maps.get(StatusAluno.RECUPERACAO)) {

					saida.append("\nAlunos Recuperação: " + aluno.getNome());
				}

				for (Aluno aluno : maps.get(StatusAluno.REPROVADO)) {

					saida.append("\nAlunos Reprovado: " + aluno.getNome());
				}

				JOptionPane.showMessageDialog(null, saida.toString());

				/*
				 * Atualizando os dados de um aluno for (int pos = 0; pos < alunos.size();
				 * pos++) {
				 * 
				 * // Pegando as posições de cada objeto na Lista Aluno aluno = alunos.get(pos);
				 * String nomeDisc = "";
				 * 
				 * // Procurando o nome 'Yohanna Hernando' if
				 * (aluno.getNome().equalsIgnoreCase("Yohanna Hernando")) {
				 * 
				 * // Perguntando o nome novo String nomeNovo =
				 * JOptionPane.showInputDialog("Atualizando o Nome do aluno:");
				 * 
				 * // Criando uma nova instância e passando o nome para ela Aluno atualizaAluno
				 * = new Aluno(); atualizaAluno.setNome(nomeNovo);
				 * 
				 * // Método para adicionar as disciplinas e notas de forma dinâmica for (int
				 * posD = 1; posD <= 1; posD++) { String nomeDisciplinaNova = JOptionPane
				 * .showInputDialog("Qual o nome da disciplina " + pos + "?"); String
				 * notaDisciplinaNova = JOptionPane
				 * .showInputDialog("Qual a nota da disciplina " + pos + "?");
				 * 
				 * Disciplina disciplinaNova = new Disciplina();
				 * disciplinaNova.setDisciplina(nomeDisciplinaNova);
				 * disciplinaNova.setNota(Double.valueOf(notaDisciplinaNova));
				 * 
				 * // Adicionando o objeto disciplina ao novo aluno
				 * atualizaAluno.getDisciplinas().add(disciplinaNova);
				 * 
				 * }
				 * 
				 * // Adicionando o nome de todas as disciplinas a uma String para imprimir na
				 * tela for (Disciplina disciplina : atualizaAluno.getDisciplinas()) {
				 * 
				 * // Pegando o nome de cada disciplina cursada e adicionando a variável
				 * nomeDisc // uma em baixo da outra nomeDisc += disciplina.getDisciplina() +
				 * "\n";
				 * 
				 * }
				 * 
				 * // Configurando o objeto na posição do objeto antigo alunos.set(pos,
				 * atualizaAluno); // Configurando o aluno antigo com os dados do aluno
				 * atualizado aluno = alunos.get(pos);
				 * 
				 * // Imprimindo na tela os dados do aluno atualizado
				 * JOptionPane.showMessageDialog(null, "Aluno atualizado: " + aluno.getNome() +
				 * "\nDisciplinas: " + "\n" + nomeDisc); }
				 * 
				 * }
				 */

			} else {
				JOptionPane.showMessageDialog(null, "Acesso não permitido!");
			}

		} catch (NullPointerException e) {

			// Imprimir o log no console para saber onde está o erro.
			e.printStackTrace();

			// Mostrar a causa do erro no console.
			System.out.println("Causa do erro: " + e.getMessage());

			JOptionPane.showMessageDialog(null,
					"Algum campo foi passado como vázio. \nEntre em contato com a TI por favor.");

		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("Causa do erro: " + e.getMessage());
			JOptionPane.showMessageDialog(null,
					"Você digitou texto em lugar que é para digitar números!. \nTente mais uma vez por favor.");
			/*
			 * } Pegando o erro do throw de forma personalizada. catch (TratarExcecao e) {
			 * e.printStackTrace(); JOptionPane.showMessageDialog(null,
			 * "Identificamos um erro no caminho do arquivo no sistema. \nEntre em contato com a TI."
			 * );
			 */

			/*
			 * catch (FileNotFoundException e) { e.printStackTrace();
			 * System.out.println("Causa do erro: " + e.getMessage());
			 * JOptionPane.showMessageDialog(null,
			 * "Identificamos um erro no caminho do arquivo no sistema. \nEntre em contato com a TI."
			 * );
			 */

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Causa do erro: " + e.getMessage());
			JOptionPane.showMessageDialog(null, "Identificamos um erro no sistema. Entre em contato com a TI.");

			// O que tiver dentro do finally sempre vai ser executado mesmo que de erro ou
			// não.
		} finally {

			JOptionPane.showMessageDialog(null, "Finalizando aplicação! \nObrigado por aprender Java comigo.");
		}

	}

	/*
	 * Tratando erro de arquivo não encontrado de forma personalizada. public static
	 * void lerArquivo() throws TratarExcecao {
	 * 
	 * Forma custumizada de tratar um erro. try { File file = new File("line.txt");
	 * Scanner scan = new Scanner(file);
	 * 
	 * // Pegando a exceção e jogando ela para o catch dentro no main. }
	 * catch(FileNotFoundException e) { throw new TratarExcecao(e.getMessage()); } }
	 */

	// Tratando erro de arquivo não encontrado de forma normal.
	public static void lerArquivo() throws FileNotFoundException {

		File file = new File("line.txt");
		Scanner scan = new Scanner(file);

	}
}