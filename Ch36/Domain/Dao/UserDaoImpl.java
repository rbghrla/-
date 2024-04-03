package Ch36.Domain.Dao;
// Dao는 DB와 연결만 하는 역할 (DB CRUD)
// UserDto 생성 -> UserDao 생성 -> Main 에서 실행 -> ServiceImpl 생성 -> main 에서 실행 -> UserController 생성 및 정의 -> Main 에서 실행
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Ch36.Domain.Dto.UserDto;

public class UserDaoImpl {
	// DB 연결 기본 속성
	private String url = "jdbc:mysql://localhost:3306/bookdb";
	private String id = "root";
	private String pw = "1234";

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public UserDaoImpl() throws Exception {					// UserDao 생성자
		Class.forName("com.mysql.cj.jdbc.Driver");			// driver 경로 찾아서 메모리에 적재
		conn = DriverManager.getConnection(url,id,pw);		// conn 객체 생성 (DB와 연결 객체)
		System.out.println("[DAO] UserDaoImpl's INIT DB Connected...");		// 출력
	}
	
	// INSERT (회원가입)
	public boolean Insert(UserDto dto) throws Exception {		// 동일한 username이 insert 시 예외 처리
		pstmt = conn.prepareStatement("Insert into user values(?,?,?,?)");
		pstmt.setString(1, dto.getUsername());
		pstmt.setString(2, dto.getPassword());
		pstmt.setString(3, dto.getRole());
		pstmt.setBoolean(4, false);
		
		return pstmt.executeUpdate()>0;		// 수정된 것이 있다면 true 값 반환
	}
	
	// UPDATE
	
	// DELETE
	
	// SELECTALL
	
	// SELECT
	public UserDto Select(String username) throws Exception{
		pstmt = conn.prepareStatement("select * from user where username = ?");
		pstmt.setString(1, username);
		rs = pstmt.executeQuery();
		UserDto dto = null;
		if(rs!=null) {
			if(rs.next()) {
				dto = new UserDto();
				dto.setUsername(username);
				dto.setPassword(rs.getString("password"));
				dto.setRole(rs.getString("role"));
				dto.setIslocked(rs.getBoolean("islocked"));
			}
		}
		return dto;
	}
	
	
}
