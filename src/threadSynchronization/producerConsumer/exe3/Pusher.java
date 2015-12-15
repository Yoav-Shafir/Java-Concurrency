package threadSynchronization.producerConsumer.exe3;

import java.util.Random;

public class Pusher extends Thread {
	private Random rand = new Random();
	private Stack stack;
	
	public Pusher(Stack stack) {
		this.stack = stack;
	}
	
	@Override
	public void run() {
		while (true) {
			stack.push(rand.nextInt(100)); // 0 through 99
			try {
				Thread.sleep(rand.nextInt(200)); // 0 through 200
			} catch (Exception e) {}
		}
	}
}
