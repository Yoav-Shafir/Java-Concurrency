package forkJoin.recursiveTask.exe1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class SumOfSquaresTask extends RecursiveTask<Long> {
	
	// threshold of 1000.
	private final int thresholdTHRESHOLD = 1000;
	private int from;
	private int to;
	
	public SumOfSquaresTask(int from, int to) {
		this.from = from;
		this.to = to;
	}
	
	@Override
	protected Long compute() {
		long sum = 0L;
		int mid = (to + from) >>> 1;
		
		// Any subarray smaller than the threshold was solved
		// using iteration
		if ((to - from) < thresholdTHRESHOLD) {
			for (int i = from; i < to; i++) {
				sum += Main.numbers[i] * Main.numbers[i];
			}
			return sum;
		}
		
		// Otherwise the segment was divided in half and two new tasks were created,
		// one for each half.
		else {
			
			// The ArrayList is used to hold the two subtasks.
			List<RecursiveTask<Long>> forks = new ArrayList<>();
			
			SumOfSquaresTask task1 = new SumOfSquaresTask(from, mid);
			SumOfSquaresTask task2 = new SumOfSquaresTask(mid, to);
			
			// add to list.
			forks.add(task1);
			forks.add(task2);
			
			// The fork method is used to split up the subtasks.
			// They enter the thread pool and will
			// eventually be executed
			task1.fork();
			task2.fork();
			
			// The join method returned the results when the subtask completed.
			for (RecursiveTask<Long> task : forks) {
				
				// The sum of the subtasks was added together and then returned.
				sum += task.join();
			}
			
			return sum;
		}
	}
	
}
