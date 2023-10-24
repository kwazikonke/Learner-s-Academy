package com.oms.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.oms.dbconn.DbConnection;
import com.oms.models.Subjects;

public class SubjectsOperations {
	
     private Connection conObj = null;
     
     public SubjectsOperations() {
    	 conObj = DbConnection.getConnection();
     }
     // Adding Subjects
     public String AddSubjects(Subjects sbj) {
    	 
    	 String result = "Error";
    	 
    	try {
    	String sql= "Insert into Subjects(SubjName,subjDesc) values(?,?)";
    	PreparedStatement ps = conObj.prepareStatement(sql);
    	ps.setString(1, sbj.getSubjName());
    	ps.setString(2, sbj.getSubjDesc());
    	
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
     // Updating subjects
     
     public String Updating(Subjects sbj) {
    	 String result ="Error";
    	 try {
    	 PreparedStatement ps=conObj.prepareStatement("update Subjects set subjName=? where subjId=?");
    	 ps.setString(1, sbj.getSubjName());
    	 ps.setInt(2, sbj.getSubjId());
    	 
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
     // Deleting Subjects
     public String DeleteSubject(int subjId) {
    	 String result="Error";
    	 
    	 try {
    		 PreparedStatement ps = conObj.prepareStatement("Delete from Subjects where subjId=?");
    		 ps.setInt(1, subjId);
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
     // Listing all subjects
     public List<Subjects> ListAllSubj() {
    	 
    	List<Subjects> listsbj = new ArrayList<Subjects>();
    	
    	Subjects sbj = null;
    	try {
    		PreparedStatement ps = conObj.prepareStatement("select * from Subjects");
    		ResultSet st = ps.executeQuery();
    		while(st.next()) {
    		 sbj = new Subjects();
    		 sbj.setSubjId(st.getInt("subjId"));
    		 sbj.setSubjName(st.getString("subjName"));
    		 sbj.setSubjDesc(st.getString("subjDesc"));
    		 
    		 listsbj.add(sbj);
    		}
    	}
    	catch(Exception ex) {
    		ex.printStackTrace();
    	}
    	return listsbj;
     }
     
}
