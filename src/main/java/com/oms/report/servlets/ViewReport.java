package com.oms.report.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.oms.models.Student;
import com.oms.models.Subjects;
import com.oms.models.Teachers;
import com.oms.services.StudentOperations;
import com.oms.services.SubjectsOperations;
import com.oms.services.TeachersOperations;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewReport
 */
@WebServlet("/ViewReport")
public class ViewReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewReport() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		StudentOperations so = new StudentOperations();
		SubjectsOperations sbo = new SubjectsOperations();
		TeachersOperations to = new TeachersOperations();

		try {
			List<Student> liststd = so.listAll();
			  out.print("<center><h2><u>Student's Information</u></h2></center>");
			  out.print("<a href='DashBoard.html'style='color:black'>Dashboard</a> &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;| &nbsp; &nbsp; &nbsp;<a href='Logout'style='color:black'>Log out</a>");
			  out.print("<br>");
			  out.print("<br>");
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
				
				out.print("<br>");
				
				List<Subjects> listsbj = sbo.ListAllSubj();

				out.print("<center><h2><u>Subject's Information</u></h2></center>");
				//out.print("<a href='AddNewSubject.html'style='color:black'>New Subject</a>");
				
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
				
				out.print("<br>");
				
				List<Teachers> list = to.ListAllTeachers();

				out.print("<center><h2><u>Teacher's Information</u></h2></center>");
		       // out.print("<a href='AddNewTeacher.html'style='color:black'>New Teacher</a>");
				
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
