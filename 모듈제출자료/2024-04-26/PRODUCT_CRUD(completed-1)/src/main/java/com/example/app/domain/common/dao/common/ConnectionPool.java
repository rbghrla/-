package com.example.app.domain.common.dao.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConnectionPool {

	//05-03 application.properties
	
	protected String url ="jdbc:mysql://localhost:3306/productdb";
	protected String id = "root";
	protected String pw = "1234";
	

	
	protected Connection conn =null;
	protected PreparedStatement pstmt = null;
	protected ResultSet rs = null;
	
	
	
	private static ConnectionPool instance ;
	public static ConnectionPool getInstance() throws Exception {
		if(instance==null)
			instance=new ConnectionPool();
		return instance;
	}
	
	private ConnectionPool() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url,id,pw);
		System.out.println("ConnectionPool's DB Connected...");
	}

	public Connection getConnection() {
		// TODO Auto-generated method stub
		return conn;
	}
	
	
	
	//05-01 TX
	public void txStart() throws SQLException {
		conn.setAutoCommit(false);	
	}
	//05-01 TX
	public void txCommit() throws SQLException {
		conn.commit();
	}
	//05-01 TX
	public void txRollBack() throws SQLException {
		conn.rollback();
	}
	
	
}
