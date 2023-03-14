package apiCommons;

import io.restassured.response.Response;

public abstract class CommonAbstractor extends Common {
	public abstract Response getApiResponse();

	public ResponsePojo getResponsePojo() {
		return null;
	}

	public RequestPojo getRequestPojo() {
		return null;
	}

	public static abstract class ResponsePojo {

	}

	public static abstract class RequestPojo {

	}
}
