package biz;

public class Menu {
	String Menu;
	String Ingredients;
	
	public Menu() {}
		
	public Menu(String menu, String ingredients) {
		this.Menu = menu;
		this.Ingredients = ingredients;
	}
	public String getMenu() {
		return Menu;
	}
	public void setMenu(String menu) {
		Menu = menu;
	}
	public String getIngredients() {
		return Ingredients;
	}
	public void setIngredients(String ingredients) {
		Ingredients = ingredients;
	}
	
}
