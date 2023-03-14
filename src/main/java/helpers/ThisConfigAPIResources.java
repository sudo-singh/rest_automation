package helpers;

public class ThisConfigAPIResources {
	public static final String BASE_URI;
	public static final String AUTH_PATH;
	public static final String REDIRECT_URI;
	public static final String PROFILE_PATH;
	public static final String SLEEP_GOAL_PATH;
	
	static {
		try {
			PropertyUtil.getInstance().load("configuration.properties");
			BASE_URI = PropertyUtil.getInstance().getValue("BASE_URI");
			AUTH_PATH = PropertyUtil.getInstance().getValue("AUTH_PATH");
			REDIRECT_URI = PropertyUtil.getInstance().getValue("REDIRECT_URI");
			PROFILE_PATH = PropertyUtil.getInstance().getValue("PROFILE_PATH");
			SLEEP_GOAL_PATH = PropertyUtil.getInstance().getValue("SLEEP_GOAL_PATH");
			
		} catch (Throwable e) {
			e.printStackTrace();
			throw new RuntimeException("Something wrong !!! Check configurations.", e);
		}
	}
}
