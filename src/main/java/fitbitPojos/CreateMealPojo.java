package fitbitPojos;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import apiCommons.CommonAbstractor.RequestPojo;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"name",
	"description",
	"mealFoods"
})
@Generated("jsonschema2pojo")
public class CreateMealPojo extends RequestPojo{

	@JsonProperty("name")
	private Object name;
	@JsonProperty("description")
	private Object description;
	@JsonProperty("mealFoods")
	private List<MealFood> mealFoods;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("name")
	public Object getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(Object name) {
		this.name = name;
	}

	@JsonProperty("description")
	public Object getDescription() {
		return description;
	}

	@JsonProperty("description")
	public void setDescription(Object description) {
		this.description = description;
	}

	@JsonProperty("mealFoods")
	public List<MealFood> getMealFoods() {
		return mealFoods;
	}

	@JsonProperty("mealFoods")
	public void setMealFoods(List<MealFood> mealFoods) {
		this.mealFoods = mealFoods;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({
		"foodId",
		"amount",
		"unitId"
	})
	@Generated("jsonschema2pojo")
	public static class MealFood {

		@JsonProperty("foodId")
		private Object foodId;
		@JsonProperty("amount")
		private Object amount;
		@JsonProperty("unitId")
		private Object unitId;
		@JsonIgnore
		private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

		@JsonProperty("foodId")
		public Object getFoodId() {
			return foodId;
		}

		@JsonProperty("foodId")
		public void setFoodId(Object foodId) {
			this.foodId = foodId;
		}

		@JsonProperty("amount")
		public Object getAmount() {
			return amount;
		}

		@JsonProperty("amount")
		public void setAmount(Object amount) {
			this.amount = amount;
		}

		@JsonProperty("unitId")
		public Object getUnitId() {
			return unitId;
		}

		@JsonProperty("unitId")
		public void setUnitId(Object unitId) {
			this.unitId = unitId;
		}

		@JsonAnyGetter
		public Map<String, Object> getAdditionalProperties() {
			return this.additionalProperties;
		}

		@JsonAnySetter
		public void setAdditionalProperty(String name, Object value) {
			this.additionalProperties.put(name, value);
		}

	}
}
