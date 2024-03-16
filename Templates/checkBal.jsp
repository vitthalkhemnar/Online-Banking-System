<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Currency"%>
<%@page import="java.util.Locale"%>
<%@page import="com.dao.AccountDao"%>
<%@page import="jakarta.servlet.jsp.tagext.TryCatchFinally"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Balance | OBS</title>
<style type="text/css">
	* {
		margin: 0;
		padding: 0;
	}

	.back {
		margin-left: 60px;
	}
	
	.back a {
		font-size: 40px;
		text-decoration: none;
		font-weight: bold;
		color: #001B79;
	}
	
	.back a:hover {
		color: blue;
	}
	
	.bal {
		background-color: #7B66FF;
		color: white;
		text-align: center;
		padding: 50px;
		font-size: 20px;
		margin: 120px 600px;
		font-family: Cursive;
		border: 2px solid #001B79;
		border-radius: 50%;
		height: 160px;
		width: 160px;
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
	}
	
	.bal p {
		margin: 10px;
	}
	
	#name {
		font-weight: bold;
	}
</style>
</head>
<body>
	<%
		String accno = null;
		accno = (String)session.getAttribute("check");
		
		int bal = 0;
		bal = (int)session.getAttribute("balance");
		
		Locale ind = new Locale("hi", "IN");
		NumberFormat rs = NumberFormat.getCurrencyInstance(ind);
		
		if(accno != null) {
	%>
	<div class="container">
		<div class="back">
			<a href="dashboard.jsp">&laquo;</a>
		</div>
		<div class="bal">
			<p id="name">Available Balance</p>
			<p id="val"><%= rs.format(bal) %></p>
		</div>
	</div>
	<% 
		} else {
			response.sendRedirect("dashboard.jsp");
		}
	%>
</body>
</html>