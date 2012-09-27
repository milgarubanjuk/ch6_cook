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
	
	public void 냉장고_재료넣기(ShoppingBasket shoppingBasket){
		TransactionStatus status = this.transactionManager.getTransaction(new DefaultTransactionDefinition());
		
		try {
			kitchen.냉장고_재료넣기(shoppingBasket);
		
			this.transactionManager.commit(status);
		} catch (RuntimeException ex) {
			this.transactionManager.rollback(status);
			throw ex;
		}
	}

	public void 냉장고_청소(){
		TransactionStatus status = this.transactionManager.getTransaction(new DefaultTransactionDefinition());
		
		try {
			kitchen.냉장고_청소();
		
			this.transactionManager.commit(status);
		} catch (RuntimeException ex) {
			this.transactionManager.rollback(status);
			throw ex;
		}
	}

	public void 요리하기(List<Menu> lMenu){
		TransactionStatus status = this.transactionManager.getTransaction(new DefaultTransactionDefinition());
		
		try {
			System.out.println("tx 하는거임");
			kitchen.요리하기(lMenu);
		
			this.transactionManager.commit(status);
		} catch (RuntimeException ex) {
			this.transactionManager.rollback(status);
			throw ex;
		}
	}
	
	public List<ShoppingBasket> 재료확인(String ingredient){
		return null;
	}
	
	public List<ShoppingBasket> 재료확인() {
		return null;
	}

}
