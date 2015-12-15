package threadSynchronization.producerConsumer.exe1;

public class Consumer implements Runnable {
	
	private EventStorage storage;
	
	public Consumer(EventStorage storage){
		this.storage = storage;
	}
	
	@Override
	public void run() {
		// keep consuming every 10 seconds.
		while(true) {
			storage.get();
			try {
				System.out.println("Consumer goes to sleep...");
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
