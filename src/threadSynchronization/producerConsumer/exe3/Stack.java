package threadSynchronization.producerConsumer.exe3;

public class Stack {
	private static final int capacity = 8;
	private int top = -1; // empty stack when top = -1.
	private int[] stack = new int[capacity];

	public synchronized void push(Integer n) {
		while ((top + 1) == capacity) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		System.out.println(n + " pushed at " + (top + 1));
		stack[++top] = n;
		notifyAll();
	}
	
	public synchronized void pop() {
		while (top == -1) {
			try {
				wait();
			} catch (Exception e) {}
		}
		System.out.println(stack[top] + " popped at " + top);
		top--;
		notifyAll();
	}
}
