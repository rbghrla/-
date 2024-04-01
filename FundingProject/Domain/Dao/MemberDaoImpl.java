package FundingProject.Domain.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import FundingProject.Domain.Dto.MemberDto;

public class MemberDaoImpl {

	private String url="jdbc:mysql://localhost:3306/memberdb"; //bookdb와 연결
	private String id = "root";
	private String pw = "1234";
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public MemberDaoImpl() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver"); //Driver 경로 지정
		conn = DriverManager.getConnection(url,id,pw); //
		System.out.println("[DAO] MemberDaoImpl's INIT DB Connected...");
	}
	
	//INSERT
	public boolean Insert(MemberDto dto) throws Exception{
		pstmt = conn.prepareStatement("insert into member values(?,?,?,?,?,?)");
		pstmt.setString(1, dto.getId());
		pstmt.setString(2, dto.getPw());
		pstmt.setString(3, dto.getName());
		pstmt.setString(4, dto.getAddr());
		pstmt.setInt(5, dto.getTel());
		pstmt.setString(6, dto.getAuthority());
		
		int result = pstmt.executeUpdate();
		pstmt.close();
		return result > 0;
	}
}
