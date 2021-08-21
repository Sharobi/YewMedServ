package com.sharobi.pharmacy.admin.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sharobi.pharmacy.admin.dao.AdminDAO;
import com.sharobi.pharmacy.admin.dao.impl.AdminDAOImpl;
import com.sharobi.pharmacy.roles.model.User;

@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		try {
			AdminDAO adminDAO=new AdminDAOImpl();
			User user = new User();
			user.setUserName(request.getParameter("username"));
			user.setPassword(request.getParameter("password"));

			user = adminDAO.login(user);

			if (user.isValid()) {

				HttpSession session = request.getSession(true);
				session.setAttribute("currentSessionUser", user);
				response.sendRedirect("UserLogged.jsp"); // logged-in page
			}

			else
				//response.sendRedirect("invalidLogin.jsp"); // error page
				System.out.println("Invalid login");
		}

		catch (Throwable theException) {
			System.out.println(theException);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		try {
			AdminDAO adminDAO=new AdminDAOImpl();
			User user = new User();
			user.setUserName(request.getParameter("username"));
			user.setPassword(request.getParameter("password"));

			user = adminDAO.login(user);

			if (user.isValid()) {

				HttpSession session = request.getSession(true);
				session.setAttribute("currentSessionUser", user);
				response.sendRedirect("UserLogged.jsp"); // logged-in page
			}

			else
				//response.sendRedirect("invalidLogin.jsp"); // error page
				System.out.println("Invalid login");
		}

		catch (Throwable theException) {
			System.out.println(theException);
		}
	}

}

/**
 * rajarshi
 */
