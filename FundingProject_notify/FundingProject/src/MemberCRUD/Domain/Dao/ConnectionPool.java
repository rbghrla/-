package MemberCRUD.Domain.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionPool {

	protected String url="jdbc:mysql://localhost:3306/memberdb"; //bookdb와 연결
	protected String id = "root";
	protected String pw = "1234";
	
	protected Connection conn = null;
	protected PreparedStatement pstmt = null;
	protected ResultSet rs = null;
	
	private static ConnectionPool instance;
	public static ConnectionPool getInstance() throws Exception {
		if(instance==null)
			instance=new ConnectionPool();
		return instance;
	}
	
	private ConnectionPool() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver"); //Driver 경로 지정
		conn = DriverManager.getConnection(url,id,pw); //db의 url,id,pw 와 연결
		System.out.println("ConnectionPool's DB Connected..");
	}

	public Connection getConnection() {
		// TODO Auto-generated method stub
		return conn;
	}
	
}



