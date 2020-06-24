<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>��Ӱ��Ϣ</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>
		<table border="1" bordercolor="#66CCCC" align="center" width="60%">
			<tr align="center">
				<td>
					��Ӱ����
				</td>
				<td>
					����
				</td>
				<td>
					����
				</td>
				<td>
					����
				</td>
				<td>
					Ʊ��
				</td>
			</tr>
			<c:choose>
				<c:when test="${empty requestScope.result}">
					<tr>
						<td colspan="5">
							<c:out value="δ�ҵ����������ĵ�Ӱ" />
						</td>
					</tr>
				</c:when>
				<c:when test="${!empty requestScope.result}">
					<c:forEach items="${requestScope.result}" var="film">
						<tr>
							<td>
								${film.filmname}
							</td>
							<td> 
								${film.filmType.typename}
							</td>
							<td>
								${film.actor}
							</td>
							<td>
								${film.director}
							</td>
							<td>
								${film.ticketprice}
							</td>
						</tr>
					</c:forEach>
				</c:when>
			</c:choose>
		</table>
		<p align="center">
			<a href="toCinema" style="text-decoration: none">������ҳ</a>
		</p>
	</body>
</html>
