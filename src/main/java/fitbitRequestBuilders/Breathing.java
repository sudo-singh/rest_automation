package fitbitRequestBuilders;

import org.testng.Assert;
import apiCommons.CommonAbstractor;
import helpers.ThisConfigAPIResources;
import helpers.ThisConfigSecrets;
import io.restassured.response.Response;

public class Breathing extends CommonAbstractor {
	
	private Response response;
	
	public Breathing(BreathingAPIType type, String date) {
		setMethod(CommonAbstractor.MethodType.GET);
		setBaseUri(ThisConfigAPIResources.BASE_URI);
		addHeader("Cache-Control", "no-cache");
		addHeader("Authorization", "Bearer "+ThisConfigSecrets.ACCESS_TOKEN);
		setBasePath(type.endpoint.replace("[date]", date));
	}
	
	public Response execute() {
		response = super.execute();
		return response;
	}
	
	public void assertGetBreathingRateResponse() {
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Override
	public Response getApiResponse() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public enum BreathingAPIType {
		GET_BREATHING_RATE_BY_DATE(ThisConfigAPIResources.BREATHING_RATE_BY_DATE_PATH);
		private BreathingAPIType(String type) {
			this.endpoint = type;
		}
		public String endpoint;
	}
}
