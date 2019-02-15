<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>


	<br>

	<table border=1>
		<tr>
			<td colspan="2" align="center">
				<%
					java.lang.Runtime r = Runtime.getRuntime();
					long total = r.totalMemory() / 1024;
					long livres = r.freeMemory() / 1024;
				%> <b>Total Mem.:</b> <%=total%>&nbsp;Bytes - <b>Livre Mem.:</b> <%=livres%>&nbsp;Bytes
			</td>
		</tr>
	</table>

</body>
</html>