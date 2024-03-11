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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.ischien.bean.EmpBean;
import com.ischien.util.Util;

public class EmpDao {

	//新增
	PreparedStatement stmt;
	  Connection conn;
	public void insert(EmpBean emp) {
//		boolean isSucess = false;
		
		try {	
			
			conn = Util.createConnection();

		String SQL="INSERT INTO WorkshopCourse VALUES(?,?,?,?,?,?)";
		stmt = conn.prepareStatement(SQL);
					
			stmt.setDate(1, (Date)emp.getCourseDate());
			stmt.setString(2, emp.getCourseTime());
			stmt.setString(3, emp.getCourseName());
			stmt.setString(4, emp.getTeacher());
			stmt.setString(5, emp.getLocation());
			stmt.setInt(6, emp.getPrice());
			stmt.execute();
	
				
		}  catch (SQLException e) {		
			e.printStackTrace();
		}finally {
			Util.closeConnection(conn,stmt);
		}	
	}
	//刪除

	public void delete(String courseId) {
		 Connection conn =null;
		try {	
			 
			conn = Util.createConnection();

		String SQL="DELETE WorkshopCourse WHERE COURSEID=?";
		PreparedStatement stmt = conn.prepareStatement(SQL);
			stmt.setString(1, courseId);		
			stmt.execute();

			
		}  catch (SQLException e) {		
			e.printStackTrace();
		}finally {
			Util.closeConnection(conn,stmt);
		}
	}
	
	//查單筆
	ResultSet rs ;
		public EmpBean GetData(String courseId) {
			Connection conn =null;
			EmpBean emp =new EmpBean();
			
			try {	
				conn = Util.createConnection();

				String SQL="SELECT*FROM WorkshopCourse WHERE COURSEID=?";
				PreparedStatement stmt = conn.prepareStatement(SQL);	
				stmt.setString(1, courseId);
				
//				stmt.execute();
				
				rs =stmt.executeQuery();
				
				while(rs.next()) {
					
					emp.setCourseId(rs.getInt("COURSEID"));
					emp.setCourseDate((java.util.Date)rs.getDate("COURSE_DATE"));
					emp.setCourseTime(rs.getString("COURSE_TIME"));
					emp.setCourseName(rs.getString("COURSE_NAME"));
					emp.setTeacher(rs.getString("TEACHER"));
					emp.setLocation(rs.getString("LOCATION"));
					emp.setPrice(rs.getInt("PRICE"));
				}

		
			}  catch (SQLException e) {		
				e.printStackTrace();
			} finally {
				Util.closeConnection(conn,stmt,rs);
			}	
			return emp;
		}
	
	
	//查日期
	public List<EmpBean> GetDate(String CourseDate) {
		Connection conn =null;
		List<EmpBean> emps = new ArrayList<EmpBean>();
		
		try {	
			conn = Util.createConnection();


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
	
		}  catch (SQLException e) {		
			e.printStackTrace();
		} finally {
			Util.closeConnection(conn,stmt,rs);
		}		
		return emps;
	}
	
	//改
	public void update(EmpBean emp) {
		Connection conn =null;
		try {	
			conn = Util.createConnection();


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
	
		
		}  catch (SQLException e) {
		
			e.printStackTrace();
		} finally {
			Util.closeConnection(conn,stmt);
		}		
	}
		
	//查全部
	public List<EmpBean> GetDatas(){
		Connection conn =null;
		List<EmpBean> emps = new ArrayList<EmpBean>();
		try {
			conn = Util.createConnection();
			
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
	
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		} finally {
			Util.closeConnection(conn,stmt,rs);
		}
		return emps;
	
		
	}
	

	
}
