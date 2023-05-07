package com.simplilearn.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.simplilearn.entity.Admin;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class ServletResetPassword
 */
@WebServlet("/reset-password")
public class ServletResetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletResetPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oldPass=request.getParameter("opassword");
		String newPass=request.getParameter("nepassword");
		 SessionFactory sf=HibernateUtil.buildSessionFactor();
		 Session session=sf.openSession();
		 
		 String hql = "UPDATE Admin set password = 'demo1' , subject2ID = 'demo2'  WHERE classID = 'Demotest'";
			String f = "UPDATE Admin set ";
			String a="'";
			String b="'";
			String d=",";
			String su1="password =";
			
			String fi=f+su1+a+oldPass+b;
		 
		 
		 List<Admin> admins=session.createQuery(fi).list();
		 
		 PrintWriter pw=response.getWriter();
		 pw.println("<html><body>");
		 for(Admin ab :admins){
		 pw.println("<p> new password is"+ab.getPassword()+"</p>");
	}
		 pw.println("</body></html>");
	}
}
