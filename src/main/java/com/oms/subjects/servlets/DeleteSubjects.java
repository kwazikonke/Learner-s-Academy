package com.oms.subjects.servlets;

import java.io.IOException;

import com.oms.services.SubjectsOperations;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteSubjects
 */
@WebServlet("/DeleteSubjects")
public class DeleteSubjects extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DeleteSubjects() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
		
		String subjId= request.getParameter("subjid");
		
		int subjid=Integer.parseInt(subjId);
		SubjectsOperations so = new SubjectsOperations();
		
		if(so.DeleteSubject(subjid).equals("Successfully"))
		{
			response.sendRedirect("ListOfAllSubj");
		}
	}

}
