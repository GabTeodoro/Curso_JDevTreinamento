package executavel;

import javax.swing.JOptionPane;

public class ArrayVetor {

	public static void main(String[] args) {

		try {
		String quantNotas = JOptionPane.showInputDialog("Quantas notas serão adicionadas?");

		// Criando um Array do tipo double.
		// A quantidade de posições precisa ser definida.
		double[] notas = new double[Integer.valueOf(quantNotas)];

		/*
		 * Atribuindo valor de forma manual para uma posição em um Array. notas[0] =
		 * 9.5; notas[1] = 7; notas[2] = 8.7; notas[3] = 8.5;
		 * 
		 * for (int pos = 0; pos < notas.length; pos++) {
		 * 
		 * System.out.println("Nota " + (pos + 1) + " = " + notas[pos]); }
		 */
		
		for(int pos = 0; pos < notas.length; pos++) {
			
			String nota = JOptionPane.showInputDialog("Qual a nota " + (pos + 1) + ": ");
			notas[pos] = Double.parseDouble(nota);
			
		}
		
		System.out.println("--------------------------------------------------------");

		int n = 1;
		for (double nota : notas) {

			System.out.println("Nota " + n + " = " + nota);
			JOptionPane.showMessageDialog(null, "Nota " + n + " = " + nota);
			n++;
		}
		
		}catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Por favor, insira um valor númerico inteiro.");
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		}finally {
			JOptionPane.showMessageDialog(null, "Obrigado por usar o nosso sistema! :)");
		}

	}
}
