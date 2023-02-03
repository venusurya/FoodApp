package com.ty.jsp_application_eb8_prc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import com.ty.jsp_application_eb8_prc.dao.FoodOrderDao;
import com.ty.jsp_application_eb8_prc.dto.FoodOrder;
import com.ty.jsp_application_eb8_prc.dto.Items;

@WebServlet("/foodorderlist")
public class OrderListController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		HttpSession session=req.getSession();
		String email=(String)session.getAttribute("email");
		
		FoodOrderDao dao=new FoodOrderDao();
		FoodOrder order=dao.getFoodOrderByEmail(email);
		System.out.println(order);
		List<Items>list=order.getItems();
		
		
		req.setAttribute("list", list);
		RequestDispatcher dispatcher=req.getRequestDispatcher("orders.jsp");
		dispatcher.forward(req, resp);
		
		
	}

}
