package threadSynchronization.producerConsumer.exe4BlockingQueue;

import java.util.Random;
import java.util.concurrent.BlockingDeque;

public class Consumer implements Runnable {
	
	private BlockingDeque<String> dropbox;
	private int maxTakes;
	
	public Consumer(BlockingDeque<String> dropbox, int maxTakes) {
		this.dropbox = dropbox;
		this.maxTakes = maxTakes;
	}
	
	@Override
	public void run() {
		Random random = new Random();
		try {
			for (int i = 0; i < this.maxTakes; i++) {
				String message = dropbox.take();
				System.out.format("Message received: %s\n", message);
				Thread.sleep(random.nextInt(3000));
			}
		} catch (Exception e) {}
		
	}

}
