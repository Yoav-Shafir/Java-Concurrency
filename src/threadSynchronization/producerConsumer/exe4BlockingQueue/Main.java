package threadSynchronization.producerConsumer.exe4BlockingQueue;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		BlockingDeque<String> dropbox = new LinkedBlockingDeque<>();
		new Thread(new Consumer(dropbox, 10)).start();
		
		Thread.sleep(1000);
		
		new Thread(new Producer(dropbox)).start();
		new Thread(new Producer(dropbox)).start();
	}
}
