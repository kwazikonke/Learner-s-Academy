package com.oms.teacher.servlets;

import java.io.IOException;

import com.oms.models.Teachers;
import com.oms.services.TeachersOperations;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddingNewTeacher
 */
@WebServlet("/AddingNewTeacher")
public class AddingNewTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddingNewTeacher() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tfullname = request.getParameter("txtFullName");
		String email = request.getParameter("txtEmail");
		String classname= request.getParameter("txtClassName");
		
		response.setContentType("text/html");
		TeachersOperations to = new TeachersOperations();
		Teachers teacher= new Teachers();
		try {
			teacher.setTeachFullName(tfullname);
			teacher.setEmail(email);
			teacher.setClassName(classname);
			
			String result = to.AddTeachers(teacher);
			
			if(result.equals("Successfully")) {
				
				response.sendRedirect("ListOfAllTeachers");
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
