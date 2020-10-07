package protocolproject;
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
        String command[] = {"","","","",""};
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
    	    int numYear = Integer.parseInt(year);
    	    Integer.parseInt(isbn);
    	    if ((isbn.length() == 13 && numYear >= 2007) || ((isbn.length() == 10 && numYear <= 2007))) {
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
    
    public String[] searchDatabase(Object Item, String[] parameters) {
    	String result[] = null;
    	//object method call.
    	return result;
    }
    
    public boolean editDatabase(Object item, String[] parameters) {
    	boolean editMade = false;
    	//call object method so search return object, and than edit object.
    	return editMade;
    }
    
}
/*action = Character.toString(theInput.charAt(0));
subString = theInput.substring(theInput.indexOf(',')+1);
isbn = subString.substring(0,subString.indexOf(',')-1);
String isbn = null;
String subString = null;

*/
