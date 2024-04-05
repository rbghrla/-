package MemberCRUD.Domain.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import MemberCRUD.Domain.Dto.NotifyDto;

public class NotifyDaoImpl extends CommonDao implements NotifyDao{

	private static NotifyDao instance;
	public static NotifyDao getInstance() throws Exception {
		if(instance==null)
			instance = NotifyDaoImpl.getInstance();
		return instance;
	}
	public NotifyDaoImpl() throws Exception {
		
		System.out.println("[DAO] NotifyDaoImpl's INIT..." +conn);
	
	}
	
	
	//INSERT
	@Override
	public boolean Insert(NotifyDto dto) throws Exception{
		pstmt = conn.prepareStatement("insert into notify values(?,?,NOW())");
		pstmt.setString(1, dto.getId()); 	//첫번째 물음표
		pstmt.setInt(2, dto.getNotifyCode()); 	//두번째 물음표
		
		int result = pstmt.executeUpdate();
		freeConnection(pstmt); //자원정리 pstmt.close() 대신에 사용
		
		if( result>0 ) {
			System.out.println("insert successed..");
		}else {
			System.out.println("insert failed..");
		}
		return result>0;
		
	
	}
	
	
	//SELECT
	@Override
	public List<NotifyDto> SelectAll() throws Exception{
		pstmt = conn.prepareStatement("select * from notify");
		rs = pstmt.executeQuery();
		List<NotifyDto> list = new ArrayList();
		NotifyDto dto = null;
		if(rs != null) {
			while(rs.next()) {
				dto = new NotifyDto();
				dto.setId(rs.getString("id"));
				dto.setNotifyCode(rs.getInt("notifyCode"));
				dto.setNotifyDate(rs.getString("notifyDate"));
				list.add(dto);
				System.out.println(dto);
			}
		}
		freeConnection(pstmt,rs);
		System.out.println("selectAll successed..");
		return list;
	}

	//UPDATE
	@Override
	public boolean Update(String id, NotifyDto dto) throws Exception{
		pstmt = conn.prepareStatement("update notify set id=?, notifyCode=?, notifyDate=NOW() where id=?");
		pstmt.setString(1, dto.getId());
		pstmt.setInt(2, dto.getNotifyCode());
		pstmt.setString(3, id);
		
		
		int result = pstmt.executeUpdate();
		freeConnection(pstmt);
		
		if( result>0 ) {
			System.out.println("update successed..");
		}else {
			System.out.println("update failed..");
		}
		return result>0;
	}
	
	//DELETE
	@Override
	public void Delete(String id) throws Exception {
		try {
			pstmt = conn.prepareStatement("delete from notify where id = ?");
			pstmt.setString(1, id);
		}finally {
			int result = pstmt.executeUpdate();
			if(result > 0) {
			
				try {
					System.out.println("delete successed...");
					freeConnection(pstmt);
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}
			else{
				System.out.println("delete failed..");
			}
		}
	
	}
}
