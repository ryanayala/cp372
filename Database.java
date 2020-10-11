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
    	if (list.equals("")){
    		return "Nothing found.";
    	}
    	return list;
    }
    /* 
	 * @
	 */
    public String delete(String data[]) {
    	
    	node prev = null;
    	node temp = front;
    	int numDel = 0;
    	String deleted = "Nothing to delete";
    	while(temp != null) { 
    		if ((data[1].equals("") || data[1].equals(temp.getIsbn())) &&
			(data[2].equals("") || data[2].equals(temp.getAuthor())) &&
			(data[3].equals("") || data[3].equals(temp.getTitle())) &&
			(data[4].equals("") || data[4].equals(temp.getPublisher())) &&
			(data[5].equals("") || data[5].equals(temp.getYear()))
    				) 
    				{
    			//saves the node info in string ending with \n
    			if (front == temp) {
    				front = temp.next;
    			} else {
    				if (prev != null) {
    					prev.next = temp.next;
    				}
    				
    			} if (back == temp) {
    				if (!back.equals(front)) {
    					back = prev;
    				} else {
    					back = null;
    					front = null;
    				}
    			}
    			numDel+=1;
    		}
    		if (front == null) {
    			back = null;
    		}
    		prev = temp;
    		temp = temp.next;
    		
    	}
    	if (numDel > 0) deleted = "Number of Items deleted: "+ Integer.toString(numDel);
    	return deleted;
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
    	
    	return "Empty Database";
    }
}
