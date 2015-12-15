package semaphore.exe1;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	public static void main(String[] args) {
		final SkisForRent sfr = new SkisForRent();

		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				String name = Thread.currentThread().getName();
				try {
					while (true) {
						// this method will try to acquire a permit.
						// and wait if no permit is available.
						SkiPair sp = sfr.rentSkiPair();
						
						System.out.printf("%s renting %s%n", name, sp.getName());
						Thread.sleep(10000); // skiing.
						System.out.printf("%s returning %s%n", name, sp.getName());
						
						// will release the permit.
						sfr.returnSkiPair(sp);
					}
				} catch (Exception e) {
					System.err.println(e);
				}
			}
		};
		
		// run number of threads equal to the number of MaxSkiPairs.
		// using Executors here is a little bit overkill and just for fun.
		int numOfThreads = SkisForRent.MaxSkiPairs;
		for (int i = 0; i < numOfThreads; i++) {
			ExecutorService executor = Executors.newSingleThreadExecutor();
			executor.execute(runnable);
		}
	}
}
