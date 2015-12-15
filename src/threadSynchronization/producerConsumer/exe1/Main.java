package threadSynchronization.producerConsumer.exe1;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		
		EventStorage storage = new EventStorage();
		
		// create runnables.
		Producer producer = new Producer(storage);
		Thread thread1 = new Thread(producer);
		
		Consumer consumer = new Consumer(storage);
		Thread thread2 = new Thread(consumer);
		
		// start the producer.
		thread1.start();
		
		// we make sure thread1 starts running first.
		Thread.sleep(10);
		thread2.start();
	}
}
