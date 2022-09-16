package food.food;

import java.util.List;


public class FoodService {
	private static FoodService instance = new FoodService();
    public static FoodService getInstance() {
        return instance;
    }
    private FoodService() {}

    private FoodDAO dao = FoodDAO.getInstance();
    
    public List<FoodVO> findAll(String searchWord) {
        return dao.findAll(searchWord);
    }
}
