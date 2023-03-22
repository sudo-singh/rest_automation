package helpers;

public class ThisConfigAPIResources {
	public static final String BASE_URI;
	public static final String AUTH_PATH;
	public static final String REDIRECT_URI;
	public static final String PROFILE_PATH;
	public static final String SLEEP_GOAL_PATH;
	public static final String SPO2_BY_DATE_PATH;
	public static final String BREATHING_RATE_BY_DATE_PATH;
	public static final String HEART_RATE_TIME_SERIES_PATH;
	public static final String FOOD_LOCALES_PATH;
	public static final String FOOD_PATH;
	public static final String FOOD_SEARCH_PATH;
	public static final String FOOD_FRUIT;
	public static final String CREATE_MEAL_PATH;
	
	static {
		try {
			PropertyUtil.getInstance().load("configuration.properties");
			BASE_URI = PropertyUtil.getInstance().getValue("BASE_URI");
			AUTH_PATH = PropertyUtil.getInstance().getValue("AUTH_PATH");
			REDIRECT_URI = PropertyUtil.getInstance().getValue("REDIRECT_URI");
			PROFILE_PATH = PropertyUtil.getInstance().getValue("PROFILE_PATH");
			SLEEP_GOAL_PATH = PropertyUtil.getInstance().getValue("SLEEP_GOAL_PATH");
			SPO2_BY_DATE_PATH = PropertyUtil.getInstance().getValue("SPO2_BY_DATE_PATH");
			BREATHING_RATE_BY_DATE_PATH = PropertyUtil.getInstance().getValue("BREATHING_RATE_BY_DATE_PATH");
			HEART_RATE_TIME_SERIES_PATH = PropertyUtil.getInstance().getValue("HEART_RATE_TIME_SERIES_PATH");
			FOOD_LOCALES_PATH = PropertyUtil.getInstance().getValue("FOOD_LOCALES_PATH"); 
			FOOD_PATH = PropertyUtil.getInstance().getValue("FOOD_PATH");
			FOOD_SEARCH_PATH = PropertyUtil.getInstance().getValue("FOOD_SEARCH_PATH");
			CREATE_MEAL_PATH = PropertyUtil.getInstance().getValue("CREATE_MEAL_PATH");
			
			// FOOD
			FOOD_FRUIT = PropertyUtil.getInstance().getValue("FOOD_FRUIT");
			
		} catch (Throwable e) {
			e.printStackTrace();
			throw new RuntimeException("Check Properties File", e);
		}
	}
}
