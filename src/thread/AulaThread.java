package thread;

public class AulaThread {

	public static void main(String[] args) {
		
		for(int pos = 0; pos < 10; pos++) {
			
			System.out.println("Executando..");
			
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				System.out.println("Causa do erro: " + e.getMessage());
				e.printStackTrace();
			}
			
		}
		
	}

}
