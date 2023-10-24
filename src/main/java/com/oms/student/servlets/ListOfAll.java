package com.oms.student.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.oms.models.Student;
import com.oms.services.StudentOperations;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListOfAll
 */
@WebServlet("/ListOfAll")
public class ListOfAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ListOfAll() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		StudentOperations so = new StudentOperations();
		try {
			List<Student> liststd = so.listAll();
			  out.print("<a href='AddNewStudent.html'style='color:black'>New Student</a> &nbsp; &nbsp; &nbsp;| &nbsp; &nbsp; &nbsp; <a href='ListOfAll='color:black'>View All Students</a> &nbsp; &nbsp; &nbsp;| &nbsp; &nbsp; &nbsp;<a href='DashBoard.html'style='color:black'>Dashboard</a> &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;| &nbsp; &nbsp; &nbsp;<a href='Logout'style='color:black'>Log out</a>");
			  out.print("<br>");
			  out.print("<hr>");
			  out.print("<table width=100% border='1'>");
			  out.print("<tr><th>Student Number</th><th>First Name</th><th>Last Name</th></tr>");
				for(Student std:liststd) {
					out.print("<tr>");
					out.print("<td>"+std.getStdNo()+"</td>");
					out.print("<td>"+std.getStudentFirstName()+"</td>");
					out.print("<td>"+std.getStudentLastName()+"</td>");
					out.print("<td><a href='DeleteStudent?stdid="+std.getStdNo()+"'>Delete</a></td>");
					out.print("<td><a href='UpdatingStudent?stdid="+std.getStdNo()+"'>Update</a></td>");
					
					out.print("</tr>");
				}
				out.print("</table>");	
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
	}

}
