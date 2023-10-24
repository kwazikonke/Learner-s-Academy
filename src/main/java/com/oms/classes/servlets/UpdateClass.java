package com.oms.classes.servlets;

import java.io.IOException;

import com.oms.models.Classes;
import com.oms.services.ClassesOperations;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateClass
 */
@WebServlet("/UpdateClass")
public class UpdateClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UpdateClass() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String className= request.getParameter("txtClassName");
		String classDesc= request.getParameter("txtClassDesc");
		String classId = request.getParameter("Id");
		int Id = Integer.parseInt(classId);
		
		ClassesOperations co = new ClassesOperations();
		Classes cl = new Classes();
		
		try {
			cl.setClassName(className);
			cl.setClassId(Id);
			cl.setClassDesc(classDesc);
			
			String result = co.Updating(cl);
			
			if(result.equals("Successfully")) {
				response.sendRedirect("IndexClass");
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
	}

}
