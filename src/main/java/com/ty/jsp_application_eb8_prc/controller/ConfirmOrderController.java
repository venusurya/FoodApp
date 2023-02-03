package com.ty.jsp_application_eb8_prc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.jsp_application_eb8_prc.dao.ItemsDao;
import com.ty.jsp_application_eb8_prc.dao.UserDao;
import com.ty.jsp_application_eb8_prc.dto.Items;
import com.ty.jsp_application_eb8_prc.dto.User;

@WebServlet("/saveorder")
public class ConfirmOrderController extends HttpServlet {
	static List<Items> list=new ArrayList<>();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		long price = Long.parseLong(req.getParameter("price"));
		String offer = req.getParameter("offer");
		long quantity = Long.parseLong(req.getParameter("quantity"));
		
		UserDao dao2=new UserDao();
		HttpSession session=req.getSession();
		String email=(String)session.getAttribute("email");
	
		

		Items items = new Items();
		items.setName(name);
		items.setDescription(description);
		items.setPrice(price);
		items.setOffer(offer);
		items.setQuantity(quantity);

		ItemsDao dao = new ItemsDao();
		Items items2 = dao.saveItems(items);
		list.add(items2);
		if (items2 != null) {
			
			if(email!=null) {
				User user=dao2.getUserByEmail(email);
			req.setAttribute("user", user);
			req.setAttribute("list", list);
			RequestDispatcher dispatcher = req.getRequestDispatcher("foodorder.jsp");
			dispatcher.forward(req, resp);
		   }
//			String email_S=(String)session.getAttribute("semail");
//			req.setAttribute("mail", email_S);
			req.setAttribute("list", list);
			RequestDispatcher dispatcher = req.getRequestDispatcher("foodorder2.jsp");
			dispatcher.forward(req, resp);
		}

	}

}
