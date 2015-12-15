package yahooFinance.usingThreadPool;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class Main {
	public static void main(String[] args) 
			throws ExecutionException, InterruptedException, IOException {
		
		new ConcurrentNAV().timeAndComputeValue();
	}
}
