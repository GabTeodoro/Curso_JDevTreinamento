package excecao;

public class TratarExcecao extends Exception {

	public TratarExcecao(String erro) {
		
		// Imprimindo mensagem no console na hora do erro.
		super("Erro ao cadastras dados do aluno. " + erro);
	}
	
}
