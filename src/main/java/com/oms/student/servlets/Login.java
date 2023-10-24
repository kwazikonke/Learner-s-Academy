package com.oms.student.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("txtUserId");
		String password=request.getParameter("txtpassword");
		
      jakarta.servlet.RequestDispatcher rd=null;
		
		if(username.equalsIgnoreCase("Admin@gmail.com") && password.equals("1234")) {
			rd=request.getRequestDispatcher("DashBoard.html");
			rd.forward(request, response);	
		}
		else {
			rd=request.getRequestDispatcher("AdminLogin.html");
			PrintWriter out=response.getWriter();
			rd.include(request, response);
			out.println("<center> <span style='color:red'>Invalid Login</span></center>");
			
		}
		
	}

}
