<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.dao.AccountDao"%>
<%@page import="com.entity.Account"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard | FinVista</title>
<style type="text/css">
	@import url('https://fonts.googleapis.com/css2?family=Brygada+1918&family=Cinzel&family=Edu+TAS+Beginner:wght@500&family=Josefin+Slab&family=Kanit&family=Mooli&family=Open+Sans&family=Rajdhani:wght@500&family=Roboto+Slab&family=Sometype+Mono&family=Source+Code+Pro:wght@300&family=Special+Elite&family=Ubuntu:wght@300&display=swap');

	* {
		margin: 0;
		padding: 0;
	}
	
	.head-dash {
		font-family: Roboto Slab;
		text-transform: uppercase;
		text-align: center;
		padding: 20px;
		margin-top: 20px;
	}
	
	.heading {
		text-align: center;
		padding: 30px 0px;
	}
	
	.heading h2 {
		font-family: Roboto Slab;
		text-transform: uppercase;
		font-weight: bold;
		color: #001B79;
	}
	
	.logout {
		text-align: right;
		margin-right: 170px;
	}
	
	.logout a {
		text-decoration: none;
		font-family: Kanit;
		font-size: 20px;
	}
	
	.logout a:hover {
		color: #7B66FF;
	}
	
	.container {
		margin: 0px 160px;
		display: flex;
		padding: 20px 0px;
	}

	.services {
		width: 500px;
		margin-right: 20px;
		padding: 0px 40px;
		padding-bottom: 30px;
		border: 2px solid blue;
		border-radius: 8px;
	}
	
	.details {
		width: 600px;
		margin-left: 20px;
		padding-bottom: 20px;
		border: 2px solid blue;
		border-radius: 8px;
	}
	
	.ser-btn {
		text-align: center;
	}
	
	.ser-btn ul li {
		list-style-type: none;
		margin-top: 10px;
		margin-bottom: 20px;
	}
	
	.ser-btn button {
		width: 260px;
		font-size: 18px;
		font-weight: bold;
		font-family: Rajdhani;
		text-transform: uppercase;
		padding: 6px 16px;
		border-radius: 8px;
		cursor: pointer;
		color: #7B66FF;
		background-color: white;
		border: 1px solid #7B66FF;
	}
	
	.ser-btn button:hover {
		color: white;
		background-color: #7B66FF;
		border: 1px solid #7B66FF;
	}

	.tbl {
		font-family: Rajdhani;
		font-size: 20px;
		font-weight: bold;
		display: flex;
		justify-content: left;
		margin: 8px 40px;
		margin-top: 0px;
	}
	
	table tr td {
		padding: 4px 14px;
	}
	
	.val {
		font-weight: 100;
	}

	.up-btn {
		margin-left: 54px;
	}
	
	.up-btn a {
		text-decoration: none;
		font-family: Kanit;
		font-size: 14px;
		color: blue;
	}
	
	.up-btn a:hover {
		color: #7B66FF;
	}
}
</style>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" integrity="sha512-9usAa10IRO0HhonpyAIVpjrylPvoDwiPUiKdWk5t3PyolY1cOd4DSE0Ga+ri4AuTroPR5aQvXU9xC6qOPnzFeg==" crossorigin="anonymous" referrerpolicy="no-referrer" />          
</head>
<body>
	<% 
		String fname = "";
		String lname = "";
		String phone = "";
		String email = "";
		String address  = "";
		String dob = "";
		String gender = "";
		String mar = "";
		String branch = "";
		String accno = "";
		String ifsc = "";
		int balance = 0;
	
		ArrayList<Account> al = null;
		
		String username = null;
		username = (String)session.getAttribute("check");
		
		if(username != null) {	
			al = new AccountDao().readAccountDetails(username);
			
			for(int i = 0; i < al.size(); i++) {
				fname = al.get(i).getFname();
				lname = al.get(i).getLname();
				phone = al.get(i).getPhone();
				email = al.get(i).getEmail();
				address = al.get(i).getAddress();
				dob = al.get(i).getDob();
				gender = al.get(i).getGender();
				mar = al.get(i).getMar();
				branch = al.get(i).getBranch();
				accno = al.get(i).getAccno();
				ifsc = al.get(i).getIfsc();
			}
	%>
	<div class="head-dash">
		<h1>Dashboard</h1>
	</div>
	<div class="logout">
		<a href="logout"><i class="fa">&#xf08b;</i></a>
	</div>
	<div class="container">
		<div class="services">
			<div class="heading">
				<h2>Banking Services</h2>
			</div>
			<div class="ser-btn">
				<ul>
					<li><a href="balance"><button>Check Balance</button></a></li>
					<li><a href="deposit.jsp"><button>Deposit Money</button></a></li>
					<li><a href="withdraw.jsp"><button>Withdraw Money</button></a></li>
					<li><a href="transfer.jsp"><button>Transfer Money</button></a></li>
				</ul>
			</div>
		</div>
		<div class="details">
			<div class="heading">
				<h2>Account Details</h2>
			</div>
			<div class="up-btn">
				<a href="update"><i class='fa-solid fa-pen-to-square'></i></a>
			</div>
			<div class="tbl">
				<table>
					<tbody>
						<tr>
							<td>Account Holder Name: </td>
							<td class="val"><%= fname %>&nbsp;<%= lname %></td>
						</tr>
						<tr>
							<td>Phone No: </td>
							<td class="val"><%= phone %></td>
						</tr>
						<tr>
							<td>Email: </td>
							<td class="val"><%= email %></td>
						</tr>
						<tr>
							<td>Address: </td>
							<td class="val"><%= address %></td>
						</tr>
						<tr>
							<td>Date of birth: </td>
							<td class="val"><%= dob %></td>
						</tr>
						<tr>
							<td>Gender: </td>
							<td class="val"><%= gender %></td>
						</tr>
						<tr>
							<td>Marital Status: </td>
							<td class="val"><%= mar %></td>
						</tr>
						<tr>
							<td>Account No: </td>
							<td class="val"><%= accno %></td>
						</tr>
						<tr>
							<td>IFSC NO: </td>
							<td class="val"><%= ifsc %></td>
						</tr>
						<tr>
							<td>Branch: </td>
							<td class="val"><%= branch %></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<% 
		} else {
			response.sendRedirect("login.html");
		}
	%>
</body>
</html>