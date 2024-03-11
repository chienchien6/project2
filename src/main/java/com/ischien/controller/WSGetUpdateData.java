package com.ischien.controller;

import java.io.IOException;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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



@WebServlet("/WSGetUpdateData")
public class WSGetUpdateData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public WSGetUpdateData() {
        super();
    }

	
    Connection conn;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String CourseId = request.getParameter("COURSEID");		
		EmpDao dao= new EmpDao();
		EmpBean emp =dao.GetData(CourseId);
		System.out.println(emp);
		request.setAttribute("emp", emp);
//updateData.jsp	<jsp:useBean id="emp" 

		request.getRequestDispatcher("/JSP/WSupdateData.jsp").forward(request, response); 
		
		
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
