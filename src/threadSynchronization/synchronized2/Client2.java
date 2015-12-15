package threadSynchronization.synchronized2;

public class Client2 implements Runnable {
	
	private SharedData sharedData;
	
	public Client2(SharedData sharedData) {
		this.sharedData = sharedData;
	}

	@Override
	public void run() {
		sharedData.manipulateSharedData2();
	}
}
