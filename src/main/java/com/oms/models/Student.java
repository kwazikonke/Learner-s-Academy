package com.oms.models;

public class Student {
	
	private int stdNo;
	private String studentFirstName;
	private String studentLastName;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int stdNo, String studentFirstName, String studentLastName) {
		super();
		this.stdNo = stdNo;
		this.studentFirstName = studentFirstName;
		this.studentLastName = studentLastName;
		
	}
	public int getStdNo() {
		return stdNo;
	}
	public void setStdNo(int stdNo) {
		this.stdNo = stdNo;
	}
	public String getStudentFirstName() {
		return studentFirstName;
	}
	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}
	public String getStudentLastName() {
		return studentLastName;
	}
	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}
	@Override
	public String toString() {
		return "Student [stdNo=" + stdNo + ", studentFirstName=" + studentFirstName + ", studentLastName="
				+ studentLastName + "]";
	}
	
}