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
import com.simplilearn.entity.Persons;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class ServletDeletePerson
 */
@WebServlet("/delete-person")
public class ServletDeletePerson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDeletePerson() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionFactory sf=HibernateUtil.buildSessionFactor();
		System.out.println("check1");
		
		Session session=sf.openSession();
		System.out.println("check2");
		
		List<Persons> persons=session.createQuery(" delete from Persons where iam_name = :name ").list();
		System.out.println("check3");
		;
		
		PrintWriter pw = response.getWriter();
		pw.println("<html><body>");
		pw.println("<p> deleted</p>");
		pw.println("</body></html>");
		
		System.out.println("check5");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
