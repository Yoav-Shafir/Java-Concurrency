package threadSynchronization.synchronized5;

public class Notifier implements Runnable {
	
	SharedData sharedData;
	
	public Notifier(SharedData sharedData) {
		this.sharedData = sharedData;
	}
	
	@Override
	public void run() {
		this.sharedData.doNotifying();
	}
	
	
}
