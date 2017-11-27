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
		//���� �۾����� java������ class������ �������� db.properties������ �о�ò���
		
		Properties p = new Properties();
		p.load(in);
		
		
		
		String url= p.getProperty("dburl"); 
		// �����Ǹ� �ٲٸ� ����� �����ͺ��̽��� �����Ҽ��ֵ�.
		String dbid = p.getProperty("dbid");
		String dbpw = p.getProperty("dbpw");
		Class.forName(p.getProperty("dbclass"));
		// �����ε�
		conn = DriverManager.getConnection(url,dbid,dbpw);
		// DBMS id�� pw�� ������ �ް� DB�� �ڵ鸵 �Ҽ� �ִ� Connection ��ü�� ����
	}

	public int Join(String email, String pw, String tel,String address) throws Exception{
		getconn();
		pst = conn.prepareStatement("insert into web_member values(?,?,?,?)");
		pst.setString(1, email);
		pst.setString(2, pw);
		pst.setString(3, tel);
		pst.setString(4, address);
		int cnt = pst.executeUpdate();
		return cnt;
	}
	
	public int login(String id, String pw) throws Exception{
		getconn();
		pst = conn.prepareStatement("select * from web_member where email = ?");
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

	
	
	public int update(String email, String pw, String tel, String address) throws Exception{
		getconn();
		pst = conn.prepareStatement("update web_member set pw=?,tel=?,address=? where email =? ");
		pst.setString(1,pw);
		pst.setString(2,tel);
		pst.setString(3,address);
		pst.setString(4,email);
		int cnt = pst.executeUpdate();
		return cnt;
	}

	public int messageinsert(String name,String email,String message) throws Exception{
		
		getconn();
		pst = conn.prepareStatement("insert into web_message values(message_num.nextval,?,?,?,sysdate)");
		pst.setString(1,name);
		pst.setString(2,email);
		pst.setString(3,message);
		int cnt = pst.executeUpdate();
		return cnt;
	}
	
	
}






