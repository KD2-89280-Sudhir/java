package com.assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class TestProject {

	public static Set<Projects> projectSet = new HashSet<>();
	public static List<Projects> projectBKList = new ArrayList<>();
	public static Scanner sc = new Scanner(System.in);
	
	public static Projects[] getInstance() {
		Projects [] temp = new Projects[] {
			new Projects(1, "Train Reservation System",10, 5000000, "Java"), 
			new Projects(2, "Airline Reservation System",3, 6000000, ".NET"), 
			new Projects(4, "Online Grocery Shop", 6, 3000000, "Java"),
			new Projects(5, "Online Book Shop", 2, 3000000, ".NET"), 
			new Projects(3, "Online Jewelry Shop", 4, 4000000, "Java"), 
			new Projects(2, "Bus Reservation System", 3, 3500000, "JS"),	
		};
		return temp;
	}
	public static void addRecord(Projects [] temp) {
		for(Projects p : temp) {
			projectSet.add(p);
		}
	}
	public static void acceptRecord() {
		Projects temp = new Projects();
		System.out.print("Enter the Project id. : ");
		temp.setProjectid(sc.nextInt());
		System.out.print("Enter the Project Title : ");
		temp.setTitle(sc.next());
		System.out.print("Enter the Project team size : ");
		temp.setTeamsize(sc.nextInt());
		System.out.print("Enter the Project Cost : ");
		temp.setProjectCost(sc.nextDouble());
		System.out.print("Enter the Project Technology : ");
		temp.setTechnology(sc.next());
		projectSet.add(temp);
	}
	public static int menuList() {
		int choice;
		System.out.println();
		System.out.println("*************************************");
		System.out.println("0. Exit");
		System.out.println("1. Add Dummy data to set");
		System.out.println("2. Add Project to DB");
		System.out.println("3. Display All Projects in set");
		System.out.println("4. Delete all projects in set");
		System.out.println("5. Copy All Projects from Set to ArrayList");
		System.out.println("6. Display all projects in list");
		System.out.println("7. Sort all projects in arrayList by cost");
		System.out.println("*************************************");
		choice = sc.nextInt();
		return choice;
	}
	
	public static void printAllRecords() {
		System.out.println();
		for(Projects p: projectSet) {
			System.out.println();
			System.out.println(p.toString());
		}
	}
	
	public static void printAllRecordInList() {
		System.out.println();
		for(Projects p: projectBKList) {
			System.out.println();
			System.out.println(p.toString());
		}
	}
	
	public static void copyAllRecords() {
		for(Projects p: projectSet) {
			System.out.println("Copy this..");
			System.out.println();
			System.out.println(p.toString());
			projectBKList.add(p);
			
		}
	}
	public static boolean deleteRecord(int pid) {
		Projects key = new Projects();
		key.setProjectid(pid);
		if(projectSet.contains(key)) {
			projectSet.remove(key);
			System.out.println("Project deletes");
		}
		return false;
	}
	
	public static void acceptProjectId(int [] temp) {
		System.out.print("Enter the project id to find: ");
		temp[0] = sc.nextInt();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		class SortByCostComparator implements Comparator<Projects>{

			@Override
			public int compare(Projects p1, Projects p2) {
				return (int)(p1.getProjectCost() - p2.getProjectCost());
			
			}

		}
		int [] pid = new int[1];
		
		int choice;
		while((choice = menuList()) != 0) {
			switch(choice) {
			case 1: 
				System.out.println("Adding the dummy data.......");
				Projects [] temp = getInstance();
				addRecord(temp);
				break;
			case 2: 
				System.out.println("Accept the Project Record..........");
				acceptRecord();
				break;
			case 3: 
				System.out.println("Display all projects in set");
				printAllRecords();
				break;
			case 4: 
				System.out.print("Delete a project by id: ");
				acceptProjectId(pid);
				deleteRecord(pid[0]);
				break;
			case 5: 
				System.out.print("Copy all projects from set to arrayList: ");
				copyAllRecords();
				break;
			case 6: 
				System.out.print("Display all projects from arrayList: ");
				printAllRecordInList();
				break;
			case 7: 
				System.out.print("Sort all projects in arrayList by cost: ");
				Collections.sort(projectBKList, new SortByCostComparator());
				break;
			default: 
				System.out.println("Wrong choice!!!!!");
			}
		}
	}

}
