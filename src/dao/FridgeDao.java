package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import biz.ShoppingBasket;

public class FridgeDao implements Fridge {
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private RowMapper<ShoppingBasket> shoppingBasketMapper = 
		new RowMapper<ShoppingBasket>() {
				public ShoppingBasket mapRow(ResultSet rs, int rowNum) throws SQLException {
					ShoppingBasket shoppingBasket = new ShoppingBasket();
					shoppingBasket.setIngredient(rs.getString("ingredient"));
					shoppingBasket.setAmount(rs.getInt("amount"));
				return shoppingBasket;
			}
		};
		
	@Override
	public void 냉장고_재료넣기(ShoppingBasket shoppingBasket) {
		this.jdbcTemplate.update("insert into fridge(ingredient, amount) values(?, ?)", shoppingBasket.getIngredient(), shoppingBasket.getAmount());
	}
	
	@Override
	public void 냉장고_청소() {
		this.jdbcTemplate.update("delete from fridge");
	}
	
	@Override
	public List<ShoppingBasket> 재료확인(String ingredient) {
		return this.jdbcTemplate.query("select * from fridge where ingredient = ?", new Object[]{ingredient}, this.shoppingBasketMapper);
	}
	
	@Override
	public List<ShoppingBasket> 재료확인() {
		return this.jdbcTemplate.query("select * from fridge", this.shoppingBasketMapper);
	}
	
	@Override
	public void 냉장고_재료사용(ShoppingBasket shoppingBasket) {
		this.jdbcTemplate.update(
				"update fridge set amount = ? where ingredient = ? ", shoppingBasket.getAmount(), shoppingBasket.getIngredient());
	}
}
