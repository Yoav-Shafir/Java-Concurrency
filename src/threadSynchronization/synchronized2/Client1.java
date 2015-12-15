package threadSynchronization.synchronized2;

public class Client1 implements Runnable {
	
	private SharedData sharedData;
	
	public Client1(SharedData sharedData) {
		this.sharedData = sharedData;
	}

	@Override
	public void run() {
		sharedData.manipulateSharedData1();
	}
	
}
