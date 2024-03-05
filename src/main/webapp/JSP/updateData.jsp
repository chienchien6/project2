<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>工作坊課程資訊</title>
</head>
<body style="bakground-color:#fdf5e6">
<div align="center">
<h2>工作坊課程資訊</h2>
<form method="post" action="update">
<jsp:useBean id="emp" scope="request" class="com.ischien.bean.EmpBean"/>
	<table>
	<tr><td>課程編號
		<td><input style="background-color: #7B7B7B; "type="text"   value="<%= emp.getCourseId() %>" readonly name="COURSEID">
	<tr><td>課程日期<td><input type="text" value="<%= emp.getCourseDate() %>" name="COURSE_DATE">
	<tr><td>課程時間<td><input type="text"  value="<%= emp.getCourseTime() %>" name="COURSE_TIME">
	<tr><td>課程名稱<td><input type="text"  value="<%= emp.getCourseName() %>" name="COURSE_NAME">
	<tr><td>上課老師<td><input type="text" value="<%= emp.getTeacher() %>" name="TEACHER">
	<tr><td>上課地點<td><input type="text" value="<%= emp.getLocation() %>" name="LOCATION">
	<tr><td>課程價格<td><input type="text" value="<%= emp.getPrice() %>" name="PRICE">
	<input type="submit" value="確定"/>

	</table>
</form>
</div>

</body>
</html>