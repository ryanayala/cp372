package server;

/* @author: Colin Morenz 180320150
 * @date: October 6th 2020
 * @description: creates a node that contains 5 private values accessed by node methods
 * The node also keep track of the next node.
 * 
 */
public class node {
	private String isbn = null;//
	private String author = null;
	private String title = null;
	private String publisher = null;
	private String year = null;
	
	public node next = null;
	/* 
	 * @description: constructor that take in data to create a node, only the isbn needs to be filled to create a book.
	 */
	public node(String data[]) {
		isbn = data[1];
		author = data[2];
		title = data[3];
		publisher = data[4];
		year = data[5];
	}
	/* 
	 * @description: returns the unique isbn of the node.
	 */
	public String getIsbn() {
		return isbn;
	}
	/*
	 * @description: returns author of the book under this isbn.
	 */
	public String getAuthor() {
		return author;
	}
	/*
	 * @description: returns the title under this isbn.
	 */
	public String getTitle() {
		return title;
	}
	/*
	 * @description: returns the publisher of this book.
	 */
	public String getPublisher() {
		
		return publisher;
	}
	/* 
	 * @description: returns the year of publication of the book.
	 */
	public String getYear() {
		
		return year;
	}
	/* 
	 * @description: set the author, whether correction or set
	 */
	public void setAuthor(String aAuthor) {
		
		author = aAuthor;
	}
	/* 
	 * @description: set the title, whether correction or set
	 */
	public void setTitle(String aTitle) {
		
		title = aTitle;
	}
	/* 
	 * @description: set the publisher, whether correction or set
	 */
	public void setPublisher(String aPublisher) {
		
		publisher = aPublisher;
	}
	/* 
	 * @description: set the year, whether correction or set
	 */
	public void setYear(String aYear) {
		
		year = aYear;
	}
	
}
