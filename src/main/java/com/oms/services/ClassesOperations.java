package com.oms.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.oms.dbconn.DbConnection;
import com.oms.models.Classes;

public class ClassesOperations {
	
 private Connection conObj = null;
     
     public ClassesOperations() {
    	 conObj = DbConnection.getConnection();
     }
     // Adding Classes
     //public String AddClasses(Classes cl, int teacherId) {
       public String AddClasses(Classes cl) {
        	 
    	 String result = "Error";
    	 
    	try {
    	String sql="Insert into Classes(className,classDesc,classRoomNo) value(?,?,?)";
    	PreparedStatement ps = conObj.prepareStatement(sql);
    	
    	ps.setString(1, cl.getClassName());
    	ps.setString(2, cl.getClassDesc());
    	ps.setInt(3, cl.getClassRoomNo());
    	//ps.setInt(3, cl.getTeacherId());
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
     // Updating Classes
     
     public String Updating(Classes cl) {
    	 String result ="Error";
    	 try {
    	 PreparedStatement ps=conObj.prepareStatement("update Classes set className=? where classId=?");
    	 ps.setString(1, cl.getClassName());
    	 ps.setInt(2, cl.getClassId());
    	 
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
     // Deleting Classes
     public String DeleteClass(int classId) {
    	 String result="Error";
    	 
    	 try {
    		 PreparedStatement ps = conObj.prepareStatement("Delete from Classes where classId=?");
    		 ps.setInt(1, classId);
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
     // Listing all classes
     public List<Classes> ListAllClass() {
    	List<Classes> list = new ArrayList<Classes>();
    	Classes cl = null;
    	try {
    		PreparedStatement ps = conObj.prepareStatement("select * from Classes");
    		ResultSet st = ps.executeQuery();
    		
    		while(st.next()) {
    		 cl = new Classes();
    		 cl.setClassId(st.getInt("classId"));
    		 cl.setClassName(st.getString("className"));
    		 cl.setClassDesc(st.getString("classDesc"));
    		 cl.setClassRoomNo(st.getInt("classRoomNo"));
    		 //int teacherId = st.getInt("teacherId");
    		 //Teachers teacher = fetchTeacherById(teacherId);
    		 //cl.setTeacher(teacher);
    		 list.add(cl);
    		}
    	}
    	catch(Exception ex) {
    		ex.printStackTrace();
    	}
    	return list;
     }
}  
  //   private Teachers fetchTeacherById(int teacherId) {
    //	    Teachers teacher = null;
    	//    try {
    	  //      PreparedStatement ps = conObj.prepareStatement("select * from Teachers where teacherId = ?");
    	    //    ps.setInt(1, teacherId);
    	      //  ResultSet rs = ps.executeQuery();
    	        
    	        //if (rs.next()) {
    	          //  teacher = new Teachers();
    	            //teacher.setTeacherId(rs.getInt("teacherId"));
    	            //teacher.setTeachFullName(rs.getString("teachFullName"));
    	  
    	        //}
    	    //} catch (Exception e) {
    	      //  e.printStackTrace();
    	    //}
    	    //return teacher;
//    	}
//}

