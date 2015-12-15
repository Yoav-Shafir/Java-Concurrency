package threadSynchronization.synchronized3;

public class Main {
	public static void main(String[] args) {
		
		SharedData sharedData = new SharedData();
		Client1 c1 = new Client1(sharedData);
		Client2 c2 = new Client2(sharedData);
		
		Thread t1 = new Thread(c1);
		Thread t2 = new Thread(c2);
		
		t1.setName("Client1");
		t2.setName("Client2");
		
		// start the t1 thread which tries to access an 
		// instance synchronized method of the SharedData class. 
		t1.start(); 
		
		// we just want to make sure that t1 will 
		// start executing before t2.
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// start the t2 thread which tries to access a 
		// static synchronized method of the SharedData class.
		t2.start();
		
		try {
			// waits for t2 to end.
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Thread Client2 is finished");
	}
}
