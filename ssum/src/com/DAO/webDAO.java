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






