package com.tns.di;

public class Student 
{
	private String studentName;
    private int id;

	public void setId(int id) {
		this.id = id;
	}

	public void setStudentName(String studentName) 
	{
		this.studentName = studentName;
	}

	public void disp()
	{
		System.out.println("Student name is :" +studentName + "and id is " +id);
	}

}
