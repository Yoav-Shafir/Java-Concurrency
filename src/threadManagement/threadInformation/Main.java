package threadManagement.threadInformation;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) throws IOException {

		// Thread priority infomation.
		System.out.printf("Minimum Priority: %s\n", Thread.MIN_PRIORITY);
		System.out.printf("Normal Priority: %s\n", Thread.NORM_PRIORITY);
		System.out.printf("Maximun Priority: %s\n", Thread.MAX_PRIORITY);

		// Create an array of 10 threads and an array of 10 Thread.State.
		Thread[] threads = new Thread[10];
		Thread.State[] states = new Thread.State[10];

		// Launch 10 threads to do the operation, 5 with the max
		// priority, 5 with the min.
		for (int i = 0; i < 10; i++) {
			threads[i] = new Thread(new Calculator(i));
			if ((i % 2) == 0) {
				threads[i].setPriority(Thread.MAX_PRIORITY);
			} else {
				threads[i].setPriority(Thread.MIN_PRIORITY);
			}
			threads[i].setName("Thread " + i);
		}

		// Wait for the finalization of the threads. Meanwhile,
		// write the status of those threads in a file.
		try (FileWriter file = new FileWriter(
				"src/threadManagement/threadInformation/log.txt");
				PrintWriter pw = new PrintWriter(file)) {

			// write to this file the status of the 10 threads.
			// now, it is in state NEW.
			for (int i = 0; i < 10; i++) {
				pw.println("Main : Status of Thread " + i + " : "
						+ threads[i].getState());

				// also store the states in the states array.
				states[i] = threads[i].getState();
			}

			// start the execution of the 10 threads.
			for (int i = 0; i < 10; i++) {
				threads[i].start();
			}

			// Until the 10 threads end, we are going to check their status. If
			// we detect a change
			// in the status of a thread, we write them on the file.
			boolean finish = false;
			while (!finish) {
				for (int i = 0; i < 10; i++) {

					// check current state with the last sotred state.
					if (threads[i].getState() != states[i]) {
						writeThreadInfo(pw, threads[i], states[i]);

						// update stored state.
						states[i] = threads[i].getState();
					}
				}

				// reset the flag before we enter the loop.
				finish = true;

				// if we find even
				for (int i = 0; i < 10; i++) {
					// once this expression returns false,
					// the 'finish' variable will stay false for the whole iteration.
					finish = finish
							&& (threads[i].getState() == Thread.State.TERMINATED);
				}

			}
		}
	}

	/**
	 * This method writes the state of a thread in a file
	 * 
	 * @param pw
	 *            : PrintWriter to write the data
	 * @param thread
	 *            : Thread whose information will be written
	 * @param state
	 *            : Old state of the thread
	 */
	private static void writeThreadInfo(PrintWriter pw, Thread thread,
			Thread.State state) {
		pw.printf("Main : Id %d - %s\n", thread.getId(), thread.getName());
		pw.printf("Main : Priority: %d\n", thread.getPriority());
		pw.printf("Main : Old State: %s\n", state);
		pw.printf("Main : New State: %s\n", thread.getState());
		pw.printf("Main : ************************************\n");
	}
}
