package com.oms.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Teachers {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private  int teacherId;
   private String teachFullName;
   private String Email;
   private String className;
   
public Teachers() {
	super();
	// TODO Auto-generated constructor stub
 }

public Teachers(int teacherId, String teachFullName, String email, String className) {
	super();
	this.teacherId = teacherId;
	this.teachFullName = teachFullName;
	Email = email;
	this.className = className;
}

public int getTeacherId() {
	return teacherId;
}

public void setTeacherId(int teacherId) {
	this.teacherId = teacherId;
}

public String getTeachFullName() {
	return teachFullName;
}

public void setTeachFullName(String teachFullName) {
	this.teachFullName = teachFullName;
}

public String getEmail() {
	return Email;
}

public void setEmail(String email) {
	Email = email;
}

public String getClassName() {
	return className;
}

public void setClassName(String className) {
	this.className = className;
}

@Override
public String toString() {
	return "Teachers [teacherId=" + teacherId + ", teachFullName=" + teachFullName + ", Email=" + Email + ", className="
			+ className + "]";
}

}