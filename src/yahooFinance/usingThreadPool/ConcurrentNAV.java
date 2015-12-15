package yahooFinance.usingThreadPool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import yahooFinance.AbstractNAV;
import yahooFinance.YahooFinance;

public class ConcurrentNAV extends AbstractNAV {

	@Override
	public double computeNetAssetValue(Map<String, Integer> stocks)
			throws ExecutionException, InterruptedException, IOException {
		
		final int numberOfCores = Runtime.getRuntime().availableProcessors();
		final double blockingCoefficient = 0.9;
		final int poolSize =  (int) (numberOfCores / (1 - blockingCoefficient));

		System.out.println("Number of Cores available is " + numberOfCores);
		System.out.println("Pool size is " + poolSize);
		
		final List<Callable<Double>> partitions = new ArrayList<>();
		for(final String ticker : stocks.keySet()) {
			
			// here we put the logic for fetching
			// the price for each ticker symbol.
			partitions.add(new Callable<Double>() {
				
				// the call() method returns a value
				// of the parameterized type of this interface - Double.
				@Override
				public Double call() throws Exception {
					return stocks.get(ticker) * YahooFinance.getPrice(ticker);
				}
			});
		}
		
		// creates a thread pool that reuses a fixed number of threads.
		final ExecutorService executorPool = Executors.newFixedThreadPool(poolSize);
		
		// executes the given tasks, returning a list of Futures holding their status 
		// and results when all complete or the timeout expires, whichever happens first.d.
		final List<Future<Double>> valueOfStocks =
				executorPool.invokeAll(partitions, 10000, TimeUnit.SECONDS);
		
		double netAssetValue = 0.0;
		for(final Future<Double> valueOfAStock : valueOfStocks) {
			
			// Waits if necessary for the computation to complete, and then retrieves its result.
			netAssetValue += valueOfAStock.get();
		}
		
		// Initiates an orderly shutdown in which previously submitted tasks are executed, 
		// but no new tasks will be accepted.
		executorPool.shutdown();
		return netAssetValue;
	}

}
