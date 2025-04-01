package com.assignment;

class Book implements Comparable<Book>{
	private String isbn;
	private String authorName;
	private int quantity;
	private double price;
	
	
	public Book() {
		
	}

	public Book(String isbn, String authorName, int quantity, double price) {
		this.isbn = isbn;
		this.authorName = authorName;
		this.quantity = quantity;
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(this == obj) {
			return true;
		}
		if(!(obj instanceof Book)) {
			return false;
		}
		Book e = (Book) obj;
		if(this.getIsbn() != e.getIsbn()) {
			return false;
		}
		return true;
	}
	@Override
	public int compareTo(Book o) {
		return this.getIsbn().compareTo(o.getIsbn());
	}
	public String toString() {
		return String.format("ISBN: %-20s\t Author Name: %-20s\t Quantity: %-10d\t Price: %10.2f\t", isbn, authorName, quantity, price);
	}
}
