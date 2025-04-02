package com.assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class TestProgram {
	public static List<Student> studentList = new ArrayList<>();
	public static Scanner sc = new Scanner(System.in);
	
	public static Student getInstance() {
		Student temp = new Student();
		System.out.print("Enter the Roll no. : ");
		temp.setRollno(sc.nextInt());
		System.out.print("Enter the Student Name. : ");
		temp.setName(sc.next());
		System.out.print("Enter the Student marks : ");
		temp.setMarks(sc.nextDouble());
		return temp;
	}
	public static void addRecord(Student temp) {
		studentList.add(temp);
	}
	
	public static void printRecord(Student temp) {
		if(temp != null) {
			System.out.print(temp.toString());
		}else {
		System.out.println("Invalid Student!!!!");
		}
	}
	
	public static void printAllRecord() {
		Iterator<Student> trav = studentList.iterator();
		while(trav.hasNext()) {
			System.out.println(trav.next());
		}
	}
	
	public static void acceptRollNo(int [] r) {
		System.out.print("Enter the roll no of student to find: ");
		r[0] = sc.nextInt();
	}
	public static Student findStudent(int rollno) {
		Student key = new Student();
		key.setRollno(rollno);
		if(studentList.contains(key)) {
			int index = studentList.indexOf(key);
			return studentList.get(index);
		}
		return null;
	}
	public static int menuList() {
		int choice;
		System.out.println();
		System.out.println("*************************************");
		System.out.println("0. Exit");
		System.out.println("1. Add Student to dbList");
		System.out.println("2. Search the Student by rollno");
		System.out.println("3. sort the students on rollno");
		System.out.println("4. sort the students on name");
		System.out.println("5. sort the students on marks");
		System.out.println("*************************************");
		choice = sc.nextInt();
		return choice;
	}
	
	
	public static void main(String[] args) {
		class SortByNameComparator implements Comparator<Student>{

			@Override
			public int compare(Student s1, Student s2) {
				return s1.getName().compareToIgnoreCase(s2.getName());
			}
			
		}
		class SortByMarksComparator implements Comparator<Student>{

			@Override
			public int compare(Student s1, Student s2) {
				return Double.compare(s1.getMarks(), s2.getMarks());
			}
			
		}
		// TODO Auto-generated method stub
		int [] rollno = new int[1];
		Student temp = null;
		int choice;
		while((choice = menuList()) != 0) {
			switch(choice) {
			case 1: 
				System.out.println("Adding the Student details.......");
				temp = getInstance();
				addRecord(temp);
				break;
			case 2: 
				System.out.println("Search the student..........");
				acceptRollNo(rollno);
				Student check = findStudent(rollno[0]);
				printRecord(check);
				break;
			case 3: 
				System.out.println("Sort the student on rollno");
				Collections.sort(studentList);
				printAllRecord();
				break;
			case 4: 
				System.out.print("Sort the student on name");
				Collections.sort(studentList, new SortByNameComparator());
				printAllRecord();
				break;
			case 5: 
				System.out.print("Sort the student on marks");
				Collections.sort(studentList, new SortByMarksComparator());
				printAllRecord();
				break;
			default: 
				System.out.println("Wrong choice!!!!!");
			}
		}

	}

}
