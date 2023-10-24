package com.oms.teacher.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.oms.models.Teachers;
import com.oms.services.TeachersOperations;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Updating
 */
@WebServlet("/Updating")
public class Updating extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updating() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		TeachersOperations to = new TeachersOperations();
		
        int teacherId= Integer.parseInt(request.getParameter("tId"));
		
		Teachers teacher = new Teachers();
		teacher.setTeacherId(teacherId);
		
		try {
			
				
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
