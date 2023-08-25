package com.learning.NoticeServlet;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class NoticeController {
	
	public int id;
	public String name;
	public String number;
	public String comment;
	
	private Connection cnx= null;
	private Statement st =null;
	private ResultSet rs =null;
	
	public void selectQuery() {
		
		try {
		
		cnx=DriverManager.getConnection("jdbc:mysql://localhost:3306/Notice","Neeraj","Rsvs@80382");
		st = cnx.createStatement();
		rs = st.executeQuery("SELECT * from ContactFormData order by id DESC limit 6");
		System.out.println("likes_id , user_id, post_id, other_user_id");
		while(rs.next()) {
		this.id= rs.getInt("id");
		this.name= rs.getString("name");
		this.number=rs.getString("number");
		this.comment=rs.getString("comment");
		}
		rs.close();
		st.close();
		cnx.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getName() {
		return this.name;
	}

	public String getNumber() {
		return this.number;
	}
	
	public String getComment() {
		return this.comment;
	}
	
	public void saveNotice(String name,String number,String content) {
		String insert = "insert into ContactFormData (name, number, content) values(?,?,?)";
		try {

			
			cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/Notice", "Neeraj", "Rsvs@80382");
			PreparedStatement st = cnx.prepareStatement(insert);
			st.setString(1, name);
			st.setString(2, number);
			st.setString(3, content);
			st.executeUpdate();
			st.close();
			cnx.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}

