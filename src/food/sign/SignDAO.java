package food.sign;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import food.join.CustomerVO;
import oracle.jdbc.OracleDriver;

public class SignDAO {
		private static SignDAO instance = new SignDAO();
	    public static SignDAO getInstance() {
	        return instance;
	    }
	    private SignDAO() {}
		
		public CustomerVO foodSign(int searchno) throws Exception {  //성공하면1 실패하면0 
			//0.드라이버 로딩
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			DriverManager.registerDriver(new OracleDriver());
			
			//1.접속
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.35.13:1521:xe", "FOOD", "java");
			
			//2.쿼리 작성
			StringBuilder builder = new StringBuilder();
			builder.append("SELECT ");
			builder.append("    no, ");
			builder.append("    title, ");
			builder.append("    content, ");
			builder.append("    writer, ");
			builder.append("    register_date, ");
			builder.append("    modify_date ");
			builder.append("FROM ");
			builder.append("    memo ");
			builder.append("WHERE ");
			builder.append("    no = ? ");
			String sql = builder.toString();

			// 3. 준비된 쿼리에 데이터 입력
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, searchNo);

			// 4. 쿼리 실행
			ResultSet resultSet = statement.executeQuery();

			// 5. 쿼리 결과 가져오기
			MemoVO vo = null;
			if (resultSet.next()) {
				int no = resultSet.getInt("no");
				String title = resultSet.getString("title");
				String content = resultSet.getString("content");
				String writer = resultSet.getString("writer");
				Date registerDate = resultSet.getDate("register_date");
				Date modifyDate = resultSet.getDate("modify_date");
				vo = new MemoVO(no, title, content, writer, registerDate, modifyDate);
			}

			// 6. 자원 반납
			resultSet.close();
			statement.close();
			connection.close();

			return vo;
		}
		
		
		
		
	
}


