package com.ischien.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ischien.bean.EmpBean;
import com.ischien.dao.EmpDao;



@WebServlet("/SearchByDate")
public class SearchByDate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SearchByDate() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String CourseDate = request.getParameter("COURSE_DATE");		
		EmpDao dao = new EmpDao();	
		List<EmpBean> emps = dao.GetDate(CourseDate);	
		request.setAttribute("emps", emps);
			
		request.getRequestDispatcher("/JSP/GetAllEmps.jsp").forward(request, response);
			
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
