package threadSynchronization.synchronized6;

public class Waiter implements Runnable {
	
	SharedData sharedData;
	
	public Waiter(SharedData sharedData) {
		this.sharedData = sharedData;
	}
	
	@Override
	public void run() {
		this.consume(1);
		
		try {
			
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		this.consume(2);
	}
	
	public void consume(int id) {
		System.out.println("calling doWaiting() with id " + id);
		this.sharedData.doWaiting(id);
	}

}
