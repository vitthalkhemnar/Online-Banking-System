package com.controller;

import java.io.IOException;

import com.dao.AccountDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/transfer")
public class TransferMoney extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String username = (String)session.getAttribute("check");
		String recAccNo = req.getParameter("rec");
		int tamount = Integer.parseInt(req.getParameter("tamt"));
		
		if(new AccountDao().transferAmount(username, recAccNo, tamount).equals("success")) {
			res.sendRedirect("dashboard.jsp");
		} else {
			res.sendRedirect("transfer.jsp");
		}
	}
}
