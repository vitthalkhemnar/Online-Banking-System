package com.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Random;

import com.dao.AccountDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/createAccount")
public class CreateAccount extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		String email = req.getParameter("email");
		String dob = req.getParameter("dob");
		String gender = req.getParameter("gender");
		String mar = req.getParameter("mar-status");
		String branch = req.getParameter("branch");
		String uname = req.getParameter("uname");
		String pass = req.getParameter("pass");
		
		Random rand = new Random();
		Long rand1 = rand.nextLong(10000000000l, 999999999999l);
		Long rand2 = rand.nextLong(100000, 999999);
		
		String accno = rand1.toString();
		String ifscNo = rand2.toString();
		
		if(new AccountDao().insertIntoUserInfo(fname, lname, phone, email, address, dob, gender, mar, uname, pass, accno, ifscNo, branch).equals("success")) {
			res.sendRedirect("login.html");
		} else {
			res.sendRedirect("createAcc.html");
		}
	}
}
