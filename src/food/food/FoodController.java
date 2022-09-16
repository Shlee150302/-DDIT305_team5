package food.food;

import java.util.List;

public class FoodController {
	private static FoodController instance = new FoodController();
    public static FoodController getInstance() {
        return instance;
    }
    private FoodController() {}

    private FoodService service = FoodService.getInstance();

    public List<FoodVO> selectFoodList(String searchWord) {
        return service.findAll(searchWord);
    }


}
