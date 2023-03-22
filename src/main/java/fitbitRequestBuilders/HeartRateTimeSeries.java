package fitbitRequestBuilders;

import org.testng.Assert;

import apiCommons.CommonAbstractor;
import helpers.ThisConfigAPIResources;
import helpers.ThisConfigSecrets;
import io.restassured.response.Response;

public class HeartRateTimeSeries extends CommonAbstractor{
	
	private Response response;
	
	public HeartRateTimeSeries(HeartRateTimeSeriesAPIType type, String date, String period) {
		setMethod(CommonAbstractor.MethodType.GET);
		setBaseUri(ThisConfigAPIResources.BASE_URI);
		addHeader("Cache-Control", "no-cache");
		addHeader("Authorization", "Bearer "+ThisConfigSecrets.ACCESS_TOKEN);
		type.endpoint = type.endpoint.replace("[period]", period);
		type.endpoint = type.endpoint.replace("[date]", date);
		setBasePath(type.endpoint);
	}
	
	public Response execute() {
		response = super.execute();
		return response;
	}
	
	public void assertGetSleepGoalResponse() {
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Override
	public Response getApiResponse() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public enum HeartRateTimeSeriesAPIType {
		GET_HEART_RATE_TIME_SERIES_BY_DATE(ThisConfigAPIResources.HEART_RATE_TIME_SERIES_PATH);
		private HeartRateTimeSeriesAPIType(String type) {
			this.endpoint = type;
		}
		public String endpoint;
	}
}
