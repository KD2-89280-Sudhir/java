package com.assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class BookDB {
	
	public static List<Book> booklist = new ArrayList<>();
	public static Scanner sc = new Scanner(System.in);
	
	public static Book [] getInstance() {
		Book [] arr = new Book[2];
		arr[0] = new Book("15", "rakesh", 10, 200.00);
		arr[1] = new Book("12", "aakesh", 20, 400.00);
		return arr;
	}
	public static int menuList() {
		int choice;
		System.out.println("*****************************");
		System.out.println("0. Exit");
		System.out.println("1. Add book in list");
		System.out.println("2. Display all books in forward order");
		System.out.println("3. Display all books in backward order");
		System.out.println("4. Delete a book at given index");
		System.out.println("*****************************");
		choice = sc.nextInt();
		return choice;
	}
	
	public static void addDummyBook(Book [] book) {
		for(Book b : book) {
			booklist.add(b);
		}
	}
	public static void addBook() {
		Book temp = new Book();
		System.out.println("Accept the book data");
		System.out.print("Enter the book isbn: ");
		temp.setIsbn( sc.next());
		System.out.print("Enter the book author name: ");
		temp.setAuthorName( sc.next());
		System.out.print("Enter the book price: ");
		temp.setPrice( sc.nextDouble());
		System.out.print("Enter the book quantity: ");
		temp.setQuantity( sc.nextInt());
		booklist.add(temp);
	}
	public static void displayAllBookForward() {
		Collections.sort(booklist);
		Iterator<Book> itr = booklist.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next().toString());
		}
	}
	public static void displayAllBookBackward() {
		ListIterator<Book> itr = booklist.listIterator(booklist.size());
		while(itr.hasPrevious()) {
			System.out.println(itr.previous().toString());
		}
	}
	public static boolean deletebook(int bookindex) {
		booklist.remove(bookindex-1);
		return false;
		
	}
	public static void acceptisbn(int [] b) {
		System.out.println("Enter the book index: ");
		for(int i = 0; i < booklist.size(); i++) {
			System.out.printf("Index: %d\t", i+1);
			Book tempb = booklist.get(i);
			System.out.println(tempb.toString());
		}
		
		b[0] = sc.nextInt();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choice;
		int [] bookisbn = new int[1];
		addDummyBook(getInstance());
		while((choice = menuList()) != 0){
			switch(choice){
				case 1: 
					addBook();
					break;
				case 2:
					displayAllBookForward();
					break;
				case 3:
					displayAllBookBackward();
					break;
				case 4: 
					acceptisbn(bookisbn);
					deletebook(bookisbn[0]);
					break;
				default:
					System.out.println("Wrong choice");
					break;
			}
		}

	}

}