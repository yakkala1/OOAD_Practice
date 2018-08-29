import java.util.Map;

public class Inventory {
	
	private Map<Ingredient,Integer> ingredientsAvailable;
	
	public Integer getUnitsAvailable(Ingredient ingredient) {
		if( ingredientsAvailable.containsKey(ingredient) )
			return ingredientsAvailable.get(ingredient);
		else
			return 0;
	}

	public void add(Ingredient ingredient, int units) {
		ingredientsAvailable.put(ingredient, units);
	}

}