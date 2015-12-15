package threadSynchronization.producerConsumer.exe1;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import static utils.Utils.busy;

public class EventStorage {
	
	private int maxSize;
	private List<Date> storage;
	
	public EventStorage() {
		maxSize = 3;
		storage = new LinkedList<>();
	}
	
	// check if the storage is full or not. If it's full, it calls the wait() method until
	// the storage has empty space.
	public synchronized void set() {
		System.out.println("start producing...");
		while (storage.size() == maxSize) {
			try {
				// tells the calling thread to give up the monitor and go to sleep until 
				// some other thread enters the same monitor and calls notify( ).
				 System.out.println("\nproducer is waiting...");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("\nproducer is adding new item...");
		busy(1000);
		storage.add(new Date());
		System.out.printf("\nafter adding new item, current size: %d",storage.size());
		System.out.println();
		notifyAll();
	}
	
	public synchronized void get() {	
		System.out.println("start consuming...");
		while (storage.size() == 0) {
			try {
				// tells the calling thread to give up the monitor and go to sleep until 
				// some other thread enters the same monitor and calls notify( ).
				System.out.println("\nconsumer is waiting...");
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("\nconsumer is removing an item...");
		busy(5000);
		System.out.printf("\nafter adding new item, current size: %d: %s",storage.size(),((LinkedList<?>)storage).poll());
		System.out.println();
		notifyAll();
	}
}
