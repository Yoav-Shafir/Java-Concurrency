package threadSynchronization.synchronized2;

import static utils.Utils.busy;

public class SharedData {
	
	private final static int duration = 2500;
	
	public synchronized void manipulateSharedData1() {
		System.out.println("inside SharedData::manipulateSharedData1()");
		System.out.println("Thread " + Thread.currentThread().getName() 
				+ " start manipulating shared data for " + duration + " seconds");
		busy(duration);
	}
	
	public synchronized void manipulateSharedData2() {
		System.out.println("inside SharedData::manipulateSharedData2()");
		System.out.println("Thread " + Thread.currentThread().getName() 
				+ " start manipulating shared data for " + duration + " seconds");
		busy(duration);
	}
	
}
