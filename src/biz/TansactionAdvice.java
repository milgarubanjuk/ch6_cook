package biz;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;



public class TansactionAdvice implements MethodInterceptor {
	PlatformTransactionManager transactionManager;
	
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
	
	public Object invoke(MethodInvocation invocation) throws Throwable {
		TransactionStatus status = this.transactionManager.getTransaction(new DefaultTransactionDefinition());
		
		try {
			System.out.println("<<�丮 ����>>");
			Object ret = invocation.proceed();

			this.transactionManager.commit(status);
			System.out.println("<<�丮 ��>>");
			
			return ret;			
		} catch(RuntimeException e) {
			this.transactionManager.rollback(status);
			throw e;
		}
	}

}
