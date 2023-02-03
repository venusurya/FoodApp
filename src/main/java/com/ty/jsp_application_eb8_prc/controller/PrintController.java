package com.ty.jsp_application_eb8_prc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.jsp_application_eb8_prc.dao.FoodOrderDao;
import com.ty.jsp_application_eb8_prc.dao.ItemsDao;
import com.ty.jsp_application_eb8_prc.dto.FoodOrder;
import com.ty.jsp_application_eb8_prc.dto.Items;

@WebServlet("/print")
public class PrintController extends HttpServlet {
           
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		long phone = Long.parseLong(req.getParameter("phone"));
		List<Items> items = ConfirmOrderController.list;

		FoodOrder foodOrder = new FoodOrder();
		foodOrder.setName(name);
		foodOrder.setEmail(email);
		foodOrder.setAddress(address);
		foodOrder.setPhone(phone);
		foodOrder.setItems(items);
		
		FoodOrderDao dao = new FoodOrderDao();
		FoodOrder foodOrder2 = dao.saveFoodOrder(foodOrder);
		if (foodOrder2 != null) {
			req.setAttribute("foodorder", foodOrder2);
			req.setAttribute("message", "Thank You!!! Have a nice food..............!!!");
			RequestDispatcher dispatcher = req.getRequestDispatcher("end.jsp");
			dispatcher.forward(req, resp);
		}
	}

}
