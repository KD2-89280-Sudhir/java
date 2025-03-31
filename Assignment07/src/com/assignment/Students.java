package com.assignment;

import java.util.Arrays;
import java.util.Comparator;

class Student implements Comparable<Student>{
	private int roll; 
	private String name; 
	private String city; 
	private double marks;
	
	public Student() {
		
	}
	public Student(int roll, String name, String city, double marks) {
		this.roll = roll;
		this.name = name.toUpperCase();
		this.city = city.toUpperCase();
		this.marks = marks;
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	public String toString() {
		return String.format("Roll: %d\t Name: %s\t City: %s\t Marks: %f\t", roll, name, city, marks);
	}
	@Override
	public int compareTo(Student o) {
		int diff = this.getRoll() - o.getRoll();
		return diff;
	}
}

public class Students{

	public static Student [] getInstance() {
		Student [] arr = new Student[] {
		new Student(1, "sudhir", "PNP", 20),
		new Student(2, "aman", "DL", 30),
		new Student(5, "niraj", "DL", 50),
		new Student(4, "umo", "DL", 50),
		new Student(1, "audhir", "PNP", 20),
        new Student(2, "Aman", "DL", 30),
        new Student(3, "Raj", "PNP", 40),
        new Student(4, "Umo", "DL", 50),
        new Student(5, "Nisaj", "DL", 50),
        new Student(6, "Vikram", "PNP", 25),
        new Student(7, "Kiran", "BLR", 35),
        new Student(8, "Suman", "BLR", 35)
		};
		return arr;
	}
	
	public static void main(String[] args) {
		Student[] a = getInstance();
		
		class MultiLevelSorting implements Comparator<Student>{
			@Override
			public int compare(Student s1, Student s2) {
				int diff = s2.getCity().compareTo(s1.getCity());
				if(diff == 0) {
					diff = (int) (s2.getMarks() - s1.getMarks());
				}
				if(diff == 0) {
					diff = s1.getName().compareTo(s2.getName());
				}
				return diff;
			}
			
		}
		
		Comparator<Student> s = new MultiLevelSorting();
		for(int i = 0; i < a.length; i++) {
			System.out.println(a[i].toString());
		}
		System.out.println();
		Arrays.sort(a, s);
		for(int i = 0; i < a.length; i++) {
			System.out.println(a[i].toString());
		}
	}

}
