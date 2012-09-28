package biz;

import java.util.List;

import dao.Fridge;
//this class is about what we do at the kitchen
public class KitchenImpl implements Kitchen {
	Fridge fridge;
	
	public void setFridge(Fridge fridge) {
		this.fridge = fridge;	
	}
	
	@Override
	public void ������_�����ֱ�(ShoppingBasket shoppingBasket){
		fridge.������_�����ֱ�(shoppingBasket);
	}

	@Override
	public void ������_û��(){
		fridge.������_û��();
	}

	@Override
	public void �丮�ϱ�(List<Menu> lMenu) {
		
		String[] ingredients = null;
		List<ShoppingBasket> l_shoppingBasket = null;
		boolean cooking = true;
		ShoppingBasket shoppingBasket = new ShoppingBasket();
		
		//1. ���� Ȯ��
		for(Menu menu : lMenu) {
			ingredients = menu.getIngredients().split(",");
			
			for(String ingredient: ingredients) {
				l_shoppingBasket = fridge.����Ȯ��(ingredient);
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
					
					fridge.������_��������(shoppingBasket);
				}
				System.out.println(">>Hmm.. yammy!!");
			}
			else{
				System.out.println(">>�԰������� ��Ʈ�� ���ٿ��ÿ�!! ���ᰡ ���ڶ���");
//				throw new Exception();
			}
		}		
	}
	
	
	
	public List<ShoppingBasket> ����Ȯ��(String ingredient){
		return fridge.����Ȯ��(ingredient);
	}
	
	public List<ShoppingBasket> ����Ȯ��() {
		return fridge.����Ȯ��();
	}
}
