package com.ischien.controller;

import java.io.IOException;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.ischien.bean.EmpBean;
import com.ischien.dao.EmpDao;



@WebServlet("/WSupdate")
public class WSupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public WSupdate() {
        super();
    }

	
    Connection conn;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
	
		
		DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		
		EmpBean emp =new EmpBean();
		
		String courseDate =request.getParameter("COURSE_DATE");
        LocalDate localDate = LocalDate.parse(courseDate,date);
        emp.setCourseDate(java.sql.Date.valueOf(localDate));
        
        emp.setCourseId(Integer.parseInt(request.getParameter("COURSEID")));
		emp.setCourseTime(request.getParameter("COURSE_TIME"));
		emp.setCourseName(request.getParameter("COURSE_NAME"));
		emp.setTeacher(request.getParameter("TEACHER"));
		emp.setLocation(request.getParameter("LOCATION"));
		emp.setPrice(Integer.parseInt(request.getParameter("PRICE")) );
		
		EmpDao dao= new EmpDao();	
		dao.update(emp);
		
		request.setAttribute("emp", emp);
		
		List<EmpBean> empsBeans = dao.GetDatas();
		request.setAttribute("emps", empsBeans);
		request.getRequestDispatcher("/JSP/WSGetAllEmps.jsp")
		.include(request, response);
		request.getRequestDispatcher("/JSP/back.jsp")
		.include(request, response);
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
