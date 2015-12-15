package semaphore.exe1;

import java.util.concurrent.Semaphore;

public class SkisForRent {
	public static final int MaxSkiPairs = 150;
	private static final int MinInStock = 5;
	private final Semaphore semaphore = new Semaphore(MaxSkiPairs - MinInStock);
	
	// the Semaphore is initialized with a given number of "permits",
	// which is just a simple counter.
	// at most N threads can run the acquire() method 
	// without any release() calls, where N is the number of 
	// permits the semaphore was initialized with.
	private SkiPair[] inventory;
	
	public SkisForRent() {
		inventory = new SkiPair[MaxSkiPairs];
		for (int i = 0; i < MaxSkiPairs; i++) {
			inventory[i] = new SkiPair("skiPair-" + i, false);
		}
	}
	
	public SkiPair rentSkiPair() throws InterruptedException {
		// for each call to acquire(), a permit is taken by the calling thread,
		// reducing the number of available permits by one.
		// acquire() is thread safe.
		semaphore.acquire(); 
		return getSkiPair();
	}
	
	public void returnSkiPair(SkiPair sp) {
		if (isReturnable(sp)) {
			// for each call to release(), a permit is returned to the semaphore,
			// increasing the number of available permits by one. 
			// release() is thread safe.
			semaphore.release();
		}
	}
	
	// we use synchronized because more than one thread
	// can acquire a permit, so we need to make sure
	// getting and returning SkiPairs are made in a
	// synchronized way.
	protected synchronized SkiPair getSkiPair() {
		for (SkiPair sp : inventory) {
			if (!sp.isInUse()) {
				sp.setInUse(true);
				return sp;
			}
		}
		return null;
	}
	
	protected synchronized boolean isReturnable(SkiPair sp) {
		if (sp.isInUse()) {
			sp.setInUse(false);
			return true;
		}
		return false;
	}
}
