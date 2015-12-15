package yahooFinance;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutionException;

// Net asset value (NAV) -> https://en.wikipedia.org/wiki/Net_asset_value.
public class SequentialNAV extends AbstractNAV {

	@Override
	public double computeNetAssetValue(Map<String, Integer> stocks)
			throws ExecutionException, InterruptedException, IOException {
		
		double netAssetValue = 0.0;
		
		// iterate over the stocks map which will be something like this:
		// {AAPL=2505, BAC=9839, AMGN=3406, AMZN=9354, BMY=5099}
		for(String ticker : stocks.keySet()) {
			
			// get each stock quantity.
			Integer quantity = stocks.get(ticker);
			// connect to Yahoo finance.
			netAssetValue += quantity * YahooFinance.getPrice(ticker);
		}
		return netAssetValue;
	}
	
}
