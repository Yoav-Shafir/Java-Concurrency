package threadSynchronization.synchronized4;

public class Main {
	public static void main(String[] args) {
		
		SharedData sharedData = new SharedData();
		Client1 c = new Client1(sharedData);
		
		Thread t = new Thread(c);
		
		t.setName("Client"); 
		t.start(); 	
	}
}
