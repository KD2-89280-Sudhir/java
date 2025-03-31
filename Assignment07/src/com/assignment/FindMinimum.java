package com.assignment;
public class FindMinimum {

	public static <T extends Number> int minFind(T[] a) {
		double min = a[0].doubleValue();
		for(int i = 0; i < a.length; i++) {
			if(min > a[i].doubleValue()) {
				min = a[i].doubleValue();
			}
		}
		return (int)min;
	}
	public static void main(String[] args) {
		Integer[] arr = {9,1,3,4,5};
		Double[] arr1 = {9.0,2.0,3.0,4.0,5.0};
		Long [] arr2 = {(long) 1, (long)2, (long)5};
		Byte [] arr3 = {(byte) 1, (byte)2, (byte)5};
		Short [] arr4 = {(short) 1, (short)2, (short)5};
		System.out.println("Integer: "+FindMinimum.minFind(arr));
		System.out.println("Double: "+FindMinimum.minFind(arr1));
		System.out.println("Long: "+FindMinimum.minFind(arr2));
		System.out.println("Byte: "+FindMinimum.minFind(arr3));
		System.out.println("Short: "+FindMinimum.minFind(arr4));
		
	}

}
