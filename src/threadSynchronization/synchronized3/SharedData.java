package threadSynchronization.synchronized3;

import static utils.Utils.busy;

public class SharedData {
	
	private final static int duration = 2500;
	
	public synchronized void manipulateSharedData1() {
		System.out.println("inside non static SharedData::manipulateSharedData1()");
		System.out.println("Thread " + Thread.currentThread().getName() 
				+ " start manipulating shared data for " + duration + " seconds");
		busy(duration);
	}
	
	public static synchronized void manipulateSharedData2() {
		System.out.println("inside static SharedData::manipulateSharedData2()");
		System.out.println("Thread " + Thread.currentThread().getName() 
				+ " start manipulating shared data for " + duration + " seconds");
		busy(duration);
	}
	
}
