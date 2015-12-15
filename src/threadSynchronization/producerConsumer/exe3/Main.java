package threadSynchronization.producerConsumer.exe3;

public class Main {
	public static void main(String[] args) {
		Stack stack = new Stack();
		new Poper(stack).start();
		new Pusher(stack).start();
		new Pusher(stack).start();
	}	
}
