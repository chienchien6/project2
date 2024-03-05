package com.ischien.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.ischien.bean.EmpBean;

public class EmpDao {

	//新增
	  Connection conn;
	public void insert(EmpBean emp) {
//		boolean isSucess = false;
		
		try {	
			Context context = new InitialContext();
			DataSource ds =(DataSource)context.lookup("java:/comp/env/jdbc/danceActivity");
			conn = ds.getConnection();

		String SQL="INSERT INTO WorkshopCourse VALUES(?,?,?,?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(SQL);
				
			
			stmt.setDate(1, (Date)emp.getCourseDate());
			stmt.setString(2, emp.getCourseTime());
			stmt.setString(3, emp.getCourseName());
			stmt.setString(4, emp.getTeacher());
			stmt.setString(5, emp.getLocation());
			stmt.setInt(6, emp.getPrice());
			stmt.execute();
	
		stmt.close();
		conn.close();
				
		}  catch (SQLException e) {		
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}		
	}
	//刪除
	public void delete(String courseId) {
		 Connection conn =null;
		try {	
			 
			Context context = new InitialContext();
			DataSource ds =(DataSource)context.lookup("java:/comp/env/jdbc/danceActivity");
			conn = ds.getConnection();

		String SQL="DELETE WorkshopCourse WHERE COURSEID=?";
		PreparedStatement stmt = conn.prepareStatement(SQL);
			stmt.setString(1, courseId);		
			stmt.execute();
			
		stmt.close();
		conn.close();
			
		}  catch (SQLException e) {		
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}
	
	//查單筆
		public EmpBean GetData(String courseId) {
			Connection conn =null;
			EmpBean emp =new EmpBean();
			
			try {	
				Context context = new InitialContext();
				DataSource ds =(DataSource)context.lookup("java:/comp/env/jdbc/danceActivity");
				conn = ds.getConnection();


				String SQL="SELECT*FROM WorkshopCourse WHERE COURSEID=?";
				PreparedStatement stmt = conn.prepareStatement(SQL);	
				stmt.setString(1, courseId);
				
//				stmt.execute();
				
				ResultSet rs =stmt.executeQuery();
				
				while(rs.next()) {
					
					emp.setCourseId(rs.getInt("COURSEID"));
					emp.setCourseDate((java.util.Date)rs.getDate("COURSE_DATE"));
					emp.setCourseTime(rs.getString("COURSE_TIME"));
					emp.setCourseName(rs.getString("COURSE_NAME"));
					emp.setTeacher(rs.getString("TEACHER"));
					emp.setLocation(rs.getString("LOCATION"));
					emp.setPrice(rs.getInt("PRICE"));
				}

			stmt.close();
			conn.close();
		
			}  catch (SQLException e) {		
				e.printStackTrace();
			} catch (NamingException e) {
				e.printStackTrace();
			}	
			return emp;
		}
	
	
	//查日期
	public List<EmpBean> GetDate(String CourseDate) {
		Connection conn =null;
		List<EmpBean> emps = new ArrayList<EmpBean>();
		
		try {	
			Context context = new InitialContext();
			DataSource ds =(DataSource)context.lookup("java:/comp/env/jdbc/danceActivity");
			conn = ds.getConnection();


			String SQL="SELECT*FROM WorkshopCourse WHERE COURSE_DATE=?";
			PreparedStatement stmt = conn.prepareStatement(SQL);	
			stmt.setString(1, CourseDate);
			
//			stmt.execute();
			
			ResultSet rs =stmt.executeQuery();
			EmpBean emp = null;
			
			while(rs.next()) {
				emp = new EmpBean();
				emp.setCourseId(rs.getInt("COURSEID"));
				emp.setCourseDate((java.util.Date)rs.getDate("COURSE_DATE"));
				emp.setCourseTime(rs.getString("COURSE_TIME"));
				emp.setCourseName(rs.getString("COURSE_NAME"));
				emp.setTeacher(rs.getString("TEACHER"));
				emp.setLocation(rs.getString("LOCATION"));
				emp.setPrice(rs.getInt("PRICE"));
				emps.add(emp);
				
//				System.out.println(emp);
				
			}

		stmt.close();
		conn.close();
		rs.close();
	
		}  catch (SQLException e) {		
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}	
		return emps;
	}
	
	//改
	public void update(EmpBean emp) {
		Connection conn =null;
		try {	
			Context context = new InitialContext();
			DataSource ds =(DataSource)context.lookup("java:/comp/env/jdbc/danceActivity");
			conn = ds.getConnection();


			String SQL="UPDATE WorkshopCourse SET COURSE_DATE=?,COURSE_TIME=?,COURSE_NAME=?,TEACHER=?,LOCATION=?,PRICE=? WHERE COURSEID=?";
			PreparedStatement stmt = conn.prepareStatement(SQL);
					
			
			stmt.setDate(1, (Date) emp.getCourseDate());
			stmt.setString(2, emp.getCourseTime());
			stmt.setString(3, emp.getCourseName());
			stmt.setString(4, emp.getTeacher());
			stmt.setString(5, emp.getLocation());
			stmt.setInt(6, emp.getPrice());
			stmt.setInt(7, emp.getCourseId());
			stmt.execute();

		
			
			
		stmt.close();
		conn.close();
		
		
		}  catch (SQLException e) {
		
			e.printStackTrace();
		} catch (NamingException e) {
			
			e.printStackTrace();
		}		
	}
		
	//查全部
	public List<EmpBean> GetDatas(){
		Connection conn =null;
		List<EmpBean> emps = new ArrayList<EmpBean>();
		try {
			Context context = new InitialContext();
			DataSource ds =(DataSource)context.lookup("java:/comp/env/jdbc/danceActivity");
			conn = ds.getConnection();
			
			String SQL="SELECT*FROM WorkshopCourse";
			PreparedStatement stmt = conn.prepareStatement(SQL);
			
			ResultSet rs = stmt.executeQuery();

			EmpBean emp = null;
			
			while(rs.next()) {
				emp = new EmpBean();
				emp.setCourseId(rs.getInt("COURSEID"));
				emp.setCourseDate(rs.getDate("COURSE_DATE"));
				emp.setCourseTime(rs.getString("COURSE_TIME"));
				emp.setCourseName(rs.getString("COURSE_NAME"));
				emp.setTeacher(rs.getString("TEACHER"));
				emp.setLocation(rs.getString("LOCATION"));
				emp.setPrice(rs.getInt("PRICE"));
				
				emps.add(emp);
			}
			
			stmt.close();
			conn.close();
			rs.close();
		
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		} catch (NamingException e) {
			
			e.printStackTrace();
		}
		return emps;
	
		
	}

	
}
