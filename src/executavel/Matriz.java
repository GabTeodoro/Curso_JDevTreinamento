package executavel;

import javax.swing.JOptionPane;

public class Matriz {

	public static void main(String[] args) {

		// Declarando uma matriz do tipo int.
		int[][] notas = new int[2][3];

		/*
		 * notas[0][0] = 80; notas[0][1] = 97; notas[0][2] = 78;
		 * 
		 * notas[1][0] = 64; notas[1][1] = 72; notas[1][2] = 94;
		 */

		// Adicionando as notas de forma dinâmica.
		for (int posPrincipal = 0; posPrincipal < notas.length; posPrincipal++) {

			for (int posSub = 0; posSub < notas[posPrincipal].length; posSub++) {

				String nota = JOptionPane.showInputDialog("Insira a " + (posSub + 1) + "° nota:");
				notas[posPrincipal][posSub] = Integer.parseInt(nota);
			}
		}

		int i = 1;

		// Rodando a lista principal
		for (int[] nota : notas) {

			// Rodando a sub lista dentro de cada objeto da lista principal.
			for (int n : nota) {

				System.out.println(i + "° nota: " + n);
				i++;
			}

			System.out.println("-------------------------------------------------");
		}

	}

}
