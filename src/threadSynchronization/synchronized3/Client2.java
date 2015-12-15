package threadSynchronization.synchronized3;

public class Client2 implements Runnable {
	
	private SharedData sharedData;
	
	public Client2(SharedData sharedData) {
		this.sharedData = sharedData;
	}

	@Override
	public void run() {
		// accessing a static method declared with the synchronized keyword.
		SharedData.manipulateSharedData2();
	}
}
