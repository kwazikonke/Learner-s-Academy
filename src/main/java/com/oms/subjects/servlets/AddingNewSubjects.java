package com.oms.subjects.servlets;

import java.io.IOException;

import com.oms.models.Subjects;
import com.oms.services.SubjectsOperations;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddingNewSubjects
 */
@WebServlet("/AddingNewSubjects")
public class AddingNewSubjects extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddingNewSubjects() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subjname = request.getParameter("txtSubjName");
		String subjdesc = request.getParameter("txtSubjDesc");
		
		response.setContentType("text/html");
		SubjectsOperations sbo = new SubjectsOperations();
		Subjects sbj = new Subjects();
		try {
			
			sbj.setSubjName(subjname);
			sbj.setSubjDesc(subjdesc);
			
           String res = sbo.AddSubjects(sbj); 
			
			if(res.equals("Successfully"))
			{
				response.sendRedirect("ListOfAllSubjects");
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
