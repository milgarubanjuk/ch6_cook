package biz;

import java.util.List;

public interface Kitchen {

	public abstract void 냉장고_재료넣기(ShoppingBasket shoppingBasket);

	public abstract void 냉장고_청소();

	public abstract void 요리하기(List<Menu> lMenu);

	public abstract List<ShoppingBasket> 재료확인(String ingredient);
	
	public abstract List<ShoppingBasket> 재료확인();
}