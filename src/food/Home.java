package food;

import food.common.HomeMenu;
import food.common.MenuNotFoundException;
import food.food.FoodController;
import food.sign.SignController;

public class Home {
	private SignController signController = SignController.getInstance();
	private FoodController foodController = FoodController.getInstance();
	
	private FoodView view = FoodView.getInstance();

    public void initialize() {
        home(view.init());
    }
    private void home(int number) {
        loop:
        while (true) {
            try {
                HomeMenu menu = HomeMenu.findMenu(number);
                System.out.print(menu.getMenuString());
                switch (menu) {
                    case HOME:
                    case MAIN:
                    case FOOD:
                    case CUSTOMER:
                    case CUSTOMER_MODIFY_INFO:
                        number = view.getMenu();
                        break;
//                    case JOIN:
//                        number = view.join(joinController);
//                        break;
//                    case LOGIN:
//                        number = view.login(signController);
//                        break;
//                    case LOGOUT:
//                        number = signController.signOut();
//                        break;
                    case FOOD_LIST:
                        number = view.getFoodList(foodController);
                        break;
//                    case FOOD_SEARCH:
//                        number = view.searchFood(foodController);
//                        break;
//                    case ORDER:
//                        number = view.order(orderController);
//                        break;
//                    case CUSTOMER_INFO:
//                        number = view.getCustomerInfo(joinController);
//                        break;
//                    case MODIFY_NAME:
//                    case MODIFY_ADDRESS:
//                    case MODIFY_PHONE:
//                        number = view.modifyInfo(joinController, menu);
//                        break;
//                    case CUSTOMER_MODIFY_PASSWORD:
//                        number = view.changePassword(joinController);
//                        break;
                    case QUIT:
                        break loop;
                }
            } catch (MenuNotFoundException e) {
                System.out.println(e.getMessage());
                System.out.print(HomeMenu.HOME.getMenuString());
            }
            System.out.println();
        }
    }
}
