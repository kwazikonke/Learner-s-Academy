package com.oms.classes.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.oms.models.Classes;
import com.oms.services.ClassesOperations;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class IndexClass
 */
@WebServlet("/IndexClass")
public class IndexClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexClass() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ClassesOperations so = new ClassesOperations();
		try {
			List<Classes> list = so.ListAllClass();
			out.print("<a href='AddNewClass.html'style='color:black'>New Class</a> &nbsp; &nbsp; &nbsp;| &nbsp; &nbsp; &nbsp; <a href='IndexClass'style='color:black'>View All Classes</a> &nbsp; &nbsp; &nbsp;| &nbsp; &nbsp; &nbsp;<a href='DashBoard.html'style='color:black'>Dashboard</a> &nbsp; &nbsp; &nbsp;| &nbsp; &nbsp; &nbsp;<a href='Logout'style='color:black'>Log out</a> ");
			out.print("<br>");
			out.print("<hr>");
			out.print("<table width=100% border='1'>");
			out.print("<tr><th>Class ID</th><th>Class Name</th><th>Class Description</th><th>Class Room No</th></tr>");
			for(Classes cl:list) {
				
				out.print("<tr>");
				out.print("<td>"+cl.getClassId()+"</td>");
				out.print("<td>"+cl.getClassName()+"</td>");
				out.print("<td>"+cl.getClassDesc()+"</td>");
				out.print("<td>"+cl.getClassRoomNo()+"</td>");
				out.print("<td><a href='DeleteClass?Id="+cl.getClassId()+"'>Delete</a></td>");
				out.print("<td><a href='Updating?Id="+cl.getClassId()+"'>Assign Subject</a></td>");
				out.print("<td><a href='Updating?Id="+cl.getClassId()+"'>Assign Teacher</a></td>");
				
				
				
				out.print("</tr>");
			}
			out.print("</table>");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
