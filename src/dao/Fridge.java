package dao;

import java.util.List;

import biz.ShoppingBasket;

public interface Fridge {

	public abstract void 냉장고_재료넣기(ShoppingBasket shoppingBasket);

	public abstract void 냉장고_청소();

	public abstract List<ShoppingBasket> 재료확인(String ingredient);

	public abstract List<ShoppingBasket> 재료확인();

	public abstract void 냉장고_재료사용(ShoppingBasket shoppingBasket);

}