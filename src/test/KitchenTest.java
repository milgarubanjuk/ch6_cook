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
				new ShoppingBasket("만두", 1),
				new ShoppingBasket("쫄면", 2),
				new ShoppingBasket("치킨", 3),
				new ShoppingBasket("녹차아이스크림", 1),
				new ShoppingBasket("수박", 1),
				new ShoppingBasket("와플", 1)
				);
		
		lmenu = Arrays.asList(
				new Menu("양념만두", "쫄면,만두"),
				new Menu("와플아이스크림", "녹차아이스크림,와플"),
				new Menu("수박화채", "수박,사이다"),
				new Menu("팥빙수", "우유,단팥")
				);
	}
	
	@Test
	public void 재료확인() {
		testKitchen.냉장고_청소();
		for(ShoppingBasket shoppingBasket : lShoppingBasket)
			testKitchen.냉장고_재료넣기(shoppingBasket);
		
		for(ShoppingBasket shoppingBasket : testKitchen.재료확인())
			System.out.println("재료: " + shoppingBasket.getIngredient() + " 수량: " + shoppingBasket.getAmount());
	}
	
	@Test
	public void 요리하기() {
//		testKitchen.냉장고_청소();
//		
//		for(ShoppingBasket shoppingBasket : lShoppingBasket)
//			testKitchen.냉장고_재료넣기(shoppingBasket);
		
		this.testKitchen.요리하기(lmenu);   
	}
	
	static class TestKitchen extends KitchenImpl {
		public void 요리하기(List<Menu> lmenu) {
			냉장고_청소();
			
			for(ShoppingBasket shoppingBasket : lShoppingBasket)
				super.냉장고_재료넣기(shoppingBasket);
			
			super.요리하기(lmenu);
			System.out.println("뒷정리까지 끝!!!!");
		}
		
		public void 냉장고_청소() {
			System.out.println("냉장고 청소 시작");
			super.냉장고_청소();
			System.out.println("냉장고 청소 끝");
		}
	}
}
