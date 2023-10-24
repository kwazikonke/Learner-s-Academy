package com.oms.student.servlets;

import java.io.IOException;

import com.oms.services.StudentOperations;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteStudent
 */
@WebServlet("/DeleteStudent")
public class DeleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DeleteStudent() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
			
			String stdId= request.getParameter("stdid");
			
			int stdid=Integer.parseInt(stdId);
			StudentOperations so = new StudentOperations();
			
			if(so.DeleteStudent(stdid).equals("Successfully"))
			{
				response.sendRedirect("ListOfAll");
			}
	}

}
