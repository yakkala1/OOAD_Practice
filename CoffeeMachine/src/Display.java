import java.util.List;

public class Display {
	
	List<Beverage> beverages;
	Inventory inventory;
	
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
	public void setBeverages(List<Beverage> beverages) {
		this.beverages = beverages;
	}
	
	public void show() {
		System.out.println("Menu");
		for( Beverage beverage : beverages ) {
			System.out.println( beverage.getName() );
		}
		System.out.println();
		System.out.println();
		for( Ingredient ingredient : Ingredient.values() ) {
			System.out.println(ingredient + " : " + inventory.getUnitsAvailable(ingredient));
		}
		System.out.println();
	}

}