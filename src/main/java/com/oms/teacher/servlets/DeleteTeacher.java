package com.oms.teacher.servlets;

import java.io.IOException;

import com.oms.services.TeachersOperations;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteTeacher
 */
@WebServlet("/DeleteTeacher")
public class DeleteTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DeleteTeacher() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
		
		String teacherId= request.getParameter("tId");
		
		int tId=Integer.parseInt(teacherId);
		
		TeachersOperations to = new TeachersOperations();
		
		if(to.DeleteTeacher(tId).equals("Successfully"))
		{
			response.sendRedirect("ListOfAllTeachers");
		}
	}

}
