package dao;

import java.util.List;

import biz.ShoppingBasket;

public interface Fridge {

	public abstract void �����_���ֱ�(ShoppingBasket shoppingBasket);

	public abstract void �����_û��();

	public abstract List<ShoppingBasket> ���Ȯ��(String ingredient);

	public abstract List<ShoppingBasket> ���Ȯ��();

	public abstract void �����_�����(ShoppingBasket shoppingBasket);

}