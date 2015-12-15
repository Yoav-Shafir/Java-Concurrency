package utils;

public class Utils {
	
	public static void busy(int duration) {
		double current = System.currentTimeMillis();
		while (System.currentTimeMillis() - current < duration);
	}
	
}
