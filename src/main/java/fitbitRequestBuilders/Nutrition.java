package fitbitRequestBuilders;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.javafaker.Faker;

import apiCommons.CommonAbstractor;
import apiCommons.JacksonJsonImpl;
import fitbitPojos.CreateMealPojo;
import fitbitPojos.CreateMealPojo.MealFood;
import helpers.ThisConfigAPIResources;
import helpers.ThisConfigSecrets;
import io.restassured.response.Response;

public class Nutrition extends CommonAbstractor {
	
	public static final String CREATE_MEAL = "{\"name\":null,\"description\":null,\"mealFoods\":[{\"foodId\":null,\"amount\":null,\"unitId\":null}]}";
	public Response response;
	public NutritionAPIType type;
	private CreateMealPojo createMealPojo;
	private String request;
	public static int foodId;
	public static int unitId;
	public static int amount = 1;
	
	public Nutrition(NutritionAPIType type) {
		this.type = type;
		setMethod(type.requestType);
		setBaseUri(ThisConfigAPIResources.BASE_URI);
		addHeader("Cache-Control", "no-cache");
		addHeader("Authorization", "Bearer "+ThisConfigSecrets.ACCESS_TOKEN);
		setBasePath(type.endpoint);
	}
	
	public Nutrition(NutritionAPIType type, String request) {
		this.type = type;
		setMethod(type.requestType);
		setBaseUri(ThisConfigAPIResources.BASE_URI);
		addHeader("Cache-Control", "no-cache");
		addHeader("Authorization", "Bearer "+ThisConfigSecrets.ACCESS_TOKEN);
		setBasePath(type.endpoint);
		this.request = request;
		if (this.request != "") {
			try {
				createMealPojo = JacksonJsonImpl.getInstance().fromJson(this.request,
						CreateMealPojo.class);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Response execute() {
		response = super.execute();
		return response;
	}
	
	public void buildRequest() {
		switch(type){
		case GET_FOOD_LOCALES:
			break;
		case GET_SEARCH_FOOD:
			addQueryParam("query", ThisConfigAPIResources.FOOD_FRUIT);
			break;
		case POST_CREATE_MEAL:
			buildCreateMealRequestBody();
		default:
			break;
		}
	}
	
	public void buildCreateMealRequestBody() {
		CreateMealPojo createMealPojo = this.createMealPojo;
		Faker faker = new Faker();
		createMealPojo.setName(faker.name().lastName());
		createMealPojo.setDescription(faker.educator().hashCode());
		List<MealFood> mealFoodsList = createMealPojo.getMealFoods();
		MealFood mealFoods = mealFoodsList.get(0);
		mealFoods.setFoodId(foodId);
		mealFoods.setUnitId(unitId);
		mealFoods.setAmount(amount);
	}
	
	@SuppressWarnings("unchecked")
	public void retrieveFoodDetails() {
		Map<String, Object> foodDetails = new HashMap<String, Object>();
		foodDetails = response.jsonPath().getMap("");
		
		ArrayList <HashMap<String, Object>> allFoods = new ArrayList<HashMap<String, Object>>();
		allFoods = (ArrayList<HashMap<String, Object>>) foodDetails.get("foods");
		
		ArrayList<Integer> units = new ArrayList<Integer>();
		units = (ArrayList<Integer>) allFoods.get(0).get("units");
		
		foodId = (int) allFoods.get(0).get("foodId");
		unitId = units.get(0);
		System.out.println("BREAK");
	}

	@Override
	public Response getApiResponse() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public enum NutritionAPIType {
		GET_FOOD_LOCALES(ThisConfigAPIResources.FOOD_LOCALES_PATH, CommonAbstractor.MethodType.GET),
		GET_FOOD(ThisConfigAPIResources.FOOD_PATH, CommonAbstractor.MethodType.GET),
		GET_SEARCH_FOOD(ThisConfigAPIResources.FOOD_SEARCH_PATH, CommonAbstractor.MethodType.GET),
		POST_CREATE_MEAL(ThisConfigAPIResources.CREATE_MEAL_PATH, CommonAbstractor.MethodType.POST);
		private NutritionAPIType(String type, MethodType get) {
			this.endpoint = type;
			this.requestType = get;
		}
		public String endpoint; 
		MethodType requestType;
	}
}
