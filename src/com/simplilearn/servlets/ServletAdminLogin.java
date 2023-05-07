package com.simplilearn.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.entity.Admin;

/**
 * Servlet implementation class ServletAdminLogin
 */
@WebServlet("/admin-login")
public class ServletAdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("admin-login.html").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		
		PrintWriter pw = response.getWriter();
		if(username==null || password==null || username.equals("") || password.equals(""))
		{
			 pw.println("<div>");
				pw.println("<h3> Please enter Username And Password</h3>");
				pw.println("</div>");
		}
		else  if(username.equals("admin") && password.equals("password"))
		{
			response.sendRedirect("admin.html");
		}
		else
		{
			   pw.println("<div>");
				pw.println("<h1> invalid Cerdentials</h1>");
				pw.println("</div>");
		}
	}

}
