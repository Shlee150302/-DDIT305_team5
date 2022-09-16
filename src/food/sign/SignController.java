package food.sign;

import food.FoodApplication;
import food.join.CustomerVO;

public class SignController {

	private static SignController instance = new SignController();
    public static SignController getInstance() {
    	
        return instance;
        // 이건 주석임 
    }
    private SignController() {}

    private SignService service = SignService.getInstance();

    private CustomerVO session = FoodApplication.getSession();

}
