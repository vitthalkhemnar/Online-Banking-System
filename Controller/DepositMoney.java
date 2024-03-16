package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.dao.AccountDao;
import com.entity.Account;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/deposit")
public class DepositMoney extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String uname = (String)session.getAttribute("check");
		int damount = Integer.parseInt(req.getParameter("damt"));
		
		if(new AccountDao().depositAmount(uname, damount).equals("success")) {
			res.sendRedirect("dashboard.jsp");
		} else {
			res.sendRedirect("deposit.jsp");
		}
	}
}
