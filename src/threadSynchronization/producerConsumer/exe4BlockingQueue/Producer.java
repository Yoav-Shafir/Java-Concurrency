package threadSynchronization.producerConsumer.exe4BlockingQueue;

import java.util.concurrent.BlockingDeque;

public class Producer implements Runnable {
	
	private BlockingDeque<String> dropbox;
	
	public Producer(BlockingDeque<String> dropbox) {
		this.dropbox = dropbox;
	}
	
	@Override
	public void run() {
		String[] importantInfo = {
			"hello.",
			"world.",
			"Ya.",
			"All."
		};
		try {
			for (String word : importantInfo) {
				dropbox.put(word);
			}
		} catch (Exception e) {}
	}
	
}
