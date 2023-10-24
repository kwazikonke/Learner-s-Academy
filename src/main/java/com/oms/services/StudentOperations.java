package com.oms.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.oms.dbconn.DbConnection;
import com.oms.models.Student;

public class StudentOperations {

	private Connection conObj = null;
	
	public StudentOperations() {
		conObj = DbConnection.getConnection();
	}
	
	// Adding New Students
	public String AddNewStudent(Student std) {
		String result = "Error";
		try {
			String sql = "Insert into Student(studentFirstName,studentLastName) values(?,?)";
			PreparedStatement ps = conObj.prepareStatement(sql);
			
			ps.setString(1, std.getStudentFirstName());
			ps.setString(2, std.getStudentLastName());
			//ps.setInt(3, std.getClassId());
			
			int res = ps.executeUpdate();
			
			if (res>=1) {
				result= "Successfully";
			}
		}
		catch(Exception ex) {
			result = ex.getMessage();
			ex.printStackTrace();
		}
		return result;
	}
	// Updating Student's information
	
	public String UpdatingStudent(Student std) {
		String result ="Error";
		
		try {
			String sql ="update Student set stdFirstName=? where stdNo=?";
			PreparedStatement ps = conObj.prepareStatement(sql);
			
			int r =ps.executeUpdate();
			
			if (r>=1) {
				result="Successfully";
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
			result=ex.getMessage();
		}
		return result;
	}
	
	// Deleting Student
	public String DeleteStudent(int stdNo) {
		String result ="Error";
		try {
			String sql= "Delete from Student where stdNo=?";
			PreparedStatement ps = conObj.prepareStatement(sql);
			ps.setInt(1, stdNo);
			int r =ps.executeUpdate();
			
			if (r>=1) {
				result="Successfully";
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
			result = ex.getMessage();
		}
		return result;
	}
	
	// Showing List of all students
	public List<Student> listAll(){
		List<Student> liststd = new ArrayList<Student>();
		
		Student std = null;
		
		try {
			String sql = "select * from Student";
			PreparedStatement ps = conObj.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				std = new Student();
				std.setStdNo(rs.getInt("stdNo"));
				std.setStudentFirstName(rs.getString("studentFirstName"));
				std.setStudentLastName(rs.getString("studentLastName"));
				//std.setClassId(rs.getInt("classid"));
				// see
				//std.setClassId(rs.getInt("className"));
				liststd.add(std);
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return liststd;
	}
}
