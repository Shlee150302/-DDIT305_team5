package food.food;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import food.FoodApplication;


public class FoodDAO {
	private static FoodDAO instance = new FoodDAO();
    public static FoodDAO getInstance() {
        return instance;
    }
    private FoodDAO() {}
    
    private JdbcTemplate template = FoodApplication.getTemplate();

    public List<FoodVO> findAll(String searchWord) {
        return template.query("SELECT ca_id, menu_id, menu_int, menu_name, menu_price FROM foodmenu", new BeanPropertyRowMapper<>(FoodVO.class));
    }
}
