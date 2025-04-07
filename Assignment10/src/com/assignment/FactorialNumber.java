package com.assignment;

import java.util.Scanner;
import java.util.stream.IntStream;

public class FactorialNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    
	    System.out.print("Enter the number of factiorials :");
	    int number = sc.nextInt();
	    
	    int value = IntStream.rangeClosed(1, number)
        .reduce(1, (a, b) -> a * b);
	    System.out.println(value);

	}

}
