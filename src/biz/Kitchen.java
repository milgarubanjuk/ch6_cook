package biz;

import java.util.List;

public interface Kitchen {

	public abstract void �����_���ֱ�(ShoppingBasket shoppingBasket);

	public abstract void �����_û��();

	public abstract void �丮�ϱ�(List<Menu> lMenu);

	public abstract List<ShoppingBasket> ���Ȯ��(String ingredient);
	
	public abstract List<ShoppingBasket> ���Ȯ��();
}