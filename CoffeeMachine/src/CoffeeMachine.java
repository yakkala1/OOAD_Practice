import java.util.List;

public class CoffeeMachine {
	
	Display display;
	Inventory inventory;
	Maker maker;
	static List<Beverage> defaultBeverages;
	static {
		Recipe coffeeRecipe = new Recipe(
				Ingredient.COFFEE,1,
				Ingredient.MILK,2,
				Ingredient.HOT_WATER,1,
				Ingredient.SUGAR,1);
		Recipe teaRecipe = new Recipe(
				Ingredient.COFFEE,1,
				Ingredient.MILK,2,
				Ingredient.HOT_WATER,1,
				Ingredient.SUGAR,1);
		Beverage coffee = new Beverage("coffee",coffeeRecipe);
		Beverage tea = new Beverage("tea",teaRecipe);
		defaultBeverages.add(tea);
		defaultBeverages.add(coffee);
	}
	
	public CoffeeMachine(Maker maker, Display display) {
		resetInventory();
		this.display = display;
		this.maker = maker;
		this.display.setBeverages(defaultBeverages);
		this.display.setInventory(inventory);
	}

	private void resetInventory() {
		for(Ingredient ingredient : Ingredient.values())
			inventory.add( ingredient , 20 );
	}

}