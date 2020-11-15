<%@page isELIgnored="false" import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
 <link  rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
    <h3 style="text-align:center">
         INSURANCE POLICY
  <small class="text-muted">Reports Table</small>
</h3>
<c:choose>
	<c:when test="${listDTO ne null && !empty listDTO }">
		<table class="table table-bordered""  align="center">
			<tr>
				<th>POLICY ID</th>
				<th>POLICY LOCATION</th>
				<th>POLICY COMPANY</th>
				<th>POLICY TYPE</th>
			</tr>
			<c:forEach var="policy" items="${listDTO}">
				<tr>
					<td>${policy.id}</td>
					<td>${policy.location}</td>
					<td>${policy.company}</td>
					<td>${policy.type}</td>
				</tr>
			</c:forEach>
	</table>
	  <center>
	   <c:forEach var="i" begin="1" end="${pagesCount}" step="1">
	       <a href="controller?pageNo=${i}&s1=link"> [ ${i} ]</a>  &nbsp; &nbsp; 
	   </c:forEach>
	  </center>
	</c:when>
	<c:otherwise>
		<h2 style="color: red; text-align: center;">No Records Available</h2>
	</c:otherwise>
</c:choose>
<br>
 <center><a href="input.html">HOME</a></center>
