package semaphore.exe1;

public class SkiPair {
	private String name;
	private boolean inUse;
	
	public SkiPair(String name, boolean inUse) {
		setName(name);
		setInUse(inUse);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isInUse() {
		return inUse;
	}

	public void setInUse(boolean inUse) {
		this.inUse = inUse;
	}
}
