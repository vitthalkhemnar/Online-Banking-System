package com.controller;

import java.io.IOException;

import com.dao.AccountDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/withdraw")
public class WithdrawMoney extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String username = (String)session.getAttribute("check");
		int wamount = Integer.parseInt(req.getParameter("wamt"));
		
		if(new AccountDao().withdrawAmount(username, wamount).equals("success")) {
			res.sendRedirect("dashboard.jsp");
		} else {
			res.sendRedirect("withdraw.jsp");
		}
	}
}
