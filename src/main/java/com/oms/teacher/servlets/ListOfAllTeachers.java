package com.oms.teacher.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.oms.models.Teachers;
import com.oms.services.TeachersOperations;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListOfAllTeachers
 */
@WebServlet("/ListOfAllTeachers")
public class ListOfAllTeachers extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ListOfAllTeachers() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		TeachersOperations to = new TeachersOperations();
		
		try {
			List<Teachers> list = to.ListAllTeachers();
	        out.print("<a href='AddNewTeacher.html'style='color:black'>New Teacher</a> &nbsp; &nbsp; &nbsp;| &nbsp; &nbsp; &nbsp; <a href='ListOfAllTeachers'style='color:black'>View All Teachers</a> &nbsp; &nbsp; &nbsp;| &nbsp; &nbsp; &nbsp;<a href='DashBoard.html'style='color:black'>Dashboard</a> &nbsp; &nbsp; &nbsp;| &nbsp; &nbsp; &nbsp;<a href='Login.html'style='color:black'>Log out</a>");
			out.print("<br>");
			out.print("<hr>");
			out.print("<table width=100% border='1'>");
			out.print("<tr><th>Teacher ID</th><th>Teacher Full Name</th><th>Email</th><th>Class Name</th></tr>");
			
			for(Teachers teacher:list) {
				out.print("<tr>");
				out.print("<td>"+teacher.getTeacherId()+"</td>");
				out.print("<td>"+teacher.getTeachFullName()+"</td>");
				out.print("<td>"+teacher.getEmail()+"</td>");
				out.print("<td>"+teacher.getClassName()+"</td>");
				out.print("<td><a href='DeleteTeacher?tId="+teacher.getTeacherId()+"'>Delete</a></td>");
				out.print("<td><a href='Updating?tId="+teacher.getTeacherId()+"'>Update</a></td>");
				
				out.print("</tr>");
			}
			out.print("</table>");	
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
