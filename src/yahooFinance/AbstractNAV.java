package yahooFinance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

//Net asset value (NAV) -> https://en.wikipedia.org/wiki/Net_asset_value.
public abstract class AbstractNAV {
	public static Map<String, Integer> readTickers() throws IOException {
		
		// read the 'stocks.txt' file,
		// which is just a list of stock name & stock quantity pairs.
		// each line has one pair.
		final BufferedReader reader = new BufferedReader(
			new FileReader("stocks.txt")
		);
		
		final Map<String, Integer> stocks = new HashMap<>();
		
		String stockInfo = null;
		
		// read line by line.
		while((stockInfo = reader.readLine()) != null) {
			final String[] stockInfoData = stockInfo.split(",");
			
			// get stock name.
			final String stockTicker = stockInfoData[0];
			// get stock quantity.
			final Integer quantity = Integer.valueOf(stockInfoData[1]);
			
			// add to map.
			stocks.put(stockTicker, quantity);
		}
		return stocks;
	}
	
	public void timeAndComputeValue() 
			throws ExecutionException, InterruptedException, IOException {
		
		// get start time.
		final long start = System.nanoTime();
		
		// extract stock names & quantitis from the 'stock.txt' file.
		final Map<String, Integer> stocks = readTickers();
		
		// the implementation is in the derived class.
		final double nav = computeNetAssetValue(stocks);
		
		// get end time.
		final long end = System.nanoTime();
		
		final String value = new DecimalFormat("$##,##0.00").format(nav);
		System.out.println("Your net asset value is " + value);
		System.out.println("Time (seconds) taken " + (end - start)/1.0e9);
	}
	
	public abstract double computeNetAssetValue(final Map<String, Integer> stocks) 
			throws ExecutionException, InterruptedException, IOException;
}
