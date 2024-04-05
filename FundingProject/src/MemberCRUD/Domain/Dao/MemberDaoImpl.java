package MemberCRUD.Domain.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import MemberCRUD.Domain.Dto.MemberDto;

public class MemberDaoImpl extends CommonDao implements MemberDao {
	// 싱글톤 패턴
	private static MemberDao instance;
	public static MemberDao getInstance() throws Exception {
		if(instance == null)
			instance = new MemberDaoImpl();
		return instance;
	}
	private MemberDaoImpl() throws Exception {
		System.out.println("[DAO] MemberImpl's INIT DB Connected..");
	}
	//MemberDto CRUD
	//SELECT
	@Override
	public MemberDto Select(String id) throws Exception {
		pstmt = conn.prepareStatement("select * from MEMBER where id = ?");
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		
		MemberDto dto = null;
		if (rs != null) {
			if (rs.next()) {
				dto = new MemberDto();
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
				dto.setTel(rs.getInt("tel"));					
				dto.setAuthority(rs.getString("authority"));
				
			}
		} 
		
		
		System.out.println("select successed...");
		rs.close();
		pstmt.close();
		
		return dto;
	}
	
    //SELECTALL
	@Override
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
	@Override
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
	@Override
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
	@Override
	public boolean Delete(String id) throws Exception {
		pstmt = conn.prepareStatement("delete from member where id = ?");
		pstmt.setString(1, id);
		
		int result = pstmt.executeUpdate();
		pstmt.close();
		System.out.println("delete successed...");
		return result>0;
	}
	
	
}
