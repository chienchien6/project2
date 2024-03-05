//package controller2;
//
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.time.LocalDate;
//
//import javax.naming.Context;
//import javax.naming.InitialContext;
//import javax.naming.NamingException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.sql.DataSource;
//
//import com.ischien.bean.EmpBean;
//import com.ischien.dao.EmpDao;
//
//import java.time.format.DateTimeFormatter;
//
//
//@WebServlet("/EmpController2")
//public class EmpController2 extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	
//	  Connection conn;
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		Context context = new InitialContext();
//		DataSource ds =(DataSource)context.lookup("java:/comp/env/jdbc/danceActivity");
//		conn = ds.getConnection();
//		
//		request.setCharacterEncoding("UTF-8");
//		
//		
//		EmpDao empDAO = new EmpDao();
//		String type = request.getParameter("type");
//		String delete = request.getParameter("delete");
//		String upData = request.getParameter("upData");
//		
//		DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		
//        EmpBean emp =new EmpBean();
//   
//		String courseDate =request.getParameter("COURSE_DATE");
//        LocalDate localDate = LocalDate.parse(courseDate,date);
//        emp.setCourseDate(java.sql.Date.valueOf(localDate));
//
//        emp.setCourseId(Integer.parseInt(request.getParameter("COURSEID")));
//		emp.setCourseTime(request.getParameter("COURSE_TIME"));
//		emp.setCourseName(request.getParameter("COURSE_NAME"));
//		emp.setTeacher(request.getParameter("TEACHER"));
//		emp.setLocation(request.getParameter("LOCATION"));
//		emp.setPrice(Integer.parseInt(request.getParameter("PRICE")) );
//		
//			if (type != null) {
//
//				switch (type) {
//
//				case "select": {
//					System.out.println(request.getParameter("ename"));
//					empDAO.select(request, response, conn);
//					request.getRequestDispatcher("/jsp/GetAllEmps.jsp").forward(request, response);
//					break;
//				}
//
//				case "selectOne": {
//					String empno = request.getParameter("empno");
//					empDAO.selectByEmpno(request, response, conn, empno);
//					request.getRequestDispatcher("/jsp/GetEmp.jsp").forward(request, response);
//					break;
//
//				}
//
//				case "insert": {
//					EmpDao.insert(request, response, connection, empBean);
//					break;
//
//				} /*
//					 * case "upDataInsert":{ request.setAttribute("emp", empBean);
//					 * request.getRequestDispatcher("/jsp/UpData.jsp").forward(request, response);
//					 * break;
//					 * 
//					 * }
//					 */
//				case "upData": {
//					System.out.println(empBean.toString());
//					empDAO.upData(request, response, connection, empBean);
////					request.getRequestDispatcher("/jsp/DoneData.jsp").forward(request, response);
//					break;
//
//				}
//
//				case "delete": {
//					System.out.println(empBean.getEmpno());
//					empDAO.delete(request, response, connection);
//					System.out.println("DELETE");
//					break;
//
//				}
//				default:
//					throw new IllegalArgumentException("Unexpected value: " + type);
//				}
//			} else if (delete != null) {
//				empDAO.delete(request, response, connection);
//
//			} else if (upData != null) {
//				empDAO.selectByEmpno(request, response, connection, upData);
////				request.setAttribute("emp", empBean);
//				request.getRequestDispatcher("/jsp/UpData.jsp").forward(request, response);
//			}
//			
//			empDAO.selectAll(request, response, Connection);
//			conn.close();
//			request.getRequestDispatcher("/jsp/GetAllEmps.jsp").forward(request, response);
//		
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		doGet(request, response);
//	}
//
//}