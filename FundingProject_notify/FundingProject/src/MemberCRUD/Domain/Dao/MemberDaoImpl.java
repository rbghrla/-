package MemberCRUD.Domain.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import MemberCRUD.Domain.Dto.MemberDto;

public class MemberDaoImpl extends CommonDao implements MemberDao{
	
	private static  MemberDaoImpl instance;
	public static  MemberDaoImpl getInstance() throws Exception {
		if(instance==null)
			instance = MemberDaoImpl.getInstance();
		return instance;
	}
	
	public MemberDaoImpl() throws Exception {
		
		System.out.println("[DAO] MemberImpl's INIT DB Connected..");
	}
	
	//SELECT
	public List<MemberDto> Select(String id){
		try {
			if(id==null && id=="") {
				throw new Exception("ID is Null");
			}
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
					dto.setAuthority(rs.getString("authority"));
					list.add(dto);
				}
			}
			
			System.out.println(list);
			rs.close();
			pstmt.close();
			System.out.println("select successed...");
			return list;
		} catch (SQLException e) {
			System.out.println("select su");
			e.printStackTrace();
		}catch(Exception f) {
			System.out.println("에러 : " + f.getMessage());
		}
		
		return null;
		
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
		
		if( result > 0) {
			System.out.println("update successed...");
		}else {
			System.out.println("update failed...");
		}
		return result > 0;
	}
	
	
	
	// DELETE

	public void Delete(String id) throws Exception {
		try {
			pstmt = conn.prepareStatement("delete from member where id = ?");
			pstmt.setString(1, id);
		}finally {
			int result = pstmt.executeUpdate();
			if(result > 0) {
			
				try {
					pstmt.close();
					System.out.println("delete successed...");
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}else {
				System.out.println("delete failed..");
			}
		}
		
		
			
	
		
	}
	
	
	
	
	
	
	
	
}
