<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transfer Money | OBS</title>
<style type="text/css">
	@import url('https://fonts.googleapis.com/css2?family=Brygada+1918&family=Cinzel&family=Edu+TAS+Beginner:wght@500&family=Josefin+Slab&family=Kanit&family=Mooli&family=Open+Sans&family=Rajdhani:wght@500&family=Roboto+Slab&family=Sometype+Mono&family=Source+Code+Pro:wght@300&family=Special+Elite&family=Ubuntu:wght@300&display=swap');

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
	
	.container {
		margin: 80px 500px;
		border: 1px solid blue;
		border-radius: 10px;
	}
	
	.heading {
		text-align: center;
		padding: 30px 0px;
	}
	
	.heading h1 {
		font-family: Roboto Slab;
		text-transform: uppercase;
		font-weight: bold;
		color: #001B79;
	}
	
	.f1 {
		font-size: 20px;
		align-items: center;
		padding-top: 12px;
		padding-bottom: 30px;
		font-family: Kanit;
		display: flex;
		flex-direction: column;
		justify-content: center;
	}
	
	.f1 input {
		width: 300px;
		height: 24px;
		margin: 8px 0px;
		margin-bottom: 20px;
		border-radius: 6px;
		border-color: #7B66FF;
	}
	
	.btn {
		margin-top: 16px;
	}
	
	button {
		font-size: 16px;
		font-family: Kanit;
		font-weight: bold;
		padding: 6px 16px;
		border-radius: 8px;
		cursor: pointer;
		background-color: white;
		color: #7B66FF;
		border: 1px solid #7B66FF;
		margin: 5px;
		text-transform: uppercase;
	}
	
	button:hover {
		background-color: #7B66FF;
		color: white;
		border: 1px solid #7B66FF;
	}
</style>
</head>
<body>
	<div class="back">
		<a href="dashboard.jsp">&laquo;</a>
	</div>
	<div class="container">
		<div class="heading">
			<h1>Transfer Money Section</h1>
		</div>
		<div class="form">
			<form class="f1" action="transfer">
				Enter Reciever's Account Number
				<input type="text" name="rec">
				
				Enter Amount to Transfer
				<input type="number" name="tamt">
				<div class="btn">
					<button>Transfer</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>