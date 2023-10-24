package com.oms.models;

public class Subjects {
	private int subjId;
	private String SubjName;
	private  String subjDesc;

public Subjects() {
	super();
	// TODO Auto-generated constructor stub
}
public Subjects(int subjId, String subjName, String subjDesc) {
	super();
	this.subjId = subjId;
	SubjName = subjName;
	this.subjDesc = subjDesc;
	
}
public int getSubjId() {
	return subjId;
}
public void setSubjId(int subjId) {
	this.subjId = subjId;
}
public String getSubjName() {
	return SubjName;
}
public void setSubjName(String subjName) {
	SubjName = subjName;
}
public String getSubjDesc() {
	return subjDesc;
}
public void setSubjDesc(String subjDesc) {
	this.subjDesc = subjDesc;
}
@Override
public String toString() {
	return "Subjects [subjId=" + subjId + ", SubjName=" + SubjName + ", subjDesc=" + subjDesc + "]";
}
}