package threadSynchronization.synchronized6;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		
		SharedData sharedData = new SharedData();
		
		// create the runnables.
		Waiter w = new Waiter(sharedData);
		Notifier n = new Notifier(sharedData);
		
		Thread t1 = new Thread(w);
		Thread t3 = new Thread(n);
		
		// start the 'Waiters' threads which immediately waits
		// using the wait() method.
		t1.start();
		
		Thread.sleep(3000);
		
		// start the notifier thread which calls the notifyAll() method.
		t3.start();
	}
}
