package com.oms.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.oms.dbconn.DbConnection;
import com.oms.models.Teachers;

public class TeachersOperations {
	
 private Connection conObj = null;
     
     public TeachersOperations() {
    	 conObj = DbConnection.getConnection();
     }
     
     // Adding Teachers
     public String AddTeachers(Teachers teacher) {
    	 String result = "Error";
    	 
    	try {
    	String sql="Insert into Teachers(teachFullName,Email,className) value(?,?,?)";
    	PreparedStatement ps = conObj.prepareStatement(sql);
    	
    	ps.setString(1, teacher.getTeachFullName());
    	ps.setString(2,teacher.getEmail());
    	ps.setString(3, teacher.getClassName());
    	
    	int r= ps.executeUpdate();
    	
    	if(r>=1) {
    		
    		result="Successfully";
    	   }
    	 }
    	 catch(Exception ex) {
    		 ex.printStackTrace();
    		 result= ex.getMessage();
    	 }
    	 return result;
     }
     // Updating Teachers
     
     public String Updating(Teachers teacher) {
    	 String result ="Error";
    	 try {
    	 PreparedStatement ps=conObj.prepareStatement("update Teachers set teachFullName=? where teacherId=?");
    	 
    	 ps.setString(1, teacher.getTeachFullName());
    	 ps.setInt(2, teacher.getTeacherId());
    	 
    	 int r = ps.executeUpdate();
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
     // Deleting Teachers
     public String DeleteTeacher(int teacherId) {
    	 String result="Error";
    	 
    	 try {
    		 PreparedStatement ps = conObj.prepareStatement("Delete from Teachers where teacherId=?");
    		 ps.setInt(1, teacherId);
    		 int r = ps.executeUpdate();
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
     // Listing all teachers
     public List<Teachers> ListAllTeachers() {
    	List<Teachers> list = new ArrayList<Teachers>();
    	
    	Teachers teacher = null;
    	try {
    		PreparedStatement ps = conObj.prepareStatement("select * from Teachers");
    		ResultSet st = ps.executeQuery();
    		while(st.next()) {
    			
    			teacher = new Teachers();
    			teacher.setTeacherId(st.getInt("teacherId"));
    			teacher.setTeachFullName(st.getString("teachFullName"));
    			teacher.setEmail(st.getString("Email"));
    			teacher.setClassName(st.getString("className"));
    			
    		 list.add(teacher);
    		}
    	}
    	catch(Exception ex) {
    		ex.printStackTrace();
    	}
    	return list;
     }
     
}
