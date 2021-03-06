import java.util.Map;

public class Recipe {
	
	Map<Ingredient,Integer> ingredients;
	
	public Recipe(Object... args) {
		try {
			int i=0;
			while(i<args.length) {
				Ingredient ingredient = (Ingredient)args[i++];
				Integer nUnits = (Integer)args[i++];
				ingredients.put(ingredient, nUnits);
			}
		} catch(ArrayIndexOutOfBoundsException | ClassCastException e) {
			throw new IllegalArgumentException();
		}
	}

}
