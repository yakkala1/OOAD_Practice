
public class Beverage {
	
	String name;
	Recipe recipe;
	
	public Beverage(String name, Recipe recipe) {
		this.name = name;
		this.recipe = recipe;
	}
	
	public String getName() {
		return name;
	}
	
	public Recipe getRecipe() {
		return recipe;
	}

}
