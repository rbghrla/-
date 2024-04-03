package Ch36.Domain.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Ch36.Domain.Dto.BookDto;
import Ch36.Domain.Dto.SessionDto;

public class SessionDaoImpl {
	// DB 연결 기본 속성
	private String url = "jdbc:mysql://localhost:3306/bookdb";
	private String id = "root";
	private String pw = "1234";

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public SessionDaoImpl() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");			// driver 경로 찾아서 메모리에 적재
		conn = DriverManager.getConnection(url,id,pw);		// conn 객체 생성
		System.out.println("[DAO] SessionDaoImpl's INIT DB Connected...");		// 출력
	}

	// Session 용
	public boolean Insert(SessionDto sessionDto) throws Exception { // sessionDto에 추가하는 메소드 (로그인 상태 정보 확인)
		pstmt = conn.prepareStatement("Insert into session values(null,?,?)");
		pstmt.setString(1, sessionDto.getUsername());
		pstmt.setString(2, sessionDto.getRole());

		return pstmt.executeUpdate() > 0;
	}
	
	public SessionDto Select(int sessionId) throws Exception {
		pstmt = conn.prepareStatement("select * from session where id = ?");
		pstmt.setInt(1, sessionId);
		rs = pstmt.executeQuery();
		SessionDto dto = null;
		if(rs!=null) {
			rs.next();
			dto = new SessionDto();
			dto.setUsername(rs.getString("username"));
			dto.setRole(rs.getString("role"));
			dto.setSessionId(rs.getInt("id"));
			
		}
		return dto;
	}

	public SessionDto Select(String username) throws Exception {
		pstmt = conn.prepareStatement("select * from session where username = ?");
		pstmt.setString(1, username);
		rs = pstmt.executeQuery();
		SessionDto dto = null;
		if(rs!=null) {
			rs.next();
			dto = new SessionDto();
			dto.setUsername(rs.getString("username"));
			dto.setRole(rs.getString("role"));
			dto.setSessionId(rs.getInt("id"));
			
		}
		return dto;
	}

	public boolean Delete(int sessionId) throws Exception {
		pstmt = conn.prepareStatement("delete from session where id = ?");
		pstmt.setInt(1, sessionId);
		int result = pstmt.executeUpdate();
		pstmt.close();
		return result > 0;
	}
	
	// SELECTALL
	public List<SessionDto> SelectAll() throws Exception {
		pstmt = conn.prepareStatement("select * from session");
		rs = pstmt.executeQuery();
		List<SessionDto> list = new ArrayList();
		
		SessionDto dto = null;
		if (rs != null) 
		{
			while(rs.next()) {		// 행의 개수만큼 반복
				dto = new SessionDto();
				dto.setUsername(rs.getString("username"));
				dto.setSessionId(rs.getInt("id"));
				dto.setRole(rs.getString("role"));
				list.add(dto);
			}
		}
		rs.close();
		pstmt.close();
		return list;
	}
}
