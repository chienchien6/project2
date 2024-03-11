<%@ page language="java" contentType="text/html; charset=UTF-8"  import="java.util.*,com.ischien.bean.EmpBean"%>
  <%! @SuppressWarnings("unchecked") %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>工作坊課程資訊</title>
<style>
.position{
float:right;
margin-right:300px;
}
</style>
</head>
<body style='background-color:#fdf5e6'>
<div class="position">
<h2>工作坊課程資訊</h2>
	<table border="1" >
	<tr style="background-color:#a8fefa">
	<th>課程編號<th>課程日期<th>課程時間<th>課程名稱<th>上課老師<th>上課地點<th>課程價格<th>更新<th>刪除</th></tr>
	<%List<EmpBean>emps=(ArrayList<EmpBean>)request.getAttribute("emps");
	for(EmpBean emp:emps){%>
	
	
	<tr>
		<td><%=emp.getCourseId()%></td>
		<td><%=emp.getCourseDate() %></td>
		<td><%=emp.getCourseTime()%></td>
		<td><%=emp.getCourseName()%></td>
		<td><%=emp.getTeacher() %></td>
		<td><%=emp.getLocation() %></td>
		<td><%=emp.getPrice() %></td>
		<td><form action="WSGetUpdateData" method="post">
		
		<input type="hidden" name="COURSEID" value="<%=emp.getCourseId()%>">
		<button type="submit" class="update">更新</button>
		
		</form></td>
		<td><form action="WSdelete" method="post">
		
		<input type="hidden" name="COURSEID" value="<%=emp.getCourseId()%>">
		<button type="submit" class="delete">刪除</button>
		
		</form></td>
	
		<!--<td><button name="order" value="<%=emp.getCourseId()%>">加入購物車</button></td> -->
	</tr>
	
	<% }%>
	</table>
	<h3>共<%= emps.size() %>筆員工資料</h3>
	<a href="/project2/html/WSindex.html"><input type="submit" value="回主頁"></a>
	
	<!--<form method="post"action="html/index.html">
		<button>回首頁</button>
	</form>-->
	 <script>
        const update = document.querySelector('.update')
        add.addEventListener('click', function () {
            location.href = 'WSGetUpdateData.html'
        })

        

        const delete = document.querySelector('.delete')
        getAll.addEventListener('click', function () {
            location.href = '../WSdelete'
        })
    </script>
	
</div>
</body>
</html>