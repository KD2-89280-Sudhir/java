package com.assignment;

public class Student implements Comparable<Student> {
	private int rollno;
	private String name;
	private double marks;
	
	public Student() {
		
	}
	public Student(int rollno, String name, double marks) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.marks = marks;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	
	public String toString() {
		return String.format("%-20d%-15s%10.2f", rollno, name, marks);
	}
	
	@Override
	public boolean equals(Object s) {
		if(s == null)
			return false;
		if(this == s)
			return true;
		if(!(s instanceof Student)) {
			return false;
		}
		Student temp = (Student) s;
		if(this.rollno == temp.rollno) {
			return true;
		}
		return false;
	}
	@Override
	public int compareTo(Student s) {
		return this.rollno - s.rollno;
	}
	

	
}
