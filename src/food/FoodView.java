package food;

import java.util.Scanner;

import food.common.HomeMenu;
import food.common.ScannerUtil;
import food.food.FoodController;

public class FoodView {
	private static FoodView instance = new FoodView();
    private FoodView() {}
    public static FoodView getInstance() {
        return instance;
    }

    private Scanner scanner = ScannerUtil.scanner();
    
    public int init() {
        System.out.println("99%의 정성어림과 1%의 노하우로 최선을 다하겠습니다.");
        System.out.print(HomeMenu.HOME.getMenuString());
        return scanner.nextInt();
    }
    
    public int getMenu() {
        return scanner.nextInt();
    }
    
    public int getFoodList(FoodController controller) {
        controller.selectFoodList("").forEach(foodVO -> {
            System.out.printf("%s\t%s\t%d\t%s\t%s\n", foodVO.getMenuId(), foodVO.getMenuName(), foodVO.getMenuPrice(), foodVO.getCaId(), foodVO.getMenuInt());
        });
        return HomeMenu.FOOD.getMenu();
    }
}
