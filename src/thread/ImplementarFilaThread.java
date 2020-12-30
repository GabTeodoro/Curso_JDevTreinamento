package thread;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ImplementarFilaThread extends Thread {

	private static ConcurrentLinkedQueue<ObjetoFilaThread> filaThread = new ConcurrentLinkedQueue<ObjetoFilaThread>();

	// Adicionando um objeto do tipo ObjetoFilaThread a fila.
	public static void add(ObjetoFilaThread objetoFilaThread) {

		filaThread.add(objetoFilaThread);
	}

	@Override
	public void run() {

		while (true) {

			// Garantindo que eu consiga interagir com o filaThread.
			Iterator interacao = filaThread.iterator();

			// Bloquear o acesso a essa fila para outros processos.
			synchronized (interacao) {

				// Enquanto tiver dados na fila, irá processar.
				while (interacao.hasNext()) {

					// Pegando o objeto atual da fila.
					ObjetoFilaThread processar = (ObjetoFilaThread) interacao.next();

					// Colocar o processo aqui dentro.

					System.out.println("--------------------");
					System.out.println(processar.getNome());
					System.out.println(processar.getEmail());

					// Removendo da fila.
					interacao.remove();

					// Tempo necessário para a memória processar.
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();

					}
				}
			}

			// Antes de pegar uma nova carga de dados, dá um tempo para processar na
			// memória.
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();

			}
		}
	}
}
