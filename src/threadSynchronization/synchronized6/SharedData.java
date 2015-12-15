package threadSynchronization.synchronized6;

import static utils.Utils.busy;

public class SharedData {
	
	public synchronized void doWaiting(int id) {
		System.out.println("id " + id + " inside doWaiting()");
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("id " + id + " done waiting");
	}
	
	public synchronized void doNotifying() {
		notifyAll();
	}
}
