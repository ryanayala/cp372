package objectHolder;

public class node {
	private String isbn = null;
	private String author = null;
	private String title = null;
	private String publisher = null;
	private String year = null;
	
	public node next = null;
	
	public node(String data[]) {
		isbn = data[1];
		author = data[2];
		title = data[3];
		publisher = data[4];
		year = data[5];
	}
	public String getIsbn() {
		return isbn;
	}
	public String getAuthor() {
		return author;
	}
	public String getTitle() {
		return title;
	}
	public String getPublisher() {
		return publisher;
	}
	public String getYear() {
		return year;
	}
	public void setIsbn(String aIsbn) {
		isbn = aIsbn;
	}
	public void setAuthor(String aAuthor) {
		author = aAuthor;
	}
	public void setTitle(String aTitle) {
		title = aTitle;
	}
	public void setPublisher(String aPublisher) {
		publisher = aPublisher;
	}
	public void setYear(String aYear) {
		year = aYear;
	}
	
}
