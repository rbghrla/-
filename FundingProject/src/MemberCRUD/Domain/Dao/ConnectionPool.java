package MemberCRUD.Domain.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionPool {
	protected String url = "jdbc:mysql://localhost:3306/memberdb";
	protected String id = "root";
	protected String pw = "1234";

	protected Connection conn = null;
	protected PreparedStatement pstmt = null;
	protected ResultSet rs = null;
	
	// 싱글톤 패턴 (객체 생성을 단일화 시킴)
	private static ConnectionPool instance;
	public static ConnectionPool getInstance() throws Exception {
		if(instance == null)
			instance = new ConnectionPool();
		return instance;
	}
	
	private ConnectionPool() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");			// driver 경로 찾아서 메모리에 적재
		conn = DriverManager.getConnection(url,id,pw);		// conn 객체 생성 (DB와 연결 객체)
		System.out.println("ConnectionPool's DB Connected...");
	}

	public Connection getConnection() {
		return conn;
	}
	
}
