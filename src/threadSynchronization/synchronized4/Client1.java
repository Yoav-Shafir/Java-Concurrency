package threadSynchronization.synchronized4;

public class Client1 implements Runnable {
	
	private SharedData sharedData;
	
	public Client1(SharedData sharedData) {
		this.sharedData = sharedData;
	}

	@Override
	public void run() {
		// accessing an instance method declared with the synchronized keyword.
		sharedData.manipulateSharedData(5);
	}
	
}
