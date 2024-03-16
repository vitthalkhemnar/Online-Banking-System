package com.controller;

import java.io.IOException;
import com.dao.AccountDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginAccount extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uname = req.getParameter("uname");
		String pass = req.getParameter("pass");
				
		if(new AccountDao().checkAccount(uname, pass).equals("success")) {
			HttpSession session = req.getSession();
			session.setAttribute("check", uname);
			res.sendRedirect("dashboard.jsp");
		} else {
			res.sendRedirect("login.html");
		}
	}
}
