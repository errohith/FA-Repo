package utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	int maxRetry = 1;
	int retryCount = 0;
		
	@Override
	public boolean retry(ITestResult result) {
		
		if(!result.isSuccess() && retryCount < maxRetry)
		{
			retryCount++;
			return true;
			
	}
		return false;

	
	}

}
