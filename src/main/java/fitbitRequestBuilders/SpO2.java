package fitbitRequestBuilders;

import org.testng.Assert;

import apiCommons.CommonAbstractor;
import helpers.ThisConfigAPIResources;
import helpers.ThisConfigSecrets;
import io.restassured.response.Response;

public class SpO2 extends CommonAbstractor{
	
	private Response response;
	
	public SpO2(SPO2APIType type, String date) {
		setMethod(CommonAbstractor.MethodType.GET);
		setBaseUri(ThisConfigAPIResources.BASE_URI);
		addHeader("Cache-Control", "no-cache");
		addHeader("Authorization", "Bearer "+ThisConfigSecrets.ACCESS_TOKEN);
		setBasePath(type.endpoint.replace("[date]", date));
	}
	
	public void assertGetSpO2ByDateResponse() {
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	public Response execute() {
		response = super.execute();
		return response;
	}
	
	@Override
	public Response getApiResponse() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public enum SPO2APIType {
		GET_SPO2_BY_DATE(ThisConfigAPIResources.SPO2_BY_DATE_PATH);
		private SPO2APIType(String type) {
			this.endpoint = type;
		}
		public String endpoint;
	}
	
}
