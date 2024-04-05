package MemberCRUD.Domain.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CommonDao {
	protected Connection conn = null;
	protected PreparedStatement pstmt = null;
	protected ResultSet rs = null;
	
	protected ConnectionPool connectionPool;
	
	public CommonDao() throws Exception {
		connectionPool = ConnectionPool.getInstance();
		conn = connectionPool.getConnection();
	}
	
	public void freeConnection(Connection conn) throws Exception {
		conn.close();
	}
	public void freeConnection(Connection conn, PreparedStatement pstmt) throws Exception {
		pstmt.close();
		conn.close();
	}
	public void freeConnection(Connection conn, PreparedStatement pstmt, ResultSet rs) throws Exception {
		rs.close();
		pstmt.close();
		conn.close();
	}
	public void freeConnection(PreparedStatement pstmt) throws Exception {
		pstmt.close();
	}
	public void freeConnection(PreparedStatement pstmt, ResultSet rs) throws Exception {
		pstmt.close();
		conn.close();
	}
	
}