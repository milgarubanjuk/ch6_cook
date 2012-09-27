package biz;

import java.util.List;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class KitchenTx implements Kitchen{
	
	PlatformTransactionManager transactionManager;
	Kitchen kitchen;
	
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
	
	public void setKitchen(Kitchen kitchen) {
		this.kitchen = kitchen;
	}
	
	public void �����_���ֱ�(ShoppingBasket shoppingBasket){
		TransactionStatus status = this.transactionManager.getTransaction(new DefaultTransactionDefinition());
		
		try {
			kitchen.�����_���ֱ�(shoppingBasket);
		
			this.transactionManager.commit(status);
		} catch (RuntimeException ex) {
			this.transactionManager.rollback(status);
			throw ex;
		}
	}

	public void �����_û��(){
		TransactionStatus status = this.transactionManager.getTransaction(new DefaultTransactionDefinition());
		
		try {
			kitchen.�����_û��();
		
			this.transactionManager.commit(status);
		} catch (RuntimeException ex) {
			this.transactionManager.rollback(status);
			throw ex;
		}
	}

	public void �丮�ϱ�(List<Menu> lMenu){
		TransactionStatus status = this.transactionManager.getTransaction(new DefaultTransactionDefinition());
		
		try {
			System.out.println("tx �ϴ°���");
			kitchen.�丮�ϱ�(lMenu);
		
			this.transactionManager.commit(status);
		} catch (RuntimeException ex) {
			this.transactionManager.rollback(status);
			throw ex;
		}
	}
	
	public List<ShoppingBasket> ���Ȯ��(String ingredient){
		return null;
	}
	
	public List<ShoppingBasket> ���Ȯ��() {
		return null;
	}

}
