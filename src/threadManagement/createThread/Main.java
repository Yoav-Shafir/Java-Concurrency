package threadManagement.createThread;

public class Main {
	
	// start the main execution thread.
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Calculator calculator = new Calculator(i);
			Thread thread = new Thread(calculator);
			
			// creating another execution thread.
			thread.start();
		}
	}
}
