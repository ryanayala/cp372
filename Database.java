package server;

/* @Author: Colin Morenz 180320150
 * @Date: 6th October 2020
 * 
 * @Description:Main database that maintains the data links and data.
 * -searchIsbn *helper method.
 * -search: searches for node containing data that matching all the attributes not an empty string.
 * -insert: check to see if it already exists, if not adds it to the end of the link.
 * -delete: deletes all nodes that match all filled in attributes.
 * -editDatabase: edits the attributes of a given isbn.
 * -popularAuthor: returns the most common author.
 */
public class Database {
		
	public node front = null;
	public node back = null;
	public int bookNum = 0;
	/* 
	 * @description: constructor class.
	 */
	public Database() {
	}
	/* 
	 * @
	 */
    public node searchIsbn(String isbn) {
    	
    	node temp = front;
    	while(temp != null) {
    		if(temp.getIsbn().equals(isbn)) {
    			return temp;
    		}
    		
    		temp=temp.next;
    	}
    	return null;
    }
    /* 
	 * @
	 */
    public boolean insert(String data[]) {
    	
		node temp = this.searchIsbn(data[1]);
		if (temp != null) {
    		return false;
    	}
		
		temp = new node(data);
		if (front == null) {
			front = temp;
		}
		
		if (back != null) {
			back.next = temp;
			back = back.next;
		} else {
			back = temp;
		}
		
		bookNum+=1;
		return true;	
	}
    /* 
	 * @
	 */
    public String search(String data[]) {
    	
    	String list = "";
    	node temp = front;
    	while(temp != null) { 
    		if ((data[1].equals("") || data[1].equals(temp.getIsbn())) &&
			(data[2].equals("") || data[2].equals(temp.getAuthor())) &&
			(data[3].equals("") || data[3].equals(temp.getTitle())) &&
			(data[4].equals("") || data[4].equals(temp.getPublisher())) &&
			(data[5].equals("") || data[5].equals(temp.getYear()))) {
    			//saves the node info in string ending with \n
    			list = list + temp.getIsbn()+","+temp.getAuthor()+","+temp.getTitle()+","+temp.getPublisher()+","+temp.getYear()+"\n";
    		}
    		temp = temp.next;
    	}
    	return list;
    }
    /* 
	 * @
	 */
    public boolean delete(String data[]) {
    	
    	node prev = null;
    	node temp = front;
    	while(temp != null) { 
    		if ((data[1] == ("") || data[1] == (temp.getIsbn())) &&
			(data[2] == ("") || data[2] == (temp.getAuthor())) &&
			(data[3] == ("") || data[3] == (temp.getTitle())) &&
			(data[4] == "" || data[4] == (temp.getPublisher())) &&
			(data[5] == "" || data[5] == (temp.getYear()))) {
    			//saves the node info in string ending with \n
    			if (front == temp) {
    				front = temp.next;
    			} else {
    				if (prev != null) {
    					prev.next = temp.next;
    				}
    				
    			} if (back == temp) {
    				back = prev;
    			}
    			
    		}
    		temp = temp.next;
    	}
    	return false;
    }
    /* 
	 * @
	 */
    public boolean editDatabase(String data[]) {
    	
    	node temp = this.searchIsbn(data[1]);
    	if (temp == null) {
    		return false;
    	}
    	
    	if(temp.getAuthor() != "") {
    		temp.setAuthor(data[2]);
    	}
    	
    	if(temp.getTitle() != "") {
    		temp.setTitle(data[3]);
    	}
    	
    	if(temp.getPublisher() != "") {
    		temp.setPublisher(data[4]);
    	}
    	
    	if(temp.getYear() != "") {
    		temp.setYear(data[5]);
    	}
    	
    	return true;
    }
    /* 
	 * @
	 */
    public String mostRecentlyAddedBook() {
    	
    	if (back != null) {
    		return back.getIsbn()+","+back.getAuthor()+","+back.getTitle()+","+back.getPublisher()+","+back.getYear();
    	}
    	
    	return "";
    }
}
