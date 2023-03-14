package fitbitRequestBuilders;

import apiCommons.CommonAbstractor;
import helpers.ThisConfigAPIResources;
import helpers.ThisConfigSecrets;
import io.restassured.response.Response;

public class Sleep extends CommonAbstractor{
	
	private Response response;
	
	public Sleep(APIType type) {
		setMethod(type.requestType);
		setBaseUri(ThisConfigAPIResources.BASE_URI);
		addHeader("Cache-Control", "no-cache");
		addHeader("Authorization", "Bearer "+ThisConfigSecrets.ACCESS_TOKEN);
		setBasePath(type.endpoint);
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
	
	public enum APIType {
		GET_SLEEP_GOAL(ThisConfigAPIResources.SLEEP_GOAL_PATH, CommonAbstractor.MethodType.GET);
		
		private APIType(String type, MethodType get) {
			this.endpoint = type;
			this.requestType = get;
		}
		public String endpoint;
		MethodType requestType;
	}
}
