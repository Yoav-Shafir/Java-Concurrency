package threadSynchronization.synchronized4;

public class SharedData {
	
	public synchronized void manipulateSharedData(int count) {	
		System.out.println("Inside method with count: " + count);
		if (count > 0) {
			count -= 1;
			manipulateSharedData(count);
			System.out.println("count: " + count);
		} 
	}
}
