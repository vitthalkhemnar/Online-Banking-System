package com.controller;

import java.io.IOException;

import com.dao.AccountDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/balance")
public class CheckBalance extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String accno = (String)session.getAttribute("check");
		
		session.setAttribute("balance", new AccountDao().checkBalance(accno));
		res.sendRedirect("checkBal.jsp");
	}
}
