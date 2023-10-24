package com.oms.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int classId;

    private String className;

    private String classDesc;
    
    private int classRoomNo;

   // @ManyToOne
    //@JoinColumn(name = "teacherId")
    //private Teachers teacher; 
    
	public Classes() {
		super();
		// TODO Auto-generated constructor stub
	}

public Classes(int classId, String className, String classDesc, int classRoomNo) {
	super();
	this.classId = classId;
	this.className = className;
	this.classDesc = classDesc;
	this.classRoomNo = classRoomNo;
}

public int getClassId() {
	return classId;
}

public void setClassId(int classId) {
	this.classId = classId;
}

public String getClassName() {
	return className;
}

public void setClassName(String className) {
	this.className = className;
}

public String getClassDesc() {
	return classDesc;
}

public void setClassDesc(String classDesc) {
	this.classDesc = classDesc;
}

public int getClassRoomNo() {
	return classRoomNo;
}

public void setClassRoomNo(int classRoomNo) {
	this.classRoomNo = classRoomNo;
}

@Override
public String toString() {
	return "Classes [classId=" + classId + ", className=" + className + ", classDesc=" + classDesc + ", classRoomNo="
			+ classRoomNo + "]";
}
	
}