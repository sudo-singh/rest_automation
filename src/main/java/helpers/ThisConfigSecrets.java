package helpers;

public class ThisConfigSecrets {
	public static final String BASIC_AUTH;
	public static final String CODE_VERIFIER;
	public static final String ACCESS_TOKEN;
	public static final String REFRESH_TOKEN;
	public static final String CLIENT_ID;
	
	static {
		try {
			PropertyUtil.getInstance().load("secret.properties");
			BASIC_AUTH = PropertyUtil.getInstance().getValue("BASIC_AUTH");
			CODE_VERIFIER = PropertyUtil.getInstance().getValue("CODE_VERIFIER");
			ACCESS_TOKEN = PropertyUtil.getInstance().getValue("ACCESS_TOKEN");
			REFRESH_TOKEN = PropertyUtil.getInstance().getValue("REFRESH_TOKEN");
			CLIENT_ID = PropertyUtil.getInstance().getValue("CLIENT_ID");
			
		} catch (Throwable e) {
			e.printStackTrace();
			throw new RuntimeException("Something wrong!", e);
		}
	}
}
