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
import com.ty.jsp_application_eb8_prc.dao.MenuDao;
import com.ty.jsp_application_eb8_prc.dto.FoodOrder;
import com.ty.jsp_application_eb8_prc.dto.Menu;

@WebServlet("/neworder")
public class NewOrderController  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MenuDao menuDao = new MenuDao();
		List<Menu> menus = menuDao.getAllMenus();
		
		
		req.setAttribute("menus", menus);
		RequestDispatcher dispatcher = req.getRequestDispatcher("staff.jsp");
		dispatcher.forward(req, resp);

	}

}
