package com.DAO;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;





public class webDAO {
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	public void getconn() throws Exception{
		
		
		InputStream in = (this.getClass().getResourceAsStream("../../../../db.properties"));
		//현재 작업중인 java파일의 class파일을 기준으로 db.properties파일을 읽어올꺼야
		
		Properties p = new Properties();
		p.load(in);
		
		
		
		String url= p.getProperty("dburl"); 
		// 아이피를 바꾸면 상대의 데이터베이스에 접근할수있따.
		String dbid = p.getProperty("dbid");
		String dbpw = p.getProperty("dbpw");
		Class.forName(p.getProperty("dbclass"));
		// 동적로딩
		conn = DriverManager.getConnection(url,dbid,dbpw);
		// DBMS id와 pw를 인증을 받고 DB를 핸들링 할수 있는 Connection 객체를 생성
	}

	public int Join(String id, String pw, String name,String personnumber, String sex) throws Exception{
		getconn();
		pst = conn.prepareStatement("insert into ssum values(?,?,?,?,?)");
		pst.setString(1, id);
		pst.setString(2, pw);
		pst.setString(3, name);
		pst.setString(4, personnumber);
		pst.setString(5, sex);
		int cnt = pst.executeUpdate();
		return cnt;
	}
	
	public int login(String id, String pw) throws Exception{
		getconn();
		pst = conn.prepareStatement("select * from ssum where id = ?");
		pst.setString(1,id);
		rs = pst.executeQuery();
		int a = 0;
		if(rs.next()) {
			String getpw = rs.getString(2);
			if(pw.equals(getpw)) {
				a =1 ;
			}
		}else {
			a =2 ;
		}
		return a;
	}

	
	
	
	
	
	
}






