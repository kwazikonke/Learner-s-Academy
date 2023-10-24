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
 * Servlet implementation class UpdateTeacher
 */
@WebServlet("/UpdateTeacher")
public class UpdateTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UpdateTeacher() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String teacherName= request.getParameter("txtFullName");
		String teachEmail= request.getParameter("txtEmail");
		int teacherId = Integer.parseInt(request.getParameter("tId"));
		
		TeachersOperations to = new TeachersOperations();
		Teachers teacher = new Teachers();
		
		try {
			teacher.setTeachFullName(teacherName);
			teacher.setEmail(teachEmail);
			teacher.setTeacherId(teacherId);
			String result = to.Updating(teacher);
			
			if(result.equals("Successfully")) {
				response.sendRedirect("ListOfAllClass");
			}
			else {
		        // Handle the case where the update was not successful
		        response.getWriter().write("Update failed. Result: " + result);
		    }
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

}
