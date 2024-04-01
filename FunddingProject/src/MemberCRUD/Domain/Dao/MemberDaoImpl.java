package MemberCRUD.Domain.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDaoImpl {
	// DB 연결 기본 속성
	private String url = "jdbc:mysql://localhost:3306/memberdb";
	private String id = "root";
	private String pw = "1234";
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public MemberDaoImpl() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url,id,pw);
		System.out.println("[DAO] MemberImpl's INIT DB Connected..");
	}
	
	// INSERT
	// UPDATE
	// DELETE
	public boolean Delete(String id) throws Exception {
		pstmt = conn.prepareStatement("delete from member where id = ?");
		pstmt.setString(1, id);
		int result = pstmt.executeUpdate();
		
		pstmt.close();
		return result>0;
	}
	// SELECTALL
	// SELECT
	
	
}
