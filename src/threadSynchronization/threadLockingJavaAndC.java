package threadSynchronization;

/** C example
 *
 * 	static pthread_mutex_t lock; // declare a lock.
	void increment_n() {
		pthread_mutex_lock(&lock);
		n = n + 1; // critical section code.
		pthread_mutex_unlock(&lock);
	} 
 */


/** Java example **/
public class threadLockingJavaAndC {
	static int n; // a single, shared storage location.
	static Object lock = new Object(); // can't be null.
	
	void incrementN() {
		synchronized (lock) {
			n++; // critical section code.
		}
	}
}
