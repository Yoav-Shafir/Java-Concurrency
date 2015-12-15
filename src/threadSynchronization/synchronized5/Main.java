package threadSynchronization.synchronized5;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		
		SharedData sharedData = new SharedData();
		
		// create the runnables.
		Waiter w1 = new Waiter("w1", sharedData);
		Waiter w2 = new Waiter("w2", sharedData);
		Notifier n = new Notifier(sharedData);
		
		Thread t1 = new Thread(w1);
		Thread t2 = new Thread(w2);
	
		Thread t3 = new Thread(n);
		
		// start the 'Waiters' threads which immediately waits
		// using the wait() method.
		t1.start();
		t2.start();
		
		Thread.sleep(3000);
		
		// start the notifier thread which calls the notifyAll() method.
		t3.start();
	}
}
