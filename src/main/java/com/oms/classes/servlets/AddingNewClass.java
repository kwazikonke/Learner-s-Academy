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
 * Servlet implementation class AddingNewClass
 */
@WebServlet("/AddingNewClass")
public class AddingNewClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddingNewClass() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String className = request.getParameter("txtClassName");
		String classDesc = request.getParameter("txtClassDesc"); 
		int classRno =  Integer.parseInt(request.getParameter("txtRoomNo"));
		//int teacherId = Integer.parseInt(request.getParameter("teacherId")); 
		response.setContentType("text/html");
		
		ClassesOperations co = new ClassesOperations();
		Classes cl = new Classes();
		try {
			cl.setClassName(className);
			cl.setClassDesc(classDesc);
			cl.setClassRoomNo(classRno);
			//cl.setTeacher(teacherId);
			//String result = co.AddClasses(cl, teacherId);
			String result = co.AddClasses(cl);
			
			if (result.equals("Successfully")) {
				
				response.sendRedirect("IndexClass");
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
