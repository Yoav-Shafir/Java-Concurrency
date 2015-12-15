package threadSynchronization.synchronized1;

import static utils.Utils.busy;

public class SharedData {
	
	private final static int duration = 2500;
	
	// synchronized keyword is used for exclusive accessing.
	public synchronized void manipulateSharedData() {
		System.out.println("Thread " + Thread.currentThread().getName() 
				+ " start manipulating shared data for " + duration + " seconds");
		busy(duration);
	}
	
}
