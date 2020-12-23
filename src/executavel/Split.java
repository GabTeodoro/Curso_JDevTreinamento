package executavel;

import java.util.Arrays;
import java.util.List;

public class Split {

	public static void main(String[] args) {
		
		String texto = "Gabriel Teodoro, Java, 80, 97.2, 78.6";
		
		String[] textoSplit = texto.split(",");
		
		System.out.println("Nome:" + textoSplit[0]);
		System.out.println("Curso:" + textoSplit[1]);
		System.out.println("1° nota:" + textoSplit[2]);
		System.out.println("2° nota:" + textoSplit[3]);
		System.out.println("3° nota:" + textoSplit[4]);
		
		System.out.println("-----------------------------------------");
		
		List<String> lista = Arrays.asList(textoSplit);
		
		for (String l : lista) {
			
			System.out.println(l);
			
		}
		
		System.out.println("-----------------------------------------");
		
		String[] array = lista.toArray(new String[5]);
		
		for (String a : array) {
			
			System.out.println(a);
			
		}
		
	}
	
}
