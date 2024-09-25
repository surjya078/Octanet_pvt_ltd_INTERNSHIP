<%@page import="com.jsp.entity.JobPortal"%>
<%@page import="java.util.List"%>
<html>
<body>
<% List<JobPortal> jlist = (List<JobPortal>) request.getAttribute("jobobj"); %>

<table border="2" align="center" cellpadding="20px">
		<th>Id</th>
		<th>Skill</th>
		<th>State</th> 
		<th>Role</th>
		<th>Location</th>
		<th>Company</th>

		<%
		for (JobPortal p : jlist) {
		%>
		<tr>
			<td><%=p.getId()%></td>
			<td><%=p.getSkill() %></td>
			<td><%=p.getState()%></td>
			<td><%=p.getRole()%></td>
			<td><%=p.getLocation()%></td>
			<td><%=p.getCompany()%></td>
			
		</tr>
		<%
		}
		%>

	</table>

</body>
</html>
