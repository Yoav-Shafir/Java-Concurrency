package threadSynchronization.synchronized2;

public class Main {
	public static void main(String[] args) {
		
		SharedData sharedData = new SharedData();
		Client1 c1 = new Client1(sharedData);
		Client2 c2 = new Client2(sharedData);
		
		Thread t1 = new Thread(c1);
		Thread t2 = new Thread(c2);
		
		t1.setName("Client1");
		t2.setName("Client2");
		
		// when invoked, will be busy for 2.5 seconds.
		// the run method invokes a synchronized method on the sharedData instance 
		// which prevent access from t2 to !!!another!!! synchronized method on the same sharedData instance. 
		t1.start(); 
		
		// we just want to make sure that t1 will 
		// start executing before t2.
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// start the t2 thread which tries to access the same method as t1.
		t2.start();
		System.out.println("Thread Client2 waiting...");
		
		// at some point (after 2.5 seconds) t2 will get access to the second method 
		// and will be busy also for 2.5 seconds.
		
		try {
			// waits for t2 to end.
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Thread Client2 is finished");
	}
}
