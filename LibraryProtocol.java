package objectHolder;
import java.net.*;
import java.io.*;

public class LibraryProtocol {
	private static final int WAITFR = 0;      // wait for request.
    private static final int SHUTTINGDOWN = 1;//prepares to shutdown.
    
    private String commands = "SUEDP" ;
    
    int state = WAITFR;
    
    /* @method processes the given data
     *  returns a array of the command, ISBN, author, title, year 
     */
    public String[] processInput(String theInput) {
        String command[] = {"","","","","",""};
        String subString = theInput.toUpperCase();
        if (state == WAITFR && theInput.length() > 0) {
        	if ((theInput.charAt(0) !=',') && (commands.contains(Character.toString(theInput.charAt(0)).toUpperCase())) && (theInput.charAt(1) == ',') ) {
        		for (int i = 0; i < 5; i++) {
        			command[i] = subString.substring(0,subString.indexOf(',')-1);
        			subString = subString.substring(subString.indexOf(',')+1);
        		}
        	} else { return null; } // error in the first command.
        }
        return command;
    	}
    /* @method validated the ISBN
     * check to see if it length of 10 or 13 and year published.
     */
    public boolean validateIsbn(String isbn, String year) {//object array is just the filler
    	try {  
    	    Integer.parseInt(isbn);
    	    if ((isbn.length() == 13)) {
        		//requires algorithm to check isbn number
    	    	return true;
        	}
    	}catch(NumberFormatException e){  
        	    return false;  
      	    }
    	return false;
        }
    public boolean validateYear(String year) {
    	try {  
    	    int numYear = Integer.parseInt(year);
    	    if (numYear < 0 || numYear > 2020) { 
        		return true;
        	}
    	  } catch(NumberFormatException e){  
    	    return false;  
    	  }
    	return false;
    	}
    public boolean insert(Database database, String[] data) {
    	return database.insert(data);
    }
    public String searchDatabase(Database database, String[] data) {
    	return database.search(data);
    }
    public boolean editDatabase(Database database, String[] data) {	
    	return database.editDatabase(data);
    }
    public boolean deteleFromDatabase(Database database, String[] data) {
    	return database.delete(data);
    }
    public String mostRecent(Database database) {
    	return database.mostRecentlyAddedBook();
    }
    	
}

