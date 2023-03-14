package manager;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestManager {
	@BeforeSuite(alwaysRun = true)
	public void generateTokens() {
		
	}
	
	
	
	@AfterSuite(alwaysRun = true)
	public void cleanUpAndSave() {
		
	}
}
