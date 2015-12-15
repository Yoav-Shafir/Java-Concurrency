package threadSynchronization.synchronized5;

import static utils.Utils.busy;

public class SharedData {
	
	public synchronized void doWaiting(String name) {
		try {
			wait();
			System.out.println(name + " done waiting");
			busy(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void doNotifying() {
		notifyAll();
	}
}
