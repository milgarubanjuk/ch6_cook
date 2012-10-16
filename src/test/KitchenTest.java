package test;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;

import biz.Kitchen;
import biz.KitchenImpl;
import biz.Menu;
import biz.ShoppingBasket;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/test-applicationContext.xml")
public class KitchenTest {

//	@Autowired Fridge fridge;
	@Autowired PlatformTransactionManager transactionManager;
	@Autowired ApplicationContext context;
	@Autowired Kitchen testKitchen;
	
	static List<ShoppingBasket> lShoppingBasket;
	List<Menu> lmenu;	
	
	@Before
	public void setUp() {
		lShoppingBasket = Arrays.asList(
				new ShoppingBasket("icecream", 1),
				new ShoppingBasket("hotdog", 2),
				new ShoppingBasket("coffee", 3),
				new ShoppingBasket("cookies", 1),
				new ShoppingBasket("hamburger",2);
				new ShoppingBasket("pizza", 1)
				);
		
		lmenu = Arrays.asList(
				new Menu("���丸��", "�̸�,����"),
				new Menu("���þ��̽�ũ��", "�������̽�ũ��,����"),
				new Menu("����ȭä", "����,���̴�"),
				new Menu("�Ϻ���", "����,����")
				);
	}
	
	@Test
	public void shopping() {
		testKitchen.������_û��();
		for(ShoppingBasket shoppingBasket : lShoppingBasket)
			testKitchen.������_�����ֱ�(shoppingBasket);
		
		for(ShoppingBasket shoppingBasket : testKitchen.����Ȯ��())
			System.out.println("����: " + shoppingBasket.getIngredient() + " ����: " + shoppingBasket.getAmount());
	}
	
	@Test
	public void cooking() {
//		testKitchen.������_û��();
//		
//		for(ShoppingBasket shoppingBasket : lShoppingBasket)
//			testKitchen.������_�����ֱ�(shoppingBasket);
		
		this.testKitchen.�丮�ϱ�(lmenu);   
	}
	
	static class TestKitchen extends KitchenImpl {
		public void �丮�ϱ�(List<Menu> lmenu) {
			������_û��();
			
			for(ShoppingBasket shoppingBasket : lShoppingBasket)
				super.������_�����ֱ�(shoppingBasket);
			
			super.�丮�ϱ�(lmenu);
			System.out.println("I don't know what they say!!!");
		}
		
		public void ������_û��() {
			System.out.println("������ û�� ����");
			super.������_û��();
			System.out.println("������ û�� ��");
		}
	}
}
