package threadSynchronization.producerConsumer.exe1;

public class Producer implements Runnable {
	
	private EventStorage storage;
	
	public Producer(EventStorage storage){
		this.storage = storage;
	}
	
	@Override
	public void run() {
		while(true) {
			// keep producing every 1 second.
			storage.set();
			try {
				System.out.println("Producer goes to sleep...");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
