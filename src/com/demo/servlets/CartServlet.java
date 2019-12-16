package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String caketypes[] = request.getParameterValues("caketype");
		String qty[] = request.getParameterValues("qty");
//		for(String ct : caketypes) {
//			System.out.println(ct);
//		}
//		for(String qt : qty) {
//			System.out.println(qt);
//		}
		HttpSession session=request.getSession();
		ArrayList<String> cartCaketype = (ArrayList<String>) session.getAttribute("cartCaketype");
		
		if (cartCaketype == null) {
			cartCaketype = new ArrayList<String>();
		}	
		
		for (String caketype : caketypes) {
			cartCaketype.add(caketype);
		}

		
		
		session.setAttribute("cartCaketype", cartCaketype);
		session.setAttribute("cartQty", qty);
		response.sendRedirect("cart.jsp");
//		/*
			// System.out.println(userName + " : " + password);
//		if (userName.equals("admin") && password.equals("admin")) {
//			response.sendRedirect("cart.jsp");
//			/*
//			 * out.println("<body text = blue>"); out.println("<h3> Welcome to Dashboard!");
//			 * //out.println("<a hred = 'login.html'>Back</a>"); out.println("</body>");
//			 */
//		} else {
//			response.sendRedirect("error.jsp");
//			/*
//			 * out.println("<body text = red>"); out.println("<h3> Error page!");
//			 * out.println("<a href = 'login.html'>Back</a>"); out.println("</body>");
//			 */
//		}
	}

}
