package com.oms.student.servlets;

import java.io.IOException;

import com.oms.models.Student;
import com.oms.services.StudentOperations;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddingNewStudent
 */
@WebServlet("/AddingNewStudent")
public class AddingNewStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddingNewStudent() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sfname = request.getParameter("txtStdFirstName");
		String slname = request.getParameter("txtStdLastName");
	
		response.setContentType("text/html");
		//PrintWriter out= response.getWriter();
		
		StudentOperations so = new StudentOperations();
		Student std = new Student();
		
		try {
			std.setStudentFirstName(sfname);
			std.setStudentLastName(slname);
			
         String result=so.AddNewStudent(std); 
			
			if(result.equals("Successfully"))
			{
				response.sendRedirect("ListOfAll");
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
