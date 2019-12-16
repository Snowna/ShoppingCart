package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();

		session.setAttribute("username", request.getParameter("username"));
		session.setAttribute("password", request.getParameter("password"));
	
		 
		// if (session == null) {
		String userName = (String) session.getAttribute("username");
		String password = (String) session.getAttribute("password");

		// System.out.println(userName + " : " + password);
		if (userName.equals("admin") && password.equals("admin")) {
			//System.out.println("dopost");
			response.sendRedirect("cart.jsp");
			System.out.println("admin yes");
			/*
			 * out.println("<body text = blue>"); out.println("<h3> Welcome to Dashboard!");
			 * //out.println("<a hred = 'login.html'>Back</a>"); out.println("</body>");
			 */
		} else {
			response.sendRedirect("error.jsp");
			/*
			 * out.println("<body text = red>"); out.println("<h3> Error page!");
			 * out.println("<a href = 'login.html'>Back</a>"); out.println("</body>");
			 */

		}
	}

}
