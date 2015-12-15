package raceCondition.exe1;

public class Main {
	
	static int num = 0;
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 10000; i++) {
				num++;
			}
		});
		
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 10000; i++) {
				num--;
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
			System.out.println("num is: " + num);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
		
		
	}
}
