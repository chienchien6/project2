package com.ischien.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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




@WebServlet("/WSdelete")
public class WSdelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public WSdelete() {
        super();
    }

	
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String CourseId = request.getParameter("COURSEID");
		//上面這行是跟html的name連接
	
		EmpDao dao= new EmpDao();
		dao.delete(CourseId);
		
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
