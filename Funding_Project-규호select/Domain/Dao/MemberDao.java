package Funding_Project.Domain.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Funding_Project.Domain.Dto.MemberDto;

public class MemberDao {

	private String url = "jdbc:mysql://localhost:3306/memberdb";
	private String id = "root";
	private String pw = "1234";
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public MemberDao() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url, id, pw);
		System.out.println("[DAO] MemberDao INIT DB Connected...." );
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
					dto.setAuthority(rs.getInt("authority"));
					list.add(dto);
				}
			}
			
			System.out.println(list);
			rs.close();
			pstmt.close();
			return list;
		}
	
		//SELECT
		public List<MemberDto> Select(String id) throws Exception{
			pstmt = conn.prepareStatement("select * from MEMBER where id = ?");
			pstmt.setString(1, id);
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
					dto.setAuthority(rs.getInt("authority"));
					list.add(dto);
				}
			}
			
			System.out.println(list);
			rs.close();
			pstmt.close();
			
			return list;
		}
		
		
	
	
}
