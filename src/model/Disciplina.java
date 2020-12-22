package model;

import java.util.Arrays;

public class Disciplina {

	private String disciplina;
	// Criando um Array de notas.
	// Cada disciplina agora terá 4 notas.
	private double[] notas = new double[4];

	public double[] getNotas() {
		return notas;
	}

	public void setNotas(double[] nota) {
		this.notas = nota;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	// Calculando a média final de uma determinada disciplina.
	public double mediaDisciplina() {

		double mediaNotas = 0;

		for (int pos = 0; pos < notas.length; pos++) {

			mediaNotas += notas[pos];
		}

		return mediaNotas / notas.length;

	}
	
	public StringBuilder imprimindoNotas() {
		
		int n = 1;
		
		StringBuilder saida = new StringBuilder();
		
		for(double nota: notas) {
			
			saida.append("\n Nota n° " + n + ": " + nota);
			n++;
			
		}
		
		return saida;
	}
	
	public String maiorNota() {
		
		double maiorNota = 0.0;
		
		for(double nota: notas) {
			
			if(nota > maiorNota) {
				maiorNota = nota;
				
			}
		
		}
		
		return "\nA maior nota é " + maiorNota;
	}
	
	public String menorNota() {
		
		double menorNota = 0.0;
		
		for(double nota : notas) {
			
			if(menorNota == 0.0) {
				
				menorNota = nota;
				
			}else if(nota < menorNota){
				
				menorNota = nota;
				
			}
		}
		
		return "\nA menor nota é " + menorNota;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((disciplina == null) ? 0 : disciplina.hashCode());
		result = prime * result + Arrays.hashCode(notas);
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
		Disciplina other = (Disciplina) obj;
		if (disciplina == null) {
			if (other.disciplina != null)
				return false;
		} else if (!disciplina.equals(other.disciplina))
			return false;
		if (!Arrays.equals(notas, other.notas))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Disciplina [disciplina=" + disciplina + ", nota=" + Arrays.toString(notas) + "]";
	}

}