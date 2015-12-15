package threadSynchronization.synchronized5;

public class Waiter implements Runnable {
	
	String name;
	SharedData sharedData;
	
	public Waiter(String name, SharedData sharedData) {
		this.name = name;
		this.sharedData = sharedData;
	}
	
	@Override
	public void run() {
		this.sharedData.doWaiting(this.name);
		
	}

}
