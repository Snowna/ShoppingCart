package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		//System.out.println(userName + " : " + password);
		if (userName.equals("admin") && password.equals("admin")) {
			response.sendRedirect("cart.jsp");
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
