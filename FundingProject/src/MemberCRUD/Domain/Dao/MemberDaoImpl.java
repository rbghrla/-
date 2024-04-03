package MemberCRUD.Domain.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import MemberCRUD.Domain.Dto.MemberDto;

public class MemberDaoImpl{
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
	
	//SELECT
	public List<MemberDto> Select(String id) throws Exception {
		pstmt = conn.prepareStatement("select * from MEMBER where id = ?");
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		// list 생성이유 : name으로 select 할 경우 여러 건의 검색결과가 발생할 수도 있기 때문
		List<MemberDto> list = new ArrayList<MemberDto>();
		MemberDto dto = null;
		if (rs != null) {
			while (rs.next()) {
				dto = new MemberDto();
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
				dto.setTel(rs.getInt("tel"));					
				dto.setAuthority(rs.getString("authority"));
				list.add(dto);		
			}
		} 
		
		System.out.println(list);
		System.out.println("select successed...");
		rs.close();
		pstmt.close();
		
		return list;
	}
	
	
    //SELECTALL
	public List<MemberDto> SelectAll() throws Exception{
		
		pstmt = conn.prepareStatement("select * from MEMBER");
		rs = pstmt.executeQuery();
		
		List<MemberDto> list = new ArrayList<MemberDto>();
		MemberDto dto = null;
		if (rs != null) {
			while (rs.next()) {
				dto = new MemberDto();
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
				dto.setTel(rs.getInt("tel"));					
				dto.setAuthority(rs.getString("authority"));
				list.add(dto);
				System.out.println(dto);
			}
		}
		rs.close();
		pstmt.close();
		System.out.println("selectAll successed...");
		return list;
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
		System.out.println("insert successed...");
		return result > 0;
		}
	
	
	// UPDATE
	public boolean Update(String id, MemberDto dto) throws Exception{
		pstmt = conn.prepareStatement("update member set id=?, pw=?, name=?, addr=?, tel=?, authority=? where id=?");
		pstmt.setString(1, dto.getId());
		pstmt.setString(2, dto.getPw());
		pstmt.setString(3, dto.getName());
		pstmt.setString(4, dto.getAddr());
		pstmt.setInt(5, dto.getTel());
		pstmt.setString(6, dto.getAuthority());
		pstmt.setString(7, id);
		
		int result = pstmt.executeUpdate();
		pstmt.close();
		System.out.println("update successed");
		return result > 0;
	}
	
	
	
	// DELETE
	public boolean Delete(String id) throws Exception {
		pstmt = conn.prepareStatement("delete from member where id = ?");
		pstmt.setString(1, id);
		
		int result = pstmt.executeUpdate();
		pstmt.close();
		System.out.println("delete successed...");
		return result>0;
	}
	
	
	
	
	
	
	
	
}
