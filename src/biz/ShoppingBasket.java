package biz;

public class ShoppingBasket {
	String Ingredient;
	int Amount;
	
	public ShoppingBasket() {}
	
	public ShoppingBasket(String ingredient, int amount) {
		this.Ingredient = ingredient;
		this.Amount = amount;
	}

	public String getIngredient() {
		return Ingredient;
	}

	public void setIngredient(String ingredient) {
		Ingredient = ingredient;
	}

	public int getAmount() {
		return Amount;
	}

	public void setAmount(int amount) {
		Amount = amount;
	}
}
