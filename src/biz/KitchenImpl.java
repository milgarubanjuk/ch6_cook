package biz;

import java.util.List;

import dao.Fridge;

public class KitchenImpl implements Kitchen {
	Fridge fridge;
	
	public void setFridge(Fridge fridge) {
		this.fridge = fridge;	
	}
	
	@Override
	public void 냉장고_재료넣기(ShoppingBasket shoppingBasket){
		fridge.냉장고_재료넣기(shoppingBasket);
	}

	@Override
	public void 냉장고_청소(){
		fridge.냉장고_청소();
	}

	@Override
	public void 요리하기(List<Menu> lMenu) {
		
		String[] ingredients = null;
		List<ShoppingBasket> l_shoppingBasket = null;
		boolean cooking = true;
		ShoppingBasket shoppingBasket = new ShoppingBasket();
		
		//1. 재료 확인
		for(Menu menu : lMenu) {
			ingredients = menu.getIngredients().split(",");
			
			for(String ingredient: ingredients) {
				l_shoppingBasket = fridge.재료확인(ingredient);
				if(!(l_shoppingBasket.size() > 0 && l_shoppingBasket.get(0).getAmount() > 0)) {
					cooking = false;
					break;
				}
			}
			
			System.out.println("Cooking " + menu.getMenu() + "...");
			if(cooking){
				for(String ingredient: ingredients) { 
					shoppingBasket.setIngredient(ingredient);
					shoppingBasket.setAmount(0);
					
					fridge.냉장고_재료사용(shoppingBasket);
				}
				System.out.println(">>Hmm.. yammy!!");
			}
			else{
				System.out.println(">>먹고싶으면 마트에 갔다오시오!! 재료가 모자라오");
//				throw new Exception();
			}
		}		
	}
	
	
	
	public List<ShoppingBasket> 재료확인(String ingredient){
		return fridge.재료확인(ingredient);
	}
	
	public List<ShoppingBasket> 재료확인() {
		return fridge.재료확인();
	}
}
