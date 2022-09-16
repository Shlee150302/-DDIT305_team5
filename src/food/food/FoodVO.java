package food.food;

import java.util.Objects;

public class FoodVO {
	private String menuId;
	private String menuName;
	private int menuPrice;
	private String caId;
	private String menuInt;
	
	public FoodVO() {
	}

	public FoodVO(String menuId, String menuName, int menuPrice, String caId, String menuInt) {
		super();
		this.menuId = menuId;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
		this.caId = caId;
		this.menuInt = menuInt;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getMenuPrice() {
		return menuPrice;
	}

	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}

	public String getCaId() {
		return caId;
	}

	public void setCaId(String caId) {
		this.caId = caId;
	}

	public String getMenuInt() {
		return menuInt;
	}

	public void setMenuInt(String menuInt) {
		this.menuInt = menuInt;
	}
	
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodVO foodVO = (FoodVO) o;
        return Objects.equals(menuId, foodVO.menuId) && Objects.equals(menuName, foodVO.menuName) && menuPrice == foodVO.menuPrice 
        		&& Objects.equals(caId, foodVO.caId) && Objects.equals(menuInt, foodVO.menuInt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuId, menuName, menuPrice, caId, menuInt);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FoodVO{");
        sb.append("MENU_ID=").append(menuId);
        sb.append(", MENU_NAME='").append(menuName).append('\'');
        sb.append(", MENU_PRICE='").append(menuPrice).append('\'');
        sb.append(", CA_ID=").append(caId);
        sb.append(", MENU_INT=").append(menuInt);
        sb.append('}');
        return sb.toString();
    }
	
}
