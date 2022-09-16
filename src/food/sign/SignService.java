package food.sign;

import food.join.CustomerVO;

public class SignService {
    private static SignService instance = new SignService();
    public static SignService getInstance() {
        return instance;
    }
    private SignService() {}

    private SignDAO dao = SignDAO.getInstance();

}
