package thread;

import javax.swing.JOptionPane;

import executavel.MediaFinal;

public class AulaThread {

	public static void main(String[] args) {

		JOptionPane.showMessageDialog(null, "Tarefa sendo iniciada.");
		
		Thread threadExecu = new Thread(thread1);
		threadExecu.start();
		
		Thread threadEmail = new Thread(thread2);
		threadEmail.start();

		/*
		 * Trabalhando com Thread() de uma forma não ortodoxa // Instânciando uma Tread
		 * para executar um código em paralelo com outro. new Thread() {
		 * 
		 * // Executar o código que queremos em segundo plano. public void run() {
		 * 
		 * for (int pos = 0; pos < 10; pos++) {
		 * 
		 * System.out.println("Executando..");
		 * 
		 * // Usando o sleep para executar o método a cada n milisegundos. //
		 * Obrigatório usar um try catch. try { Thread.sleep(2000); } catch
		 * (InterruptedException e) { System.out.println("Causa do erro: " +
		 * e.getMessage()); e.printStackTrace(); }
		 * 
		 * }
		 * 
		 * }
		 * 
		 * // Iniciando a Tread }.start();
		 * 
		 * 
		 * new Thread() {
		 * 
		 * public void run() {
		 * 
		 * for (int pos = 0; pos < 5; pos++) {
		 * 
		 * System.out.println("Enviando comprovante para o e-mail..");
		 * 
		 * try { Thread.sleep(4000); } catch (InterruptedException e) {
		 * System.out.println("Causa do erro: " + e.getMessage()); e.printStackTrace();
		 * }
		 * 
		 * }
		 * 
		 * }
		 * 
		 * }.start();
		 */

		// Avisando que o precesso já está sendo executado para o usuário.
		JOptionPane.showMessageDialog(null, "Processo sendo executado! \nObrigado por usar Java.");

	}

	private static Runnable thread1 = new Runnable() {

		@Override
		public void run() {

			for (int pos = 0; pos < 10; pos++) {

				System.out.println("Executando..");

				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}

	};
	
	private static Runnable thread2 = new Runnable() {

		@Override
		public void run() {
			
			for(int pos = 0; pos < 10; pos++) {
				
				System.out.println("Enviando comprovante para o e-mail..");
				
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			
		}
		
		
	};

}
