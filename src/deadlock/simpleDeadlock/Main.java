package deadlock.simpleDeadlock;

public class Main {
	static Object lock1 = new Object();
	static Object lock2 = new Object();
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread t1 = new Thread(() -> {
			synchronized (lock1) {
				System.out.println("thread1 holds lock1");
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("thread1 needs lock2");
				synchronized (lock2) {
					System.out.println("thread1 inside second synchronized block");
				} // lock2 released here.
			} // lock1 released here.
		});
		
		Thread t2 = new Thread(() -> {
			synchronized (lock2) {
				System.out.println("thread2 holds lock2");
				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("thread2 needs lock1");
				synchronized (lock1) {
					System.out.println("thread2 inside second synchronized block");
				} // lock1 released here.
			} // lock2 released here.
		});
		
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
	}
}
