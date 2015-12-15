package threadSynchronization.producerConsumer.exe3;

import java.util.Random;

public class Poper extends Thread {
	private Random rand = new Random();
	private Stack stack;
	
	public Poper(Stack stack) {
		this.stack = stack;
	}
	
	@Override
	public void run() {
		while (true) {
			stack.pop();
			try {
				Thread.sleep(rand.nextInt(100)); // 0 through 100
			} catch (Exception e) {}
		}
	}
}
