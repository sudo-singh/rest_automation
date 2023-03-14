package fitbitTests;

import org.testng.annotations.Test;
import fitbitRequestBuilders.Sleep;
import fitbitRequestBuilders.Sleep.APIType;
import manager.TestManager;

public class FitbitTests extends TestManager{
	@Test(description = "Check whether the Sleep Log is returned.", groups = { "smoke", "regression" })
	public void SleepLog() {
		Sleep sleep = new Sleep(APIType.GET_SLEEP_GOAL);
		sleep.execute();
	}
}
