package forkJoin.recursiveTask.exe1;

import java.util.concurrent.ForkJoinPool;

public class Main {
	
	// a 100,000 element integer array.
	static int numbers[] = new int[100000];
		
	public static void main(String[] args) {
		
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i;
		}
		
		// simple for-loop computation, no forkJoin.
		
		// Notice that the iterative solution is faster than the one using the fork/join strategy.
		// As mentioned earlier, this approach is not always more efficient, unless there are
		// a large number of processors.
		
		long startTime;
		long stopTime;
		
		long sum = 0L;
		startTime = System.currentTimeMillis();
		
		for (int i = 0; i < numbers.length; i++) {
			sum += numbers[i] * numbers[i];
		}
		
		System.out.println("Sum of squares: " + sum);
		stopTime = System.currentTimeMillis();
		System.out.println("Iterative solution time: " + (stopTime - startTime));
		
		// using forkJoin.
		
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		startTime = System.currentTimeMillis();
		long result = forkJoinPool.invoke(new SumOfSquaresTask(0, numbers.length));
		System.out.println("forkJoinPool: " + forkJoinPool.toString());
		
		stopTime = System.currentTimeMillis();
		System.out.println("Sum of squares: " + result);
		System.out.println("Fork/join solution time: " + (stopTime- startTime));
	}
}
