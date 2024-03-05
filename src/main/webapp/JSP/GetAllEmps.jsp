<%@ page language="java" contentType="text/html; charset=UTF-8"  import="java.util.*,com.ischien.bean.EmpBean"%>
  <%! @SuppressWarnings("unchecked") %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>工作坊課程資訊</title>
</head>
<body style='background-color:#fdf5e6'>
<div align="center">
<h2>工作坊課程資訊</h2>
	<table border="1" >
	<tr style="background-color:#a8fefa">
	<th>課程編號<th>課程日期<th>課程時間<th>課程名稱<th>上課老師<th>上課地點<th>課程價格<th>更新<th>刪除</th></tr>
	<%List<EmpBean>emps=(ArrayList<EmpBean>)request.getAttribute("emps");
	for(EmpBean emp:emps){%>
	
	<form method="post" action="EmpContriller2">
	<tr>
		<td><%=emp.getCourseId()%></td>
		<td><%=emp.getCourseDate() %></td>
		<td><%=emp.getCourseTime()%></td>
		<td><%=emp.getCourseName()%></td>
		<td><%=emp.getTeacher() %></td>
		<td><%=emp.getLocation() %></td>
		<td><%=emp.getPrice() %></td>
		<td><button name="upData" value="<%=emp.getCourseId()%>">更新</button></td>
		<td><button name="delete" value="<%=emp.getCourseId()%>"> 刪除</button></td>
	</tr>
	</form>
	<% }%>
	</table>
	<h3>共<%= emps.size() %>筆員工資料</h3>
</div>
</body>
</html>