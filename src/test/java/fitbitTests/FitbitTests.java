package fitbitTests;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import org.testng.annotations.Test;
import fitbitRequestBuilders.HeartRateTimeSeries;
import fitbitRequestBuilders.HeartRateTimeSeries.HeartRateTimeSeriesAPIType;
import fitbitRequestBuilders.Nutrition;
import fitbitRequestBuilders.Nutrition.NutritionAPIType;
import fitbitRequestBuilders.Sleep;
import fitbitRequestBuilders.Sleep.SleepAPIType;
import manager.TestManager;

public class FitbitTests extends TestManager{
	@Test(description = "Check whether the Sleep Log is returned.", groups = { "smoke", "regression" })
	public void SleepLog() {
		Sleep sleep = new Sleep(SleepAPIType.GET_SLEEP_GOAL);
		sleep.execute();
		sleep.assertGetSleepGoalResponse();
	}
	
	@Test(description = "Check whether the Heart Rate Time Series data for current date is returned", groups = { "smoke", "regression" })
	public void heartRateTimeSeriesData() {
		LocalDateTime ldt = LocalDateTime.now();
		HeartRateTimeSeries hrts = new HeartRateTimeSeries(HeartRateTimeSeriesAPIType.GET_HEART_RATE_TIME_SERIES_BY_DATE, DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(ldt), "1d");
		hrts.execute();
	}
	
	@Test(description = "Create a Meal Plan", groups = { "smoke", "regression" })
	public void createMeal() {
		Nutrition nt = new Nutrition(NutritionAPIType.GET_SEARCH_FOOD);
		nt.buildRequest();
		nt.execute();
		nt.retrieveFoodDetails();
		Nutrition nt2 = new Nutrition(NutritionAPIType.POST_CREATE_MEAL, Nutrition.CREATE_MEAL);
		nt2.buildRequest();
		nt2.execute();
	}
}
