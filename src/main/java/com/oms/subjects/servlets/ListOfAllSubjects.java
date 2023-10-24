package com.oms.subjects.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.oms.models.Subjects;
import com.oms.services.SubjectsOperations;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListOfAllSubjects
 */
@WebServlet("/ListOfAllSubjects")
public class ListOfAllSubjects extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ListOfAllSubjects() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		SubjectsOperations sbo = new SubjectsOperations();
		
		try {
			List<Subjects> listsbj = sbo.ListAllSubj();
			out.print("<a href='AddNewSubject.html'style='color:black'>New Subject</a> &nbsp; &nbsp; &nbsp;| &nbsp; &nbsp; &nbsp; <a href='ListOfAllSubjects'style='color:black'>View All Subjects</a>&nbsp; &nbsp; &nbsp;| &nbsp; &nbsp; &nbsp;<a href='DashBoard.html'style='color:black'>Dashboard</a>  &nbsp; &nbsp; &nbsp;| &nbsp; &nbsp; &nbsp;<a href='Login.html'style='color:black'>Log out</a> ");
			out.print("<br>");
			out.print("<hr>");
			out.print("<table width=100% border='1'>");
			out.print("<tr><th>Subject ID</th><th>Subject Name</th><th>Subject Description</th></tr>");
			
			for (Subjects sbj:listsbj) {
				out.print("<tr>");
				out.print("<td>"+sbj.getSubjId()+"</td>");
				out.print("<td>"+sbj.getSubjName()+"</td>");
				out.print("<td>"+sbj.getSubjDesc()+"</td>");
				out.print("<td><a href='DeleteSubject?subjid="+sbj.getSubjId()+"'>Delete</a></td>");
				out.print("<td><a href='Updating?subjid="+sbj.getSubjId()+"'>Update</a></td>");
				
				out.print("</tr>");
			}
			out.print("</table>");	
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
